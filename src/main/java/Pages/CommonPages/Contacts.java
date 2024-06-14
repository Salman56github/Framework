package Pages.CommonPages;

import FrameWork.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

import static FrameWork.Resuable_Methods.*;
import static FrameWork.Resuable_Methods.Click;

public class Contacts {

    static WebDriver driver = Browsers.driver;

    public Contacts() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Customer contacts']/..//input[@inputmode='email']")
    public WebElement CustomerEmail;

    @FindBy(xpath = "//input[@placeholder='Type ABN or company name']")
    public WebElement CompanyName;

    @FindBy(xpath = "//div[@role='option']")
    public WebElement CompanyNameOption;

    @FindBy(xpath = "//span[text()='Select role']")
    public WebElement SelectRole;

    @FindBy(xpath = "//div/lightning-base-combobox-item")
    public List<WebElement> SelectRoleDropDown;

    @FindBy(xpath = "//span[@class='slds-radio_faux']")
    public WebElement ApproverBtn;

    @FindBy(xpath = "//small[text()='Send approver invite']")
    public WebElement SendInvite;



    public static void EnterDetailsIntoContacts(String Sector) throws Exception {
        Contacts contacts = new Contacts();
        HashMap<String, String> ReadFromExcel = DataFromExcell(Sector, "Contact");
        WaitUntil(contacts.CustomerEmail);
        TextField(contacts.CustomerEmail, ReadFromExcel.get("Email address"));
        TextField(contacts.CompanyName, ReadFromExcel.get("Search company"));
        WaitUntil(contacts.CompanyNameOption);
        if (contacts.CompanyNameOption.isDisplayed()) {
            jsClick(contacts.CompanyNameOption);
        }
        SelectFromDropDown(contacts.SelectRole, contacts.SelectRoleDropDown, ReadFromExcel.get("Role"));
        if (ReadFromExcel.get("Approver").equalsIgnoreCase("Yes")) {
            jsClick(contacts.ApproverBtn);
        }
        jsClick(contacts.SendInvite);
    }

}
