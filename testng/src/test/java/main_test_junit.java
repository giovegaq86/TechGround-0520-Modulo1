import org.junit.Assert;
import org.junit.Test;

public class main_test_junit {

    @Test
    public void testContructor() {
        Person persona = new Person("hola","juan");
        Assert.assertEquals("hola", persona.getName());
        Assert.assertEquals("juan", persona.getLastName());
    }

    @Test
    public void emptyConstructor() {
        Person persona = new Person();
        Assert.assertEquals("hola", persona.getName());
        Assert.assertEquals("juan", persona.getLastName());
    }


}
