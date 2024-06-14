package Pages.ApplicationPages;

import FrameWork.Browsers;
import Pages.CommonPages.CommonPageElements;
import io.cucumber.java.en.Then;
import io.cucumber.java.zh_cn.假如;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static FrameWork.Resuable_Methods.*;

public class Office extends DataCenter {

    static WebDriver driver = Browsers.driver;

    @FindBy(xpath = "//div[@class='menuScroll']/ul/li/a/span[text()]")
    public List<WebElement> menuItem;

    @FindBy(xpath = "//div[@class='ht_clone_top handsontable']/div/div/div/table/thead/tr/th/div")
    public List<WebElement> DataEntryTableHeader;

    @FindBy(xpath = "//h2[text()='Data summary']/../table")
    public WebElement DataSummaryTable;

    @FindBy(xpath = "//h3[text()='Data summary']/../table")
    public WebElement UtilityDataSummaryTable;

    @FindBy(xpath = "//h2[text()='Grid Inclusions']")
    public WebElement GridInclusion;

    @FindBy(xpath = "//h2[text()='Grid Exclusions']")
    public WebElement GridExclusion;

    @FindBy(xpath = "//button[text()='Add non-utility meter exclusions']")
    public WebElement ExclusionSector_Add_NUM;

    @FindBy(xpath = "//button[text()='Add other inclusions']")
    public WebElement AddOtherInclusion;

    @FindBy(xpath = "//button[text()='Add other exclusions']")
    public WebElement AddOtherExclusion;

    @FindBy(xpath = "//h2/../../div[@class='slds-col slds-size_1-of-3 slds-m-top_large'][1]/div/button[text()]")
    public List<WebElement> GridInclusionSector;

    @FindBy(xpath = "//button[text()='Add other inclusions']/following-sibling::div//lightning-menu-item//span")
    public List<WebElement> AddOtherInclusion_DropDown;

    @FindBy(xpath = "//button[text()='Add other exclusions']/following-sibling::div//lightning-menu-item//span")
    public List<WebElement> AddOtherExclusion_DropDown;

    @FindBy(xpath = "//span[text()='Utility 1']")
    public static WebElement utility1Menu;

    @FindBy(xpath = "//h2[text()='Utility 1']")
    public static WebElement utility1CurrentPage;

    @FindBy(xpath = "//label[text()='Were any areas excluded on the basis of inadequate consumption data?']/following-sibling::lightning-radio-group//div/span/label")
    public List<WebElement> WereAnyAreasExcludedOnBasisOfConsumptionData;

    @FindBy(xpath = "//label[text()='Please explain why lower priority methods (e.g. Tenant Occupancy Survey, average or default hours) were used to calculate core hours in one or more spaces.']//following-sibling::lightning-textarea/div/textarea")
    public WebElement ExplainWhyLowerPriorityMethods;

    @FindBy(xpath = "//label[text()='Explain in detail why this data could not be obtained and which spaces were affected by the exclusion.']/..//textarea")
    public WebElement DetailWhyThisDataCouldNotBeObtained;


    public Office() {
        PageFactory.initElements(driver, this);
    }


    public void verifyMenuItem() throws Exception {
        shortWait();
        String s = "Rating details, Rating period, Premises, Contact, Area and hours,Grid electricity, Renewable electricity, Gas and LPG, Diesel, Water, Review summary, Certification process";
        String str[] = s.split(",");
        for (WebElement element : menuItem) {
            for (int i = 0; i < str.length; i++) {
                if (str[i].contains(element.getText())) ;
                elementFocus(element);
            }
        }
    }

    public void SelectRatingType(String RatingType) throws IOException {
        try {
            shortWait();
            HashMap<String, String> ReadFromExcel = DataFromExcell("Office", "Rating Details");
            if (ReadFromExcel.get(RatingType).contains(",")) {
                String type[] = ReadFromExcel.get(RatingType).split(",", 2);
                for (int i = 0; i < type.length; i++) {
                    shortWait();
                    WebElement element = driver.findElement(By.xpath("//span[text()='" + type[i] + "']"));
                    WaitUntil(element);
                    if (!element.isSelected()) {
                        WaitUntilElementToBeClickable(element);
                        shortWait();
                        jsClick(element);
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void verifyDataSummaryTable() {
        try {
            WaitUntil(DataSummaryTable);
            if (DataSummaryTable.isDisplayed()) {
                elementFocus(DataSummaryTable);
                List<ArrayList> data = ArrayDataFromExcel("OfficeTabularData", "Data summary Table");

                List<WebElement> rowdata = driver.findElements(By.xpath("//h2[text()='Data summary']/../table/tr[1]/td"));
                for (int i = 0; i <= rowdata.size() - 1; i++) {
                    List<ArrayList> data1 = data.get(i);
                    for (int j = 0; j <= data1.size() - 1; j++) {
                        WebElement element = driver.findElement(By.xpath("//h2[text()='Data summary']/../table/tr[" + (i + 1) + "]/td[" + (j + 1) + "]"));
                        String text = element.getText();
                        String value = (data.get(i).get(j)).toString();
                        if (text.contains(value)) {
                            Thread.sleep(1000);
                            elementFocus(element);
                        }
                    }
                }


            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void verifyDataSummaryTable(String TableName) {

        try {
            if (!TableName.contains("Utility")) {
                WaitUntil(DataSummaryTable);
                if (DataSummaryTable.isDisplayed()) {
                    elementFocus(DataSummaryTable);
                    List<ArrayList> data = ArrayDataFromExcel("OfficeTabularData", TableName + " Data summary Table");

                    List<WebElement> rowdata = driver.findElements(By.xpath("//h2[text()='Data summary']/../table/tr[1]/td"));
                    for (int i = 0; i <= rowdata.size() - 1; i++) {
                        List<ArrayList> data1 = data.get(i);
                        for (int j = 0; j <= data1.size() - 1; j++) {
                            WebElement element = driver.findElement(By.xpath("//h2[text()='Data summary']/../table/tr[" + (i + 1) + "]/td[" + (j + 1) + "]"));
                            String text = element.getText();
                            String value = (data.get(i).get(j)).toString();
                            if (text.contains(value)) {
                                Thread.sleep(1000);
                                elementFocus(element);
                            }
                        }
                    }
                }
            } else {
                WaitUntil(UtilityDataSummaryTable);
                if (UtilityDataSummaryTable.isDisplayed()) {
                    elementFocus(UtilityDataSummaryTable);
                    System.out.println(TableName + " Data summary Table");
                    List<ArrayList> data = ArrayDataFromExcel("OfficeTabularData", TableName + " Data summary Table");

                    List<WebElement> rowdata = driver.findElements(By.xpath("//h3[text()='Data summary']/../table/tr[1]/td"));
                    for (int i = 0; i <= rowdata.size() - 1; i++) {
                        List<ArrayList> data1 = data.get(i);
                        for (int j = 0; j <= data1.size() - 1; j++) {
                            WebElement element = driver.findElement(By.xpath("//h3[text()='Data summary']/../table/tr[" + (i + 1) + "]/td[" + (j + 1) + "]"));
                            String text = element.getText();
                            String value = (data.get(i).get(j)).toString();
                            if (text.contains(value)) {
                                Thread.sleep(1000);
                                elementFocus(element);
                            }
                        }
                    }
                }
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void verifyDataEntryTable() throws Exception {
        shortWait();
        String s = "Level,Tenancy name and functional space description,NLA (m2),Is the area excluded?,Occupancy (days/yr),Fitout works (days/yr),Area method of measurement,Occupied days per week,Start time (24hr),End time (24hr),Evidence for core hours,Name and position of person surveyed,Unusual or AHAC hours (hrs/yr),Is area or hours estimated?,Total hours per week,Rated area (m2), Rated hours (hrs/wk) ";
        String str[] = s.split(",");
        List<WebElement> ele = driver.findElements(By.xpath("//div[@class='ht_clone_top_left_corner handsontable']/div/div/div/table/thead/tr/th/div"));
        for (WebElement element : ele) {
            for (int i = 0; i < str.length; i++) {
                if (str[i].contains(element.getText())) ;
                elementFocus(element);
            }
        }
        for (WebElement element : DataEntryTableHeader) {
            for (int i = 0; i < str.length; i++) {
                if (str[i].contains(element.getText())) ;
                elementFocus(element);
            }
        }
    }

    public void EnterDataIntoDataEntryTable() {
        try {
            HashMap<String, String> ReadFromExcel = DataFromExcell("Office", "Area and hours");
            shortWait();
            try {
                EnterValueIntoAreaAndHourTable(driver, "OfficeTabularData", ReadFromExcel.get("Table Name"));
            } catch (Exception e) {
            }
            try {
                FillDataIntoTheWebTable(driver, "OfficeTabularData", ReadFromExcel.get("Table Name"));
            } catch (Exception e) {
            }

            JavascriptExecutor jsc = (JavascriptExecutor) driver;
            jsc.executeScript("window.scrollBy(0,800)");
            if (ReadFromExcel.get("Were any areas excluded on the basis of consumption data").equalsIgnoreCase("Yes")) {
                shortWait();
                ChooseRadioBtn(WereAnyAreasExcludedOnBasisOfConsumptionData, ReadFromExcel.get("Were any areas excluded on the basis of consumption data"));
                WaitUntil(DetailWhyThisDataCouldNotBeObtained);
//                TextField(DetailWhyThisDataCouldNotBeObtained, ReadFromExcel.get("detail why this data could not be obtained"));
//                TextField(ExplainWhyLowerPriorityMethods, ReadFromExcel.get("why lower priority methods TextArea"));
                elementFocus(DetailWhyThisDataCouldNotBeObtained);
                clickAndEnterValueInTextBox(DetailWhyThisDataCouldNotBeObtained,ReadFromExcel.get("detail why this data could not be obtained"));
                elementFocus(ExplainWhyLowerPriorityMethods);
                clickAndEnterValueInTextBox(ExplainWhyLowerPriorityMethods,ReadFromExcel.get("why lower priority methods TextArea"));

            } else {
                ChooseRadioBtn(WereAnyAreasExcludedOnBasisOfConsumptionData,"Yes");
                Thread.sleep(3000);
                TextField(ExplainWhyLowerPriorityMethods, ReadFromExcel.get("why lower priority methods TextArea"));
                ChooseRadioBtn(WereAnyAreasExcludedOnBasisOfConsumptionData, ReadFromExcel.get("Were any areas excluded on the basis of consumption data"));
                TextField(ExplainWhyLowerPriorityMethods, ReadFromExcel.get("why lower priority methods TextArea"));

            }


        } catch (Exception e) {
        }
    }


    public void GridElectricit_Office(String TableName) {
        verifyDataSummaryTable(TableName);
    }

    public void verifyInclusionSection() {
        try {
//            elementFocus(GridInclusion);
            for (WebElement ele : GridInclusionSector) {
                elementFocus(ele);
            }
            elementFocus(AddOtherInclusion);
            jsClick(AddOtherInclusion);
            for (WebElement ele : AddOtherInclusion_DropDown) {
                elementFocus(ele);
            }
        } catch (Exception e) {

        }
    }

    public void verifyExclusionSection() {
        try {
//            elementFocus(GridExclusion);
            elementFocus(ExclusionSector_Add_NUM);
            elementFocus(AddOtherExclusion);
            jsClick(AddOtherExclusion);
            for (WebElement ele : AddOtherExclusion_DropDown) {
                elementFocus(ele);
            }
        } catch (Exception e) {

        }
    }


    public void ClickAddUtilityMeterInclusion(String text) throws InterruptedException {
        ChooseRadioBtn(GridInclusionSector, text);
    }

    public void ClickOnUtilty() throws InterruptedException {
        jsClick(utility1Menu);
        WaitUntil(utility1CurrentPage);
    }

    public void verifyMeterDetailSection() throws Exception {
        HashMap<String, String> ReadFromExcel = DataFromExcell("Office", "Grid electricity");
        HashMap<Integer, HashMap<String, String>> tableData = DataForTable("OfficeTabularData", driver, "Utility meter");
        WaitUntil(DescriptionOfCoverage);
        elementFocus(DescriptionOfCoverage);
        elementFocus(NMI);
        elementFocus(ElectricityProvider);
        elementFocus(AccountNumber);
    }

    public void SelectanySourceOfGasAndLpg() throws IOException, InterruptedException {
        CommonPageElements commonPageElements = new CommonPageElements(driver);
        HashMap<String, String> ReadFromExcel = DataFromExcell("Office", "Gas and LPG");
        System.out.println(ReadFromExcel.get("Are there any sources of gas or LPG in the rated premises?"));
        shortWait();
        ChooseRadioBtn(commonPageElements.AreThereAnySourcesOfGas_LPGInTheRatedPremises, ReadFromExcel.get("Are there any sources of gas or LPG in the rated premises?"));

    }

    public void EnterDetailsIntoWater(String Sector){
        try{
            HashMap<String, String> ReadFromExcel = DataFromExcell(Sector, "Water");
            if (ReadFromExcel.get("Utility Meter").equalsIgnoreCase("Yes")) {
                HashMap<Integer, HashMap<String, String>> tableData = DataForTable(Sector + "TabularData", driver, "Water Utility meter");
                for (int NumberOfUtility = 1; NumberOfUtility <= tableData.size(); NumberOfUtility++) {
                    WaitUntil(AddUtilityMeter);
                    jsClick(AddUtilityMeter);
                    shortWait();
                    WaterUtilityMeter(NumberOfUtility, tableData.get(NumberOfUtility), Sector + "TabularData");
                    shortWait();
                    Tooltip();
                }
            }
        }catch (Exception e){

        }

    }


}
