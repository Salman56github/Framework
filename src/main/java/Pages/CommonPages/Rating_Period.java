package Pages.CommonPages;

import FrameWork.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import static FrameWork.Resuable_Methods.*;

public class Rating_Period {

    static WebDriver driver = Browsers.driver;

    public Rating_Period() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/label[text()='Starting date']//following-sibling::lightning-input/lightning-datepicker/div/div/input")
    public WebElement Startingdate;

    public static void EnterDetailsIntoRatingPeriod(String Sector) throws Exception {
        try{
            Rating_Period ratingPeriod = new Rating_Period();
            HashMap<String, String> ReadFromExcel = DataFromExcell(Sector, "Rating Period");
            String date = DataFormatter(ReadFromExcel.get("Starting date"));
            ratingPeriod.Startingdate.click();
            ratingPeriod.Startingdate.clear();
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Actions action = new Actions(driver);
            action.sendKeys(ratingPeriod.Startingdate, date).perform();

            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            Tooltip();
        }catch (Exception e){
            System.out.println(e);
        }

    }



}
