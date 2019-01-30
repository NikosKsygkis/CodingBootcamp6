package newsintercomAPP;

import java.io.Console;
import java.io.IOException;

/*
 * ConsoleUtils exposes a few useful methods which can be used across a broad range of console apps.
 */ 
public class ConsoleUtils {
	private static Console console = null;
	

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");
            //System.out.println(os);
            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                Runtime.getRuntime().exec("clear");
                System.out.print("\033\143");
            }
        }
        catch (final IOException | InterruptedException e) {
        }
    }    
}