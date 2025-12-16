package dev.sixik.noesisgui_impl.loaders;

public class DebugXamlLoader implements NoesisXamlLoader {
    @Override
    public byte[] loadXaml(String uri) {
        System.out.println("SDM TEST WTH!");

        return new byte[0];
    }
}
