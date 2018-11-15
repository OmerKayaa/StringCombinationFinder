import Controller.DictionaryReader;
import Controller.Search;
import Controller.DictionaryController;
import Model.Dictionary;
import Model.QueryType;
import Model.WordDictionary;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchTest
{
    private List<String> recommend = List.of("recommend","recommendation","recommendations","recommended","recommending","recommends");
    private List<String> fox = List.of("fox","of","ox");
    private List<String> done = List.of("done","node");

    private Path dictionary =  Paths.get(System.getProperty("user.dir")+"\\src\\main\\resources\\40Kwords.txt");

    @Test
    public void testSearch()
    {
        Search.Find(dictionary, QueryType.ExactMatch ,"dnoe",string -> assertTrue(done.contains(string)));
        Search.Find(dictionary, QueryType.WordContainsQuery ,"recommend",string -> assertTrue(recommend.contains(string)));
        Search.Find(dictionary, QueryType.QueryContainsWord ,"fox",string -> assertTrue(fox.contains(string)));
    }
}
