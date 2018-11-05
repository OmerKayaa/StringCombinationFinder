import Controller.FileReader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class ReaderTest
{
    private File file;

    @Before
    public void Set()
    {
        try
        {
            file = Files.createTempFile("test",".txt").toFile();
            Files.writeString(file.toPath().toAbsolutePath(),"Deneme1\ndeneme2");
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
        FileReader.ReadFile(file.toPath(), s -> assertTrue(s.equals("Deneme1") || s.equals("deneme2")));
    }
}
