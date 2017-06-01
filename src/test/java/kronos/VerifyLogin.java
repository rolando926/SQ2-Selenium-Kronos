package kronos;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by RXC8414 on 5/25/2017.
 */
public class VerifyLogin {
    private String user;
    private String password;
    private static final String URL = "http://wn3923.homedepot.com/wfc/navigator/logon";

    // Step 1 for Page Factory
    static MainPage object;
    static WebDriver driver;


    // Step 2 for Page Factory
    @BeforeClass
    public static void setUpDriver(){
        String path = System.getProperty("user.dir")+"\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "C:\\GitHub Repos\\kronos\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 3 for Page Factory
        object = PageFactory.initElements(driver,MainPage.class);

    }

    @Before
    public void setUpKronos(){
        Assert.assertTrue("Could not navigate to Kronos.",object.navigateURL(URL));
    }

    @Test
    public void verifyLoginValidUserPassword(){
        user = "Java10";
        password = "qa02test";

        // Assert user text field and enter user
        Assert.assertTrue("Could not validate user field.",object.verifyCanEnterUser(user));
        System.out.println("Verified user field is present. Entered user: "+user);

        // Assert password text field and enter password
        Assert.assertTrue("Could not validate password field.", object.verifyCanEnterPassword(password));
        System.out.println("Verified password field is present. Entered pass: "+password);

        // Assert can click
        Assert.assertTrue("Could not validate submit button.", object.verifyCanSubmitCredentials());
        System.out.println("Verified user can submit form.");

        // Assert Test genie table loads
        Assert.assertTrue("Could not validate Genie main table.",object.verifyGenieTable("2"));
        System.out.println("Verified Genie table from Main Page.");

    }

    @Test
    public void verifyLoginInvalidUserValidPassword(){
        user = "Invalid";
        password = "qa02test";
    }

    @Test
    public void verifyLoginValidUserInvalidPassword(){
        user = "Java10";
        password = "INVALID";
    }

    @AfterClass
    public static void cleanUpKronos(){
        //object.syncElement("SECONDS",5);
        object.driver.close();
    }
}
