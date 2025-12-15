package dev.sixik.noesisgui_impl.loaders;

import java.io.InputStream;

/**
 * @param basePath e.g. "assets/yourmodid/noesis/"
 */
public record ClasspathXamlLoader(ClassLoader cl, String basePath) implements NoesisXamlLoader {

    public ClasspathXamlLoader(ClassLoader cl, String basePath) {
        this.cl = cl;
        this.basePath = basePath.endsWith("/") ? basePath : basePath + "/";
    }

    @Override
    public byte[] loadXaml(String uri) {
        String path = basePath + uri;
        try (InputStream in = cl.getResourceAsStream(path)) {
            if (in == null) return null;
            return in.readAllBytes();
        } catch (Exception e) {
            return null;
        }
    }
}
