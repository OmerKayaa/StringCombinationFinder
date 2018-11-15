package Controller;

import Model.Dictionary;
import Model.QueryType;
import Model.WordDictionary;

import java.math.BigInteger;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

public interface Search
{
    static void Find(Path file, QueryType type, String query, Consumer<String> consumer)
    {
        BigInteger QueryKey = Converters.KeyGenerator(query);
        Dictionary<BigInteger, List<String>> dictionary = new WordDictionary();
        DictionaryReader.ReadFile(file, s -> DictionaryController.WriteToDictionary(dictionary, s));

        switch (type)
        {
            case ExactMatch:
            {
                dictionary.forEach((integer , list) ->
                {
                    if(integer.equals(QueryKey))
                        list.forEach(consumer);
                });
            }
            break;
            case WordContainsQuery:
            {
                dictionary.forEach((integer , list) ->
                {
                    if(integer.divideAndRemainder(QueryKey)[1].equals(BigInteger.ZERO))
                        list.forEach(consumer);
                });
            }
            break;
            case QueryContainsWord:
            {
                dictionary.forEach((integer , list) ->
                {
                    if(QueryKey.divideAndRemainder(integer)[1].equals(BigInteger.ZERO))
                        list.forEach(consumer);
                });
            }
            break;
        }
    }
}

