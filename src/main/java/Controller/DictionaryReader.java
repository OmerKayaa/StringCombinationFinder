package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

public interface DictionaryReader
{

    static void ReadFile(Path file, Consumer<String> consumer)
    {
        try
        {
            Files.lines(file).forEach(consumer::accept);
        }
        catch(IOException ex)
        {
            System.err.println("An error occurred during reading file " + file.getFileName() );
        }
    }


}
