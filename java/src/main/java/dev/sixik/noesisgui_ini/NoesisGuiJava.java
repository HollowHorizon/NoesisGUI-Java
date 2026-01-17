package dev.sixik.noesisgui_ini;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Locale;

public class NoesisGuiJava {

    private static boolean loaded = false;

    public static boolean IsLoaded() {
        return loaded;
    }

    public static void Initialize() {
        if (loaded) return;

        try {
            // 1. Определяем платформу
            Platform platform = detectPlatform();

            // 2. Создаём временную папку
            Path tempDir = Files.createTempDirectory("noesis_native_" + platform.name + "_");
            tempDir.toFile().deleteOnExit();

            // 3. Формируем список библиотек для конкретной платформы
            // Порядок важен: сначала зависимости (Noesis), потом JNI
            String[] libs = getLibraryNames(platform);

            // 4. Извлекаем и загружаем
            for (String libName : libs) {
                // Путь в ресурсах: /native/windows/Noesis.dll
                String resourcePath = "/native/" + platform.resourceDir + "/" + libName;
                Path extractionPath = tempDir.resolve(libName);

                extractLib(resourcePath, extractionPath);

                // Загружаем библиотеку по абсолютному пути
                System.load(extractionPath.toAbsolutePath().toString());
            }

            loaded = true;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Noesis native libs for current platform", e);
        }
    }

    private static void extractLib(String resourcePath, Path dst) throws Exception {
        try (InputStream in = NoesisGuiJava.class.getResourceAsStream(resourcePath)) {
            if (in == null) {
                throw new RuntimeException("Native resource not found: " + resourcePath);
            }
            Files.copy(in, dst, StandardCopyOption.REPLACE_EXISTING);
            // Удаляем файл при выходе, чтобы не мусорить в tmp
            dst.toFile().deleteOnExit();
        }
    }

    private static class Platform {
        String name;
        String resourceDir; // имя папки в ресурсах (windows, linux, macos)
        String libPrefix;   // "lib" для *nix
        String libExt;      // .dll, .so, .dylib

        Platform(String name, String resourceDir, String libPrefix, String libExt) {
            this.name = name;
            this.resourceDir = resourceDir;
            this.libPrefix = libPrefix;
            this.libExt = libExt;
        }
    }

    private static Platform detectPlatform() {
        String osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);

        if (osName.contains("win")) {
            return new Platform("windows", "windows", "", ".dll");
        } else if (osName.contains("mac") || osName.contains("darwin")) {
            // На Mac библиотеки обычно имеют префикс lib, даже если это JNI
            return new Platform("macos", "macos", "lib", ".dylib");
        } else if (osName.contains("nux") || osName.contains("nix")) {
            return new Platform("linux", "linux", "lib", ".so");
        } else {
            throw new UnsupportedOperationException("Unsupported OS: " + osName);
        }
    }

    private static String[] getLibraryNames(Platform platform) {
        // Формируем имена файлов.
        // CMake скрипт (стандартный) добавляет 'lib' для Linux/Mac к именам таргетов.
        // NoesisSDK:
        // Windows: Noesis.dll, NoesisApp.dll
        // Linux: libNoesis.so, libNoesisApp.so
        // Mac: libNoesis.dylib, libNoesisApp.dylib (обычно так, если скопированы из SDK/bin)

        // Наша библиотека JNI:
        // Windows: noesis_jni.dll
        // Linux: libnoesis_jni.so
        // Mac: libnoesis_jni.dylib

        String noesisLib = platform.libPrefix + "Noesis" + platform.libExt;
        String noesisAppLib = platform.libPrefix + "NoesisApp" + platform.libExt;
        String jniLib = platform.libPrefix + "noesis_jni" + platform.libExt;

        return new String[] {
                noesisLib,
                noesisAppLib,
                jniLib
        };
    }
}