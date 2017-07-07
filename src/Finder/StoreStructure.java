package Finder;

import java.util.Map;

/**
 * This Class handles indexing Strings, Calculating key value for string and does conditional search from Map
 */

public abstract class StoreStructure
{
    final static byte[] PrimeArray = {5,73,37,29,2,59,61,19,11,89,83,31,43,13,7,71,101,23,17,3,41,79,53,97,67,103,107,109};
    /*                                a, b, c, d,e, f, g, h, i, j, k, l, m, n, o, p, q, r, s,t, u, v, w, x, y,  z
    Letters listed according to English letter usage frequency can be change for other language letter frequency
    */

    //Search types
    static final int WordContainsQuery=0,SubQueryContainsWord=1,WordCotainsAllletter=2,ExactMatch=3;

    private static byte CharConverter(char c)
    {
        if(!Character.isLetter(c))
            return (byte)(25);
        return (byte)(((byte)Character.toUpperCase(c))-((byte)(65)));
    }

    /*
    this method converts strings to long key for indexing
    exp:    abc -> 5 * 73 * 37 (13505)
            bca -> 73 * 37 * 5 (13505)
    so that same combination of letters indexed to same key
    */

    private static long StringConverter(String s)
    {
        long Result =1;
        for(char c: s.toCharArray())
        {
            Result *=PrimeArray[CharConverter(c)];
            if(Result <0)
                return 1;
        }
        return Result;
    }

    /**
     * Conditional find does the most of this project
     * after adding elements our map will look like this
     * Key - 13505 Set abc, bca, cab...
     * Key - 669397 Set xyz, zxy...
     * ...
     *  so when you want to find a word with the same set of letter all
     * you need to do is convert letter combination to a key by using
     * StringConverter method and you are ready to search your map
     *  when you want to find a word that contains query all you need to
     * do is convert query and use mod operation to see if converted word
     * mod converted query is equal to zero if its zero then word contains
     * all the letter query have else word have other letter that query
     * does'nt have
     *
     * @param string Query letter combination
     * @param Condition specifies type of search(types are written above)
     * @return
     */
    public ResultInterface ConditionalFind(String string,int Condition)
    {
        Result Result = new Result();
        long key = StringConverter(string);
        switch (Condition)
        {
            case WordContainsQuery:
                {
                    GetDictionary().forEach
                            (
                                    (Key, List) ->
                                    {
                                        if (Key % key == 0)
                                            List.GetIterator().forEach(S -> Result.AddString(S.toString()));
                                    }
                            );
                }
                break;
            case SubQueryContainsWord:
                {
                    GetDictionary().forEach
                            (
                                    (Key, List) ->
                                    {
                                        if (key % Key == 0)
                                            List.GetIterator().forEach(S -> Result.AddString(S.toString()));
                                    }

                            );
                }
                break;
            case ExactMatch:
                Iterable i = FindfromDictionary(string).GetIterator();
                if(i==null) return null;
                else
                    {
                    FindfromDictionary(string).GetIterator().forEach(S-> Result.AddString(S.toString()));
                    Result.setIterator(i);
                    }
                break;
            default: System.out.println("Not a supported search type");
        }
        return Result;
    }

    protected static long GetKeyofString(String string)
    {
        return StringConverter(string);
    }

    public void AddString(String string)
    {
        AddtoDicionary(string,StringConverter(string));
    }

    protected abstract void AddtoDicionary(String string,long key);
    public abstract ResultInterface FindfromDictionary(String string);
    protected abstract Map<Long,ResultInterface> GetDictionary();
}
