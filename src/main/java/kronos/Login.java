package kronos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by RXC8414 on 5/25/2017.
 */
public class Login extends Utilities.SeleniumUtils {
    //private static final By USER = By.xpath(".//input[@id='username']");
    @FindBy(xpath = ".//input[@id='username']")
    WebElement USER;

    private static final By PASS = By.xpath(".//input[@id='passInput']");
    private static final By LOGIN_SUBMIT = By.xpath(".//button[@id='loginSubmit']");

    // Step 5 for Page Factory
    public Login(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public boolean verifyCanEnterUser(String user){
        if(waitUntilElementDisplayed(USER)){
            enterTextIntoTextBox(USER,user);
            return true;
        }
        return false;
    }

    public boolean verifyCanEnterPassword(String password){
        if(waitUntilElementDisplayed(PASS)){
            enterTextIntoTextBox(PASS,password);
            return true;
        }
        return false;
    }

    public boolean verifyCanSubmitCredentials(){
        if(waitUntilElementDisplayed(LOGIN_SUBMIT)){
            clickButton(LOGIN_SUBMIT);
            return true;
        }
        return false;
    }
}
