import Controller.DictionaryReader;
import Controller.ParallelSearch;
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

public class ParallelSearchTest
{
    Path wordFile = Paths.get(System.getProperty("user.dir")+"\\src\\main\\resources\\40Kwords.txt");
    private List<String> recommend = List.of("recommend","recommendation","recommendations","recommended","recommending","recommends");
    private List<String> fox = List.of("fox","of","ox");
    private List<String> done = List.of("done","node");
    private Dictionary dictionary = new WordDictionary();

    @Test
    public void testSearch() throws InterruptedException
    {
        ParallelSearch th1 = new ParallelSearch(wordFile, QueryType.ExactMatch,
                "dnoe", s->assertTrue(done.contains(s)));
        ParallelSearch th2 = new ParallelSearch(wordFile, QueryType.QueryContainsWord,
                "fox", s->assertTrue(fox.contains(s)));
        ParallelSearch th3 = new ParallelSearch(wordFile, QueryType.WordContainsQuery,
                "recommend", s->assertTrue(recommend.contains(s)));

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();
    }
}
