import org.testng.Assert;
import org.testng.annotations.Test;

public class main_test_testng {

    @Test(groups = { "futbol", "laliga" })
    public void testContructor() {
        Person persona = new Person("hola","juan");
        Assert.assertEquals("holas", persona.getName());
        Assert.assertEquals("juan", persona.getLastName());
    }

    @Test(groups = {"futbol", "saprissa"} )
    public void emptyConstructor() {
        Person persona = new Person();
        Assert.assertEquals("hola", persona.getName());
        Assert.assertEquals("juan", persona.getLastName());
    }


}
