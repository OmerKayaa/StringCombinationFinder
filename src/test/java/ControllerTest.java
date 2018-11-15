import Controller.Converters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControllerTest
{
    @Test
    public void testKeyGenerator()
    {
        String errorMessage = "Key converter is not working ";
        assertEquals(errorMessage,3*2*5,Converters.KeyGenerator("eta").intValue());
        assertEquals(errorMessage,73*37*29,Converters.KeyGenerator("bcd").intValue());
        assertEquals(errorMessage,"1036862889865770047130961",Converters.KeyGenerator("zqxzqxzqxzqx").toString());
    }

    @Test
    public void testCharConverter()
    {
        String Alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0 ; i < 25 ; i++)
            assertEquals("Alphabet converter is not working ", i,Converters.CharConverter(Alphabet.charAt(i)));
    }
}

