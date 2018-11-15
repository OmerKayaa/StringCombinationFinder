# StringCombinationFinder

#### This is an application for finding word among the letters.

How can i use it?
-----------------
* You need a list of valid word written in a txt file and every word should be in a new line
* You need to know what type of search you want

Type of search
--------------

* Exact Match : this will find word that has exact same letters as your query
* Word Contains Query : this will find word which has all letters from your query
* Query Contains Word : this will find word which has same letters but not all letters from your query


Example
-------
| Query Type           | Query           | Result                           |
| -------------------- |:---------------:| --------------------------------:|
| Exact Match          | done            | Done,Node                        |
| Word Contains Query  | recommendation  | recommendation, recommendations  |
| Query Contains Word  | fox             | ox,fox,of                        |


Example Code
------------
```
public class Main
{
    final static private List<String> WQ = new ArrayList<>();
    final static private List<String> QW = new ArrayList<>();
    final static private List<String> E = new ArrayList<>();
    
    public static void main(String[] args)
    {
        String query = "Recommend";
        Path wordFile = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\40Kwords.txt");
        Search.Find(wordFile, QueryType.WordContainsQuery, query, WQ::add);
        Search.Find(wordFile, QueryType.QueryContainsWord, query, QW::add);
        Search.Find(wordFile, QueryType.ExactMatch, query, E::add);

        ConsoleView table = new ConsoleView(20, "Exact", "Query", "Word");
        table.new tableAttributes(E, QW, WQ);
    }
}
```
