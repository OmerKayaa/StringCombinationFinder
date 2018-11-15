import Controller.DictionaryReader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class ReaderTest
{
    private List<String> list = List.of("sample1","sample2","example","new","text","read","write");
    private File file;

    @Before
    public void Set()
    {
        String input = "";
        for ( String s: list )
        {
            input += s + "\n";
        }
        try
        {
            file = Files.createTempFile("test",".txt").toFile();
            Files.writeString(file.toPath().toAbsolutePath(), input);

            file.deleteOnExit();
        }
        catch (IOException ex)
        {
            fail("Unable to create temp file");
        }
    }

    @Test
    public void testReader()
    {
        DictionaryReader.ReadFile(file.toPath(), s -> assertTrue(list.contains(s)));
    }
}
