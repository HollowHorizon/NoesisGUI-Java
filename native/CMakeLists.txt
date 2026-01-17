cmake_minimum_required(VERSION 3.20)
project(noesis_jni LANGUAGES CXX)

# C++ стандарт
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_POSITION_INDEPENDENT_CODE ON)

if(APPLE)
    add_compile_definitions(GL_SILENCE_DEPRECATION)
    # Определяем макрос, говорящий NoesisApp, что мы собираем его статически/внутрь
    add_compile_definitions(NS_APP_FRAMEWORK_STATIC)
endif()

# Определение платформы
if (WIN32)
    set(PLATFORM_NAME "windows")
    set(LIB_EXT ".dll")
    set(LIB_PREFIX "") 
elseif (APPLE)
    set(PLATFORM_NAME "macos")
    set(LIB_EXT ".dylib")
    set(LIB_PREFIX "") 
elseif (UNIX AND NOT APPLE)
    set(PLATFORM_NAME "linux")
    set(LIB_EXT ".so")
    set(LIB_PREFIX "lib")
else()
    message(FATAL_ERROR "Unsupported platform")
endif()

# Определение архитектуры
if (CMAKE_SYSTEM_PROCESSOR MATCHES "arm" OR CMAKE_SYSTEM_PROCESSOR MATCHES "aarch64")
    set(ARCH_NAME "arm64")
    if (APPLE)
         set(NOESIS_ARCH_DIR "macos") 
    else()
         set(NOESIS_ARCH_DIR "${PLATFORM_NAME}_arm64")
    endif()
else()
    set(ARCH_NAME "x86_64")
    if (APPLE)
         set(NOESIS_ARCH_DIR "macos")
    else()
         set(NOESIS_ARCH_DIR "${PLATFORM_NAME}_x86_64")
    endif()
endif()

message(STATUS "Configuring for ${PLATFORM_NAME} (${ARCH_NAME}) -> SDK Path: ${NOESIS_ARCH_DIR}")

# ====== ПУТИ ======

set(NATIVE_OUT_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../java/src/main/resources/native/${PLATFORM_NAME}")
set(NOESIS_SDK_DIR "${CMAKE_SOURCE_DIR}/NoesisSDK" CACHE PATH "Path to Noesis SDK")

find_package(JNI REQUIRED)

if (NOT EXISTS "${NOESIS_SDK_DIR}/Include")
    message(FATAL_ERROR "NOESIS_SDK_DIR (${NOESIS_SDK_DIR}) is wrong: Include/ not found")
endif()

set(NOESIS_BIN_DIR "${NOESIS_SDK_DIR}/Bin/${NOESIS_ARCH_DIR}")
set(NOESIS_LIB_DIR "${NOESIS_SDK_DIR}/Lib/${NOESIS_ARCH_DIR}")
set(PACKAGES_DIR "${NOESIS_SDK_DIR}/Packages")

# ====== INCLUDE ======
include_directories(
        ${NOESIS_SDK_DIR}/Include
        ${JNI_INCLUDE_DIRS}
        ${PACKAGES_DIR}
        ${PACKAGES_DIR}/App/ApplicationLauncher/Include
        ${PACKAGES_DIR}/App/Theme/Include
        ${PACKAGES_DIR}/App/Display/Include
        ${PACKAGES_DIR}/App/DisplayLauncher/Include
        ${PACKAGES_DIR}/App/Interactivity/Include
        ${PACKAGES_DIR}/App/MediaElement/Include
        ${PACKAGES_DIR}/App/Providers/Include
        ${PACKAGES_DIR}/App/Rive/Include
        ${PACKAGES_DIR}/App/RiveBase/Include
        ${PACKAGES_DIR}/App/Shaders/Include
        ${PACKAGES_DIR}/App/LangServer/Include
        ${PACKAGES_DIR}/App/LangServerHelpers/Include
        ${PACKAGES_DIR}/App/Launcher/Include
        ${PACKAGES_DIR}/Render/RenderContext/Include
        ${PACKAGES_DIR}/Render/GLRenderContext/Include
        ${PACKAGES_DIR}/Render/GLRenderDevice/Include
)

if (WIN32)
    include_directories(${JAVA_HOME}/include/win32)
elseif (APPLE)
    include_directories(${JAVA_HOME}/include/darwin)
else()
    include_directories(${JAVA_HOME}/include/linux)
endif()

# ====== СПИСОК ИСХОДНИКОВ ======
# Базовый набор файлов (JNI обертки)
set(SOURCE_FILES
        src/NsDrawing/NSColorJni.cpp
        src/NsDrawing/NSCornerRadiusJni.cpp
        src/NsDrawing/NSInt32RectJni.cpp
        src/utils/NSJniUtils.cpp
        src/utils/NSJniUtils.h
        src/NsCore/NsSymbolJni.cpp
        src/NsCore/NsTypeJni.cpp
        src/NsCore/NsBaseComponentJni.cpp
        src/NsRender/NsRenderTargetJni.cpp
        src/NsRender/NsRenderDeviceJni.cpp
        src/Debug/NSDebugCpp.cpp
        src/NsApp/NsXamlProviderJni.cpp
        src/NsCore/NsStreamJni.cpp
        src/NsCore/NsDispatcherObjectJni.cpp
        src/NsCore/NsBaseObjectJni.cpp
        src/NsCore/NsBaseRefCountedJni.cpp
        src/NsCore/NsDependencyPropertyJni.cpp
        src/NsGui/NsVisualJni.cpp
        src/NsGui/NsUIElementJni.cpp
        src/NSNoesisGuiJni.cpp
        src/NsCore/NsInterfaceJni.cpp
        src/NsGui/NsIRendererJni.cpp
        src/NsGui/NSIViewJni.cpp
        src/Render/NsRenderContextJni.cpp
        src/Render/NsGLJni.cpp
        src/NsApp/NsThemeJni.cpp
        src/NsGui/NsFrameworkElementJni.cpp
        src/jni.cpp
        src/events/NsWidgetEvents.h
        src/jni.h
        src/NsCore/NsRoutedEventJni.cpp
        src/events/NsButtonEventJni.cpp
        src/events/NsFrameworkElementEventsJni.cpp
        src/utils/NSJavaUtils.h
        src/events/NsFrameworkElementEventsJni.cpp
        src/events/NsUIElementEventsJni.cpp
        src/NsGui/NsControlJni.cpp
        src/NsGui/NsContentControlJni.cpp
        src/NsGui/NSItemContainerGeneratorJni.cpp
        src/NsGui/NSPanelJni.cpp
        src/NsGui/NSGridJni.cpp
        src/NsGui/NSBaseButtonJni.cpp
        src/NsGui/NSBrushJni.cpp
        src/NsGui/NSSolidColorBrushJni.cpp
        src/NsGui/NSBrushesJni.cpp
        src/NsGui/NSGradientBrushJni.cpp
        src/NsGui/NSLinearGradientBrushJni.cpp
        src/NsGui/NSRadialGradientBrushJni.cpp
        src/NsGui/NSTileBrushJni.cpp
        src/NsGui/NSVisualBrushJni.cpp
        src/NsGui/NSImageBrushJni.cpp
        src/Render/NSGLRenderUtil.h
        
        # Эти файлы из SDK нужны всем, так как они используются напрямую
        NoesisSDK/Packages/Render/GLRenderContext/Src/GLRenderContext.h
        NoesisSDK/Packages/Render/GLRenderDevice/Src/GLRenderDevice.cpp
        
        src/NsGui/NSGradientStopCollectionJni.cpp
        src/NsGui/NSGradientStopJni.cpp
        src/NsGui/NSButtonJni.cpp
        src/NsGui/NSUIElementCollectionJni.cpp
        src/NsGui/NSToggleButtonJni.cpp
        src/NsGui/NSRadioButtonJni.cpp
        src/NsGui/NSCheckBoxJni.cpp
        src/NsGui/NSRepeatButtonJni.cpp
        src/NsGui/NSGridViewColumnHeaderJni.cpp
        src/NsGui/NSToolTipJni.cpp
        src/NsGui/NSLabelJni.cpp
        src/NsGui/NSUserControlJni.cpp
        src/NsGui/NSPageJni.cpp
        src/NsGui/NSStatusBarItemJni.cpp
        src/NsGui/NSBaseTextBoxJni.cpp
        src/NsGui/NSTypographyJni.cpp
        src/NsGui/NSTextBoxJni.cpp
        src/NsGui/NSRangeBaseJni.cpp
        src/NsGui/NSSliderJni.cpp
        src/NsGui/NSProgressBarJni.cpp
        src/NsGui/NSScrollBarJni.cpp
        src/NsGui/NSTextBlockJni.cpp
        src/NsGui/NSPasswordBoxJni.cpp
        src/NsGui/NSTextElementJni.cpp
        src/NsGui/NSInlineJni.cpp
        src/NsGui/NSSpanJni.cpp
        src/NsGui/NSItalicJni.cpp
        src/NsGui/NSBoldJni.cpp
        src/NsGui/NSUnderlineJni.cpp
        src/NsGui/NSHyperlinkJni.cpp
        src/NsGui/NSInlineCollectionJni.cpp
        src/NsGui/NSColumnDefinitionCollectionJni.cpp
        src/NsGui/NSCommandBindingCollectionJni.cpp
        src/NsGui/NSInputBindingCollectionJni.cpp
        src/NsGui/NSRowDefinitionCollectionJni.cpp
        src/NsGui/NSTriggerCollectionJni.cpp
        src/NsGui/NSRunJni.cpp
        src/NsGui/NSInlineUIContainerJni.cpp
        src/NsGui/NSLineBreakJni.cpp
        src/NsGui/NSItemsControlJni.cpp
        src/NsGui/NSTreeViewJni.cpp
        src/NsGui/NSContextMenuJni.cpp
        src/NsGui/NSMenuJni.cpp
        src/NsGui/NSToolBarOverflowPanelJni.cpp
        src/NsGui/NSCanvasJni.cpp
        src/NsGui/NSStackPanelJni.cpp
        src/NsGui/NSToolBarPanelJni.cpp
        src/NsGui/NSUniformGridJni.cpp
        src/NsGui/NSDockPanelJni.cpp
        src/NsGui/NSWrapPanelJni.cpp
        src/NsGui/NSTabPanelJni.cpp
        src/NsGui/NSVirtualizingStackPanelJni.cpp
        src/NsGui/NSVirtualizingWrapPanelJni.cpp
        src/NsApp/JavaNotifyPropertyChangedBase.cpp
        src/NsApp/JavaNotifyPropertyChangedBase.h
        src/NsApp/NsNotifyPropertyChangedBaseJni.cpp
        src/NsGui/NSThumbJni.cpp
        src/NsGui/NSGridSplitterJni.cpp
        src/NsGui/NSSelectorJni.cpp
        src/NsGui/NSComboBoxJni.cpp
        src/NsGui/NSTabControlJni.cpp
        src/NsGui/NSSelectedItemsCollectionJni.cpp
        src/NsGui/NSListBoxJni.cpp
        src/NsGui/NSListViewJni.cpp
        src/providers/JniXamlProvider.cpp
        src/providers/JniXamlProvider.h
        src/providers/JniXamlProviderUtils.h
        src/providers/JniXamlProviderUtils.cpp
)

# === ДОПОЛНИТЕЛЬНЫЕ ИСХОДНИКИ ДЛЯ MAC (Вместо NoesisApp.dylib) ===
# Если нет библиотеки, собираем основные части NoesisApp из исходников Packages
if(APPLE)
    # Здесь мы подключаем ключевые части App framework, которые обычно лежат в NoesisApp.lib
    # Внимание: список примерный, возможно придется добавить файлы, если будут ошибки "undefined symbol"
    
    # Provider-ы (шрифты, текстуры)
    file(GLOB APP_PROVIDERS_SRC "${PACKAGES_DIR}/App/Providers/Src/*.cpp")
    
    # Display (поддержка окон) - на Mac это Cocoa
    file(GLOB APP_DISPLAY_SRC "${PACKAGES_DIR}/App/Display/Src/*.cpp")
    
    # ApplicationLauncher
    file(GLOB APP_LAUNCHER_SRC "${PACKAGES_DIR}/App/ApplicationLauncher/Src/*.cpp")
    
    # DisplayLauncher
    file(GLOB APP_DISPLAY_LAUNCHER_SRC "${PACKAGES_DIR}/App/DisplayLauncher/Src/*.cpp")
    
    # Theme
    file(GLOB APP_THEME_SRC "${PACKAGES_DIR}/App/Theme/Src/*.cpp")

    # Добавляем их к списку компиляции
    list(APPEND SOURCE_FILES 
        ${APP_PROVIDERS_SRC}
        ${APP_DISPLAY_SRC}
        ${APP_LAUNCHER_SRC}
        ${APP_DISPLAY_LAUNCHER_SRC}
        ${APP_THEME_SRC}
    )
endif()

add_library(noesis_jni SHARED ${SOURCE_FILES})

# ====== ЛИНКОВКА ======

if (WIN32)
    target_link_libraries(noesis_jni
        "${NOESIS_LIB_DIR}/Noesis.lib"
        "${NOESIS_LIB_DIR}/NoesisApp.lib"
    )
elseif (APPLE)
    # На Mac линкуем только Noesis (App собираем внутри)
    # Также нужны системные фреймворки Mac
    find_library(COCOA_LIB Cocoa)
    find_library(OPENGL_LIB OpenGL)
    find_library(APPKIT_LIB AppKit)
    find_library(IOKIT_LIB IOKit)
    
    target_link_libraries(noesis_jni
        "${NOESIS_BIN_DIR}/Noesis.dylib"
        ${COCOA_LIB}
        ${OPENGL_LIB}
        ${APPKIT_LIB}
        ${IOKIT_LIB}
    )
else()
    # Linux
    target_link_libraries(noesis_jni
        "${NOESIS_LIB_DIR}/libNoesis.so"
        "${NOESIS_LIB_DIR}/libNoesisApp.so"
    )
endif()

# ====== КОПИРОВАНИЕ ЗАВИСИМОСТЕЙ ======

add_custom_command(TARGET noesis_jni POST_BUILD
        COMMAND ${CMAKE_COMMAND} -E make_directory "${NATIVE_OUT_DIR}"
        
        # JNI либа
        COMMAND ${CMAKE_COMMAND} -E copy_if_different
        "$<TARGET_FILE:noesis_jni>"
        "${NATIVE_OUT_DIR}/$<TARGET_FILE_NAME:noesis_jni>"

        # Noesis Core
        COMMAND ${CMAKE_COMMAND} -E copy_if_different
        "${NOESIS_BIN_DIR}/${LIB_PREFIX}Noesis${LIB_EXT}"
        "${NATIVE_OUT_DIR}/${LIB_PREFIX}Noesis${LIB_EXT}"
)

if (NOT APPLE)
    add_custom_command(TARGET noesis_jni POST_BUILD
            COMMAND ${CMAKE_COMMAND} -E copy_if_different
            "${NOESIS_BIN_DIR}/${LIB_PREFIX}NoesisApp${LIB_EXT}"
            "${NATIVE_OUT_DIR}/${LIB_PREFIX}NoesisApp${LIB_EXT}"
    )
endif()

set_target_properties(noesis_jni PROPERTIES
        OUTPUT_NAME "noesis_jni"
        RUNTIME_OUTPUT_DIRECTORY "${NATIVE_OUT_DIR}"
)

foreach(cfg IN LISTS CMAKE_CONFIGURATION_TYPES)
    string(TOUPPER "${cfg}" CFG_UPPER)
    set_target_properties(noesis_jni PROPERTIES
            RUNTIME_OUTPUT_DIRECTORY_${CFG_UPPER} "${NATIVE_OUT_DIR}"
    )
endforeach()