
import Model.Dictionary;
import Model.WordDictionary;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;


import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class DictionaryTest
{
    final private List<String> inputStream = List.of("az","zz","bab","abb");
    private Dictionary<BigInteger,List<String>> dictionary;

    @Before
    public void Set()
    {
        dictionary = new WordDictionary();

        for (String S: inputStream )
        {
            dictionary.addWord(S);
        }
    }

    @Test
    public void testKeyOfWord()
    {
        assertEquals(new BigInteger("515"),dictionary.keyOfWord("az"));
        assertEquals(new BigInteger("10609"),dictionary.keyOfWord("zz"));
        assertEquals(new BigInteger("26645"),dictionary.keyOfWord("bab"));
    }

    @Test
    public void testIsWordExist()
    {
        dictionary.forEach((integer, strings) -> strings.forEach(s -> assertTrue(inputStream.contains(s))));
    }

    @Test
    public void testFindKey()
    {
        dictionary.findKey(new BigInteger("26645")).forEach(s -> assertTrue(List.of("abb","bab").contains(s)));
    }

    @Test
    public void testWrite()
    {
        for (String s : inputStream)
        {
            dictionary.addWord(s);
        }

        for (String s : inputStream)
        {
            assertTrue(dictionary.isWordExist(s));
        }

        dictionary.forEach((integer, strings) -> assertTrue(inputStream.containsAll(strings)));
    }
}
