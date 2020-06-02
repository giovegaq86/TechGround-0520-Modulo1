import org.testng.Assert;
import org.testng.annotations.*;

public class testng_parameters {
    @Parameters({ "first-name" })
    @Test
    public void testSingleString(String firstName) {
        System.out.println("Este chavalo se llama " + firstName);
        Assert.assertEquals("Cedric",firstName);
    }
}
