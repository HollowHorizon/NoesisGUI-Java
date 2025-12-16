import dev.sixik.noesisgui.NoesisGui;
import dev.sixik.noesisgui.nsgui.NSUIElement;
import dev.sixik.noesisgui_impl.loaders.DebugXamlLoader;
import dev.sixik.noesisgui_ini.NoesisGuiJava;
import dev.sixik.noesisgui_render.gl.NSOpenGl;

public class NoesisTest {

    public static void main(String[] args) {
        NoesisGuiJava.Initialize();

        Thread thread = new Thread(() -> {
            NoesisGui.setLogHandler(((file, line, level, channel, message) -> {
                System.out.println("[NOESIS] " + file + ":" + line + " [" + NoesisGui.getLogLevelName((int) level) + "] " + channel + " - " + message);
            }));

            NoesisGui.setXamlProvider(new DebugXamlLoader());

            NoesisGui.init();

            NSUIElement data = NoesisGui.parseXaml("""
                <Grid xmlns="http://schemas.microsoft.com/winfx/2006/xaml/presentation"
      xmlns:x="http://schemas.microsoft.com/winfx/2006/xaml"
      Background="#66000000">

  <!-- This forces a second XAML load through your XamlProvider -->
  <Grid.Resources>
    <ResourceDictionary>
      <ResourceDictionary.MergedDictionaries>
        <ResourceDictionary Source="ui/TestStyles.xaml"/>
      </ResourceDictionary.MergedDictionaries>
    </ResourceDictionary>
  </Grid.Resources>

  <Border CornerRadius="10"
          Padding="14"
          Background="#AA1E1E1E"
          HorizontalAlignment="Center"
          VerticalAlignment="Center">

    <StackPanel>
      <TextBlock Text="XamlProvider OK"
                 Foreground="White"
                 FontSize="22"
                 Margin="0,0,0,10"
                 TextAlignment="Center"/>

      <Button Content="Button from Styles.xaml"
              Style="{StaticResource TestButtonStyle}"/>

      <TextBlock Text="If you see a styled button, nested XAML loading works."
                 Foreground="#FFD0D0D0"
                 Margin="0,10,0,0"
                 TextWrapping="Wrap"
                 Width="320"/>
    </StackPanel>

  </Border>
</Grid>
                """);

            System.out.println(data.getPtr());
        });

        thread.start();

        while (true) {}


    }

    private static void start(String name) {
        System.out.println("------" + name + "------");
    }

    private static void end() {
        System.out.println("------------");
    }

    private static void space() {
        space(1);
    }

    private static void space(int space) {
        for (int i = 0; i < space; i++) {
            System.out.println("\n");
        }
    }
}
