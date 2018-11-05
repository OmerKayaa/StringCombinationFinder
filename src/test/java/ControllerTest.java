import Controller.Converters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControllerTest
{
    @Test
    public void testKeyGenerator()
    {
        assertEquals(3*2*5,Converters.KeyGenerator("eta").intValue());
        assertEquals(73*37*29,Converters.KeyGenerator("bcd").intValue());
        assertEquals("1036862889865770047130961",Converters.KeyGenerator("zqxzqxzqxzqx").toString());
    }

    @Test
    public void testCharConverter()
    {
        String Alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0 ; i < 25 ; i++)
            assertEquals( i,Converters.CharConverter(Alphabet.charAt(i)));
    }
}

