package Pages.CommonPages;

import FrameWork.Browsers;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

import static FrameWork.Resuable_Methods.*;

public class CreateRating extends Browsers {

    static WebDriver driver = Browsers.driver;


    @FindBy(xpath = "//a[@class='ctaBtnOne slds-button slds-truncate']")
    public WebElement CreateRating;

    @FindBy(xpath = "//h1[text()='Building type']")
    public WebElement Currentpage;

    @FindBy(xpath = "//button[@role='combobox']")
    public static WebElement SelectBuildingBtn;

    @FindBy(xpath = "//button[@role='combobox']/../following-sibling::div/lightning-base-combobox-item")
    public static List<WebElement> BuildingTypeList;

    @FindBy(xpath = "//button[text()='Agree and continue']")
    public static WebElement AgreeAndContinueBtn;

    @FindBy(xpath = "//label[text()='Select scope']/../lightning-radio-group//label")
    public static List<WebElement> SelectScope;

    @FindBy(xpath = "//label[text()='Select scope']")
    public static WebElement SelectScopeText;


    public CreateRating() {
        PageFactory.initElements(driver, this);
    }

    public void CreateRating() throws InterruptedException {
        CreateRating.click();
    }

    public void VerifyCreateRatingPage() throws InterruptedException {
        WaitUntil(Currentpage);
        Currentpage.isDisplayed();
    }

//    public void SelectBuildingType(String buildingType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
//        SelectBuildingBtn.click();
//        List<WebElement> elements = driver.findElements(By.xpath("//button[@role='combobox']/../following-sibling::div/lightning-base-combobox-item"));
//        for (WebElement ele : elements) {
//            if (ele.getText().contains(" ")) {
//                String type = ele.getText().replace(" ", "_");
//                if (type.trim().equalsIgnoreCase(buildingType.trim())) {
//                    ele.click();
//                    Thread.sleep(3000);
//                    AgreeAndContinueBtn.click();
//                    String className = "Pages.ApplicationPages." + buildingType.trim();
//                    String methodNames = buildingType;
//
//                    Class<?> c = Class.forName(className);
//                    Class[] argTypes = new Class[]{String.class,WebElement.class};
//                    Method main = c.getDeclaredMethod(methodNames, argTypes);
//                    main.invoke(methodNames, driver);
//                    break;
//                }
//
//            }
//        }
//    }

    public void SelectBuildingType(String buildingType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        jsClick(SelectBuildingBtn);
        List<WebElement> elements = driver.findElements(By.xpath("//button[@role='combobox']/../following-sibling::div/lightning-base-combobox-item"));
        for (WebElement ele:elements){
            if (ele.getText().equalsIgnoreCase(buildingType)){
                ele.click();
                shortWait();
                jsClick(AgreeAndContinueBtn);
            }
        }

    }

    public static void SelectBuildingTypeAndScope(String BuildingType, String Scope){
       try{
           HashMap<String, String> ReadFromExcel = DataFromExcell("Office", "Select Rating Type");
           jsClick(SelectBuildingBtn);
           for (WebElement ele:BuildingTypeList){
               if (ele.getText().equalsIgnoreCase(BuildingType)){
                   jsClick(ele);
                   break;
               }
           }
           WaitUntil(SelectScopeText);
           for (WebElement element:SelectScope){
               if (element.getText().equalsIgnoreCase(ReadFromExcel.get(Scope))){
                   jsClick(element);
                   break;
               }
           }
//            WaitUntil(AgreeAndContinueBtn);
          ShortWait();
           jsClick(AgreeAndContinueBtn);
       }catch (Exception e){
           System.out.println(e);
       }
    }




}



