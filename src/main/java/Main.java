
import Controller.Search;
import Model.QueryType;
import View.ConsoleView;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    final static private List<String> WQ = new ArrayList<>();
    final static private List<String> QW = new ArrayList<>();
    final static private List<String> E = new ArrayList<>();

    public static void main(String[] args)
    {
        // Usage Example
        String query = "Recommend";
        Path wordFile = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\40Kwords.txt");
        Search.Find(wordFile, QueryType.WordContainsQuery, query, WQ::add);
        Search.Find(wordFile, QueryType.QueryContainsWord, query, QW::add);
        Search.Find(wordFile, QueryType.ExactMatch, query, E::add);

        ConsoleView table = new ConsoleView(20, "Exact", "Query", "Word");
        table.new tableAttributes(E, QW, WQ);


    }

}
