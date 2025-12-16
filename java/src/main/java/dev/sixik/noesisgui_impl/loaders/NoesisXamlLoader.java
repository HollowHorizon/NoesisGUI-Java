package dev.sixik.noesisgui_impl.loaders;

public interface NoesisXamlLoader {
    /**
     * @param uri Uri that Noesis requests (e.g. "ui/Main.xaml")
     * @return raw XAML bytes or null if not found
     */
    byte[] loadXaml(String uri);
}