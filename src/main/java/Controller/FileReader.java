package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface FileReader
{

    static void ReadFile(Path file,ReadingAction action)
    {
        try
        {
            Files.lines(file).forEach(action::ReadingAction);
        }
        catch(IOException ex)
        {
            System.err.println("An error occurred during reading file " + file.getFileName() );
        }
    }

    interface ReadingAction
    {
        void ReadingAction(String s);
    }

}
