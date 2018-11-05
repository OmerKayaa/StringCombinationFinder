import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Tester
{
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ControllerTest.class,ModelTest.class,ViewTest.class,
                ReaderTest.class,WriterTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful()?"\nAll Test Passed":"\nTest Failed");
    }
}
