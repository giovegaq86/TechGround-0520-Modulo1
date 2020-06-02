import org.testng.annotations.*;

public class testng_annotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.print("Before Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.print("After Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.print("Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.print("After Test");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.print("Before Groups");
    }
    @AfterGroups
    public void afterGroups(){
        System.out.print("After Groups");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.print("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.print("After Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.print("Before Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.print("After Method");
    }

    @Test
    public void test(){
        System.out.print("Actual test");
    }
}
