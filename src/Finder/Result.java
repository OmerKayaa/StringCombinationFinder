package Finder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class is used for passing arguments between other classes
 */

public class Result implements ResultInterface
{
    Iterable itr;
    List<String> str = new ArrayList<>();
    int current=0;

    void setIterator(Iterable itr)
    {
        this.itr = itr;
    }

    void AddString(String str)
    {
        this.str.add(str);
    }

    String[] getString()
    {
        String[] Array = new String[str.size()];
        for (int i = 0; i < str.size(); i++)
        {
            Array[i]=str.get(i);
        }
        return Array;
    }

    protected Iterable GenerateIterable()
    {
        return new Iterable()
        {
            @Override
            public Iterator iterator()
            {
                return new Iterator()
                {
                    @Override
                    public boolean hasNext()
                    {
                        return current<str.size();
                    }

                    @Override
                    public Object next()
                    {
                        return str.get(current++);
                    }
                };
            }
        };
    }

    @Override
    public Iterable GetIterator()
    {
        return itr==null?GenerateIterable():itr;
    }

    @Override
    public String[] GetWordArray()
    {
        return getString();
    }
}
