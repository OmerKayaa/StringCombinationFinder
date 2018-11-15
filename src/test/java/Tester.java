
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Tester
{
    public static void main(String[] args) {
        Printer(JUnitCore.runClasses(ControllerTest.class, ReaderTest.class,
                DictionaryTest.class,SearchTest.class, ParallelSearchTest.class),"Main");
    }

    private static void Printer(Result result,String name)
    {
        if(result.wasSuccessful())
        {
            System.out.println("\t"+ name + " test is finished successfully");
            PrintLine();
        }
        else
        {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
            PrintLine();
        }
    }

    private static void PrintLine()
    {
        System.out.println("-----------------------------------------------------");
    }
}
