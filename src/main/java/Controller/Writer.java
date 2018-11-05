package Controller;

import Model.Dictionary;

import java.math.BigInteger;
import java.util.List;

public interface Writer
{
    static void WriteToDictionary(Dictionary dictionary, String string)
    {
        BigInteger key = Converters.KeyGenerator(string);
        List<String> list = dictionary.isKeyExist(key);

        if(list == null)
        {
            list = dictionary.createKey(key);
            list.add(string);
        }
        else
        {
            if(!list.contains(string))
                list.add(string);
        }
    }
}
