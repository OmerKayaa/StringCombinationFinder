package Finder;

import java.util.*;

/**
 * Example implementation of my project
 * TreeMap with HashSet in it
 * recommend to use Set because no duplicate detection yet
* */
public class TreeWithHashSetDictionary extends StoreStructure
{
    /**
     * Describing Map
     * Add method  - Describe how to add your Map. Key generated in the StoreStructure Class automatically
     * Find method - Find Query with same key value recommend to use GetKeyofString method to get Key value
     *     of the Query.
     * Get method  - Get method is used to search Map value more information at StoreStructure Class
     */

    static TreeMap<Long,LinkedHashSet<String>> Dictionary = new TreeMap<>();

    /**
     * @param string String value to be added on Map
     * @param key Key value of the String
     */
    @Override
    protected void AddtoDicionary(String string,long key)
    {
        if(Dictionary.containsKey(key))
        {
            Dictionary.get(key).add(string.toUpperCase());
        }
        else
        {
            LinkedHashSet<String> word = new LinkedHashSet<>();
            word.add(string.toUpperCase());
            Dictionary.put(key,word);
        }
    }

    /**
     * Expected behavior of this method is returning Strings of the Map
     * which have the same key as Query (GetKeyofString(Query)).
     * @param string Query to search your map
     * @return
     */
    @Override
    public ResultInterface FindfromDictionary(String string)
    {
        return new ResultInterface()
        {

            @Override
            public Iterable GetIterator()
            {
                return Dictionary.get(GetKeyofString(string));
            }

            @Override
            public String[] GetWordArray()
            {
                String[] Array;
                Set<String> rs = Dictionary.get(GetKeyofString(string));
                if(rs==null)
                {
                    Array= new String[0];
                    return Array;
                }
                Iterator<String> itr = rs.iterator();
                Array = new String[rs.size()];
                for(int i =0;i<rs.size();i++)
                    Array[i]=itr.next();
                return Array;
            }

        };
    }

    /**
     * This method is used to get your map for Searching purpose at StoreStructure Class
     * @return
     */
    @Override
    protected Map<Long, ResultInterface> GetDictionary()
    {
        TreeMap<Long,ResultInterface> Result =new TreeMap<>();
        Dictionary.forEach((key,set)->
        {
            if(Result.containsKey(key))
                return;
            else
            {
                Result rs = new Result();
                set.forEach(s -> rs.AddString(s));
                Result.put(key,rs);
                rs.setIterator(set);
            }
        });

        return Result;
    }
}
