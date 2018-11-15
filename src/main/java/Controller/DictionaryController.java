package Controller;

import Model.Dictionary;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

public interface DictionaryController
{
    static void WriteToDictionary(Dictionary<BigInteger,List<String>> dictionary, String word)
    {
        BigInteger key = Converters.KeyGenerator(word);
        List<String> list = dictionary.findKey(key);

        if(list == null)
        {
            list = dictionary.createKey(key);
            list.add(word);
        }
        else
        {
            if(!list.contains(word))
                list.add(word);
            // Else means word is already exists
        }
    }

    static BigInteger keyOfWord(Dictionary<BigInteger,List<String>> dictionary,String word)
    {
        Set<BigInteger> keys = dictionary.keySet();
        for (BigInteger key : keys )
        {
            if(dictionary.findKey(key).contains(word)) return key;
        }
        return null;
    }

}
