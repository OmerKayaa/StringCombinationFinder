package Model;

import Controller.DictionaryController;

import java.math.BigInteger;
import java.util.*;
import java.util.function.BiConsumer;

public class WordDictionary implements Dictionary<BigInteger,List<String>> , DictionaryController
{
    private LinkedHashMap<BigInteger, List<String>> Dictionary = new LinkedHashMap<>();

    @Override
    public List<String> findKey(BigInteger integer)
    {
        return Dictionary.get(integer);
    }

    @Override
    public List<String> createKey(BigInteger integer)
    {
        List<String> newValue = new ArrayList<>();
        Dictionary.put(integer, newValue);
        return newValue;
    }

    @Override
    public BigInteger keyOfWord(String word)
    {
        return DictionaryController.keyOfWord(this,word);
    }

    @Override
    public Set<BigInteger> keySet()
    {
        return Dictionary.keySet();
    }

    @Override
    public boolean isWordExist(String word)
    {
        return Dictionary.get(keyOfWord(word)).contains(word);
    }

    @Override
    public void addWord(String word)
    {
        DictionaryController.WriteToDictionary(this, word);
    }

    @Override
    public void forEach(BiConsumer<BigInteger, List<String>> consumer)
    {
        Dictionary.forEach(consumer);
    }
}

