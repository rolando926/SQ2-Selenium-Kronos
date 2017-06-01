package kronos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by RXC8414 on 5/25/2017.
 */
public class MainPage extends Login{
    //public static final By GRID = By.xpath(".//div[@id='genieGrid']");
    public String gridRow = ".//div[@id='row@@@@genieGrid']//div[1]//div";
    public By GRID_ROW;
    public static final By GENIE_FRAME = By.xpath(".//iframe[contains(@id,'iframe_iFrame_')]");
    public static final By innerFrame = By.xpath(".//iframe[contains(@id,'iframe_iFrame')]");
    public static final By GOTO = By.xpath(".//button[@class='btn i widget-button-icon LABELICON e']");
    public static final By GOTO_TIMECARD = By.xpath(".//a[@class='ng-binding' and contains(text(),'Timecards')]");

    // Step 4 for Page factory
    public MainPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public boolean verifyGenieTable(String recNumber){
        if(waitUntilElementDisplayed(GENIE_FRAME)) {
            if (switchDriver("IFRAME", GENIE_FRAME)) {
                //switchDriver("","");
                if(openGenieRecord(recNumber)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean openGenieRecord(String recNumber){
        gridRow = gridRow.replace("@@@@",recNumber);
        GRID_ROW = By.xpath(gridRow);
        if(waitUntilElementDisplayed(GRID_ROW)) {
            driver.findElement(GRID_ROW).click();
            syncElement("SECONDS", 1);
            if (waitUntilElementDisplayed(GOTO)) {
                driver.findElement(GOTO).click();
                if (waitUntilElementDisplayed(GOTO_TIMECARD)) {
                    driver.findElement(GOTO_TIMECARD).click();
                    return true;
                }
            }
        }
        return false;
    }
}
