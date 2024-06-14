package Pages.CommonPages;

import FrameWork.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

import static FrameWork.Resuable_Methods.*;

public class Premises {

    static WebDriver driver = Browsers.driver;

    public Premises() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@class='slds-button slds-button_neutral minHeight2Lines']")
    public WebElement SearchByPreviousRatingNumber;

    @FindBy(xpath = "//button[@class='slds-button slds-button_neutral minHeight2Lines']")
    public WebElement EnterRatingNumber;

    @FindBy(xpath = "//label[text()='Search for street name and number']/..//input")
    public WebElement Street_name_And_Number;

    @FindBy(xpath = "//div[@role='option']")


    public  WebElement Street_name_And_Number_Dropdown;


    public static void EnterDetailsIntoPremises(String Sector) throws Exception {
        try {
            Premises premises = new Premises();
            HashMap<String, String> ReadFromExcel = DataFromExcell(Sector, "Premises");
            if (ReadFromExcel.get("Search by previous rating number").contains("Yes")) {
                jsClick(premises.SearchByPreviousRatingNumber);
                TextField(premises.EnterRatingNumber, ReadFromExcel.get(""));
            } else {
                TextField(premises.Street_name_And_Number, ReadFromExcel.get("Search for street name and number"));
                WaitUntil(premises.Street_name_And_Number_Dropdown);
                if (premises.Street_name_And_Number_Dropdown.isDisplayed()) {
                    jsClick(premises.Street_name_And_Number_Dropdown);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
