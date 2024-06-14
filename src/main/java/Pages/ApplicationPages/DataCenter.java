package Pages.ApplicationPages;

import FrameWork.Browsers;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import static FrameWork.Resuable_Methods.*;
import static FrameWork.Resuable_Methods.ChooseRadioBtn;

public class DataCenter {

    static WebDriver driver = Browsers.driver;

    @FindBy(xpath = "//span[text()='Done']")
    public WebElement UploadDoneBtn;

    @FindBy(xpath = "//h1[text()='Rating details']")
    public static WebElement RatingDetailsPage;


    @FindBy(xpath = "//span[text()='Or drop files']")
    public WebElement UploadFile;

    @FindBy(xpath = "//button[text()='Save']")
    public static WebElement Savebtn;

    @FindBy(xpath = "//span[text()='Rating period']")
    public WebElement RatingPeriod;

    @FindBy(xpath = "//div/label[text()='Starting date']//following-sibling::lightning-input/lightning-datepicker/div/div/input")
    public WebElement Startingdate;

    @FindBy(xpath = "//span[text()='Premises']")
    public WebElement Premises;

    @FindBy(xpath = "//button[@class='slds-button slds-button_neutral minHeight2Lines']")
    public WebElement SearchByPreviousRatingNumber;

    @FindBy(xpath = "//button[@class='slds-button slds-button_neutral minHeight2Lines']")
    public WebElement EnterRatingNumber;

    @FindBy(xpath = "//input[@placeholder='Type name or address']")
    public WebElement Street_name_And_Number;

    @FindBy(xpath = "//div[@role='option']")
    public WebElement Street_name_And_Number_Dropdown;

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

    @FindBy(xpath = "//label[@class='slds-form-element__label']/following-sibling::lightning-radio-group//div/span/label")
    public List<WebElement> HeatRejectionmetered;

    @FindBy(xpath = "//textarea[@placeholder='Please add explanations here']")
    public WebElement HR_Textarea;

    @FindBy(xpath = "//div[@class='slds-col slds-size_1-of-1 slds-m-top_medium']//span/label")
    public static List<WebElement> DoPremisesHaveEmbeddeNetwork;

    @FindBy(xpath = "//button[text()='Add utility meter inclusion']")
    public static WebElement AddUtilityMeter;

    @FindBy(xpath = "//h3[text()='Meter details']")
    public static WebElement MeterDetails;

    @FindBy(xpath = "//h3[text()=' Meter details ']")
    public static WebElement GasAndLpgMeterDetails;

    @FindBy(xpath = "//h2[text()='Tank 1']")
    public static WebElement Tank1;

    @FindBy(xpath = "//label[text()='Description of coverage']//following-sibling::lightning-input//input[@class='slds-input']")
    public static WebElement DescriptionOfCoverage;

    @FindBy(xpath = "//label[text()='NMI']//following-sibling::lightning-input//input[@class='slds-input']")
    public static WebElement NMI;

    @FindBy(xpath = "//label[text()='Electricity provider/supplier']//following-sibling::lightning-input//input[@class='slds-input']")
    public static WebElement ElectricityProvider;

    @FindBy(xpath = "//label[text()='Account number']//following-sibling::lightning-input//input[@class='slds-input']")
    public static WebElement AccountNumber;

    @FindBy(xpath = "//label[text()='Start billing period']//following-sibling::lightning-input//input")
    public static WebElement StartingDate;

    @FindBy(xpath = "//label[text()='End billing period']//following-sibling::lightning-input//input")
    public static WebElement EndingDate;

    @FindBy(xpath = "//label[text()='Meter number']/../div/input")
    public static WebElement Meter_Number;

    @FindBy(xpath = "//label[text()='Gas provider/supplier']//following-sibling::lightning-input//input[@class='slds-input']")
    public static WebElement GasProvider;


    @FindBy(xpath = "//label[text()='Does the premises have an Onsite Renewable Energy Generation (OREG) system?']/following-sibling::lightning-radio-group//span[@class='slds-form-element__label']")
    public List<WebElement> Do_System_Has_OREG;

    @FindBy(xpath = "//div[text()='What is the total amount of GreenPower ']/lightning-input/lightning-primitive-input-simple/div/div/input")
    public WebElement TotalAmountOfGreenPower;

    @FindBy(xpath = "//div[text()='If known, what is the total capacity of the OREG system (kW)?']/lightning-input/lightning-primitive-input-simple/div/div/input")
    public WebElement TotalAmountOfOREG;

    @FindBy(xpath = "//div[text()='If the OREG system is connected to a Remote Meter Reading System (RMRS), has the meter been validated?']//label")
    public List<WebElement> OREGIsConnectedToRMRS;

    @FindBy(xpath = "//label[text()='Date of validation']/..//input")
    public WebElement DateOfValidation;

    @FindBy(xpath = "//b[text()='total onsite renewable electricity consumption']/../following-sibling::lightning-input//input")
    public WebElement TotalOnlineRenewableEnergyConsumption;

    @FindBy(xpath = "//b[text()='LGCs were created and sold']/../lightning-input//input")
    public WebElement LGCsWereCreatedAndSold;

    @FindBy(xpath = "//b[text()='LGCs were voluntarily surrendered']/../lightning-input//input")
    public WebElement LGCsWereVoluntarilySurrendered;

    @FindBy(xpath = "//div[10]/lightning-radio-group/fieldset/div/span/label/span[@class='slds-form-element__label']")
    public List<WebElement> HasOnsiteRenewableConsumptionEnteredOnThisPage;

    @FindBy(xpath = "//div[text()='What is the quantity of ']//input")
    public WebElement offsiteLargeScaleGenerationCertificates;

    @FindBy(xpath = "//textarea[@placeholder='Please add explanations here']")
    public WebElement RenewableElectricityTextarea;

    @FindBy(xpath = "//div[text()='Was any of the GreenPower you’ve entered above on-sold?']//label")
    public static List<WebElement> WasAnyOfTheGreenPowerYou_veEnteredAboveOn_Sold;

    @FindBy(xpath = "//c-no-rating-gas-overview/div[@class='slds-col slds-size_3-of-3']/label/text()/../../lightning-radio-group//label")
    public static List<WebElement> AreThereAnySourcesOfGas_LPGInTheRatedPremises;

    @FindBy(xpath = "//label[text()='Are there any sources of diesel in the rated premises? (Add all sources even if consumption is zero).']/following-sibling::lightning-radio-group//label")
    public static List<WebElement> AreThereAnySourcesOfDieselInTheRatedPremises;

    @FindBy(xpath = "//b[text()='Email invoice to:']")
    public  static WebElement EmailInvoiceText;

    @FindBy(xpath = "//p[text()='Invoicing details']")
    public  static WebElement InvoicingDetails;

    @FindBy(xpath = "//span[text()='I confirm that the invoicing details are correct and up to date']/../span[@class='slds-checkbox_faux']")
    public static WebElement IConfirm;

    @FindBy(xpath = "//span[text()='The customer is aware of what star rating they’ve achieved']/../span[@class='slds-checkbox_faux']")
    public WebElement ConfirmCustomerAuthorisation;

    @FindBy(xpath = "//div[text()='Has this rating been carried out in full compliance with the NABERS rules?']/lightning-radio-group//div//label")
    public List<WebElement> HasThisRatingBeenCarriedOut;

    @FindBy(xpath = "//div[text()='Did you carry out a site visit?']/lightning-radio-group//div//label")
    public List<WebElement> DidYouCarryOutSiteVisit;

    @FindBy(xpath = "//div[text()='Do you have any conflict of interest in conducting this rating?']/lightning-radio-group//div//label")
    public List<WebElement> DoYouHaveAnyConflictOfInterest;

    @FindBy(xpath = "(//textarea[@placeholder='Please explain why not'])[1]")
    public WebElement HasThisRatingBeenCarriedOutTextarea;

    @FindBy(xpath = "(//textarea[@placeholder='Please explain why not'])[2]")
    public WebElement DidYouCarryOutSiteVisitTextarea;

    @FindBy(xpath = "//textarea[@placeholder='Please explain the conflict of interest and if all parties have been notified']")
    public WebElement DoYouHaveAnyConflictOfInterestTextarea;

    @FindBy(xpath = "//button[text()='Calculate rating']")
    public WebElement CalculateRating;

    @FindBy(xpath = "//span[text()='To the best of my knowledge, the information provided in this rating is accurate, including any changes made during the level 1 audit process, if applicable.']/../span[@class='slds-checkbox_faux']")
    public WebElement ConfirmationOfAccuracy;

    @FindBy(xpath = "//button[text()='Lodge rating']")
    public WebElement LodgeRating;


    public DataCenter() {
        PageFactory.initElements(driver, this);
    }


    public void VerifyCurrentPage(String text, String element) {
        System.out.println("Method in progess");
        WaitUntil(RatingDetailsPage);
        if (RatingDetailsPage.isDisplayed()) {
            String value = RatingDetailsPage.getText();
            Assert.assertTrue(value.equalsIgnoreCase(text));
            System.out.println("Method passed");
        }
    }

    public void EnterDetailsIntoRatingDetails() throws Exception {
//        WaitUntil(RatingDetailsPage);
        ScrollByRobot(1);
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\Documents\\dummy-pdf_2.pdf";
       elementFocus(UploadFile);
        UploadFile(UploadFile, path);
//        UploadFile1(UploadFile);

    }

    public void EnterDetailsIntoRatingPeriod() throws Exception {
      try{
          HashMap<String, String> ReadFromExcel = DataFromExcell("Office", "Rating Period");
          String date = DataFormatter(ReadFromExcel.get("Starting date"));
          System.out.println(date);
          Startingdate.click();
          Startingdate.clear();
          Robot robot = new Robot();
          robot.keyPress(KeyEvent.VK_ENTER);
          robot.keyRelease(KeyEvent.VK_ENTER);
          Actions action = new Actions(driver);
          action.sendKeys(Startingdate, date).perform();

          Robot r = new Robot();
          r.keyPress(KeyEvent.VK_ENTER);
          r.keyRelease(KeyEvent.VK_ENTER);
      }catch (Exception e){
          System.out.println(e);
      }

    }

    public void EnterDetailsIntoPremises() throws Exception {
        HashMap<String, String> ReadFromExcel = DataFromExcell("DataCenter", "Premises");

        if (ReadFromExcel.get("Search by previous rating number").contains("Yes")) {
            jsClick(SearchByPreviousRatingNumber);
            TextField(EnterRatingNumber, ReadFromExcel.get(""));
        } else {
            TextField(Street_name_And_Number, ReadFromExcel.get("Search for street name and number"));
            WaitUntil(Street_name_And_Number_Dropdown);
            if (Street_name_And_Number_Dropdown.isDisplayed()) {
                Street_name_And_Number_Dropdown.click();
            }
        }
    }

    public void EnterDetailsIntoContacts() throws Exception {
        HashMap<String, String> ReadFromExcel = DataFromExcell("DataCenter", "Contact");
        WaitUntil(CustomerEmail);
        TextField(CustomerEmail, ReadFromExcel.get("Email address"));
        TextField(CompanyName, ReadFromExcel.get("Search company"));
        WaitUntil(CompanyNameOption);
        if (CompanyNameOption.isDisplayed()) {
            CompanyNameOption.click();
        }
        SelectFromDropDown(SelectRole, SelectRoleDropDown, ReadFromExcel.get("Role"));
        if (ReadFromExcel.get("Approver").equalsIgnoreCase("Yes")) {
            Click(ApproverBtn);
        }
        Click(SendInvite);
    }

    public void EnterDetailsIntoHeatRejection() throws Exception {
        HashMap<String, String> ReadFromExcel = DataFromExcell("DataCenter", "Heat Rejection");
        Thread.sleep(3000);
        ChooseRadioBtn(HeatRejectionmetered, ReadFromExcel.get("Heat Rejected metered"));
        TextField(HR_Textarea, ReadFromExcel.get("Would you like to add any other information"));
    }

    public void EnterDetailsIntoGridElectricity() throws Exception {
        HashMap<String, String> ReadFromExcel = DataFromExcell("DataCenter", "Grid electricity");
        ChooseRadioBtn(DoPremisesHaveEmbeddeNetwork, ReadFromExcel.get("Does Premises have embedded work"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        WaitUntil(AddUtilityMeter);
        jsClick(AddUtilityMeter);

        if (ReadFromExcel.get("Utility Meter").equalsIgnoreCase("Yes")) {
            HashMap<Integer, HashMap<String, String>> tableData = DataForTable("DataCenterTabularData", driver, "Utility meter");
            System.out.println(tableData);
            Thread.sleep(2000);
            for (int NumberOfUtility = 1; NumberOfUtility <= tableData.size(); NumberOfUtility++) {
                UtilityMeter(NumberOfUtility, driver, tableData.get(NumberOfUtility), "DataCenterTabularData");
                Thread.sleep(2000);
            }
        }
    }

//    public static void EnterDetailsIntoGridElectricity(String sector) throws Exception {
//        HashMap<String, String> ReadFromExcel = DataFromExcell(sector, "Grid electricity");
//        ChooseRadioBtn(DoPremisesHaveEmbeddeNetwork, ReadFromExcel.get("Does Premises have embedded work"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
//
//        if (ReadFromExcel.get("Utility Meter").equalsIgnoreCase("Yes")) {
//            WaitUntil(AddUtilityMeter);
//            jsClick(AddUtilityMeter);
//            HashMap<Integer, HashMap<String, String>> tableData = DataForTable(sector+"TabularData", driver, "Utility meter");
//            System.out.println(tableData);
//            Thread.sleep(2000);
//            for (int NumberOfUtility = 1; NumberOfUtility <= tableData.size(); NumberOfUtility++) {
//                UtilityMeter(NumberOfUtility, driver, tableData.get(NumberOfUtility), sector+"TabularData");
//                Thread.sleep(2000);
//            }
//        }
//        if (ReadFromExcel.get("Non Utility Meter").equalsIgnoreCase("Yes")){
//
////            HashMap<String, String> ReadFromExcel1 = DataFromExcell(sector+"TabularData", "Non Utility Meter");
//            HashMap<Integer, HashMap<String, String>> tableData = DataForTable(sector+"TabularData", driver, "Non Utility Meter1");
//
//            System.out.println(tableData);
//            Thread.sleep(2000);
//            for (int NumberOfUtility = 1; NumberOfUtility <= tableData.size(); NumberOfUtility++) {
//                NonUtilityMeter(NumberOfUtility, driver, tableData.get(NumberOfUtility), sector+"TabularData");
//                Thread.sleep(2000);
//
//            }
//        }
//    }

    public void EnterDetailsIntoRenewableElectricity() throws InterruptedException {
        try {
            HashMap<String, String> ReadFromExcel = DataFromExcell("DataCenter", "Renewable electricity");
            if (ReadFromExcel.get("Do Premises have OREG").equalsIgnoreCase("Yes")) {
                ChooseRadioBtn(Do_System_Has_OREG, ReadFromExcel.get("Do Premises have OREG"));
                String path = System.getProperty("user.dir") + "\\src\\test\\java\\Documents\\dummy-pdf_2.pdf";
                WaitUntil(UploadFile);
                UploadFile(UploadFile, path);
                TextField(TotalAmountOfOREG, ReadFromExcel.get("total capacity of the OREG"));
                ScrollByRobot(1);
                String value = ReadFromExcel.get("OREG system is connected to  RMRS");
                switch (value) {
                    case "Yes":
                        System.out.println(ReadFromExcel.get("OREG system is connected to  RMRS"));
                        ChooseRadioBtn(OREGIsConnectedToRMRS, ReadFromExcel.get("OREG system is connected to  RMRS"));
                        TextField(DateOfValidation, "30/4/2024");
                        TextField(TotalOnlineRenewableEnergyConsumption, ReadFromExcel.get("total onsite renewable electricity consumption"));
                        TextField(LGCsWereCreatedAndSold, ReadFromExcel.get("How many LGCs were created and sold"));
                        TextField(LGCsWereVoluntarilySurrendered, ReadFromExcel.get("How many LGCs were voluntarily surrendered"));
                        ChooseRadioBtn(HasOnsiteRenewableConsumptionEnteredOnThisPage, ReadFromExcel.get("Has onsite renewable consumption entered on this page"));
                        TextField(TotalAmountOfGreenPower, ReadFromExcel.get("total amount of GreenPower purchased"));
                        TextField(offsiteLargeScaleGenerationCertificates, ReadFromExcel.get("offsite Large-scale Generation Certificates"));
                        TextField(RenewableElectricityTextarea, "Nabers");
                        break;

                    case "No":
                        ChooseRadioBtn(OREGIsConnectedToRMRS, ReadFromExcel.get("OREG system is connected to  RMRS"));

                        break;

                    case "Not applicable":
                        ChooseRadioBtn(OREGIsConnectedToRMRS, ReadFromExcel.get("OREG system is connected to  RMRS"));

                        break;

                    default:
                        System.out.println(" No Option selected");
                }

            } else {
            }

        } catch (Exception e) {

        }


    }

    public void EnterDetailsIntoGasAndLPG() {
        try {
            HashMap<String, String> ReadFromExcel = DataFromExcell("DataCenter", "Gas and LPG");
            if (ReadFromExcel.get("Are there any sources of gas or LPG in the rated premises?").equalsIgnoreCase("Yes")) {
                ChooseRadioBtn(AreThereAnySourcesOfGas_LPGInTheRatedPremises, ReadFromExcel.get("Are there any sources of gas or LPG in the rated premises?"));
                if (ReadFromExcel.get("Add utility meter  inclusion").equalsIgnoreCase("Yes")) {
                    WaitUntil(AddUtilityMeter);
                    jsClick(AddUtilityMeter);
                    Thread.sleep(3000);
                    HashMap<Integer, HashMap<String, String>> tableData = DataForTable("DataCenterTabularData", driver, "Gas and LPG  utility meter");
                    Thread.sleep(2000);
                    System.out.println("salman  "+tableData);
                    for (int NumberOfUtility = 1; NumberOfUtility <= tableData.size(); NumberOfUtility++) {
                        GasAndLpgUtilityMeter(NumberOfUtility, driver, tableData.get(NumberOfUtility), "DataCenterTabularData");
                        Thread.sleep(2000);
                        ScrollUntil(Savebtn);
                    }
                }
            } else {
                ChooseRadioBtn(AreThereAnySourcesOfGas_LPGInTheRatedPremises, ReadFromExcel.get("Are there any sources of gas or LPG in the rated premises?"));
            }
        } catch (Exception e) {

        }
    }

    public void EnterDetailsIntoDiesel() {
        try {
            HashMap<String, String> ReadFromExcel = DataFromExcell("DataCenter", "Diesel");
           if (ReadFromExcel.get("Are there any sources of diesel").equalsIgnoreCase("Yes")){
               ChooseRadioBtn(AreThereAnySourcesOfDieselInTheRatedPremises, ReadFromExcel.get("Are there any sources of diesel"));

               if (ReadFromExcel.get(" Diesel Tank").equalsIgnoreCase("Yes")) {
                   System.out.println("salman check");
                   HashMap<Integer, HashMap<String, String>> tableData = DataForTable("DataCenterTabularData", driver, "Diesel Tank");
                   System.out.println(tableData);
                   Thread.sleep(2000);
                   for (int NumberOfTanks = 1; NumberOfTanks <= tableData.size(); NumberOfTanks++) {
                       DieselTanks(NumberOfTanks, driver, tableData.get(NumberOfTanks), "DataCenterTabularData");
                       Thread.sleep(2000);
                   }
               }


           }else {
               ChooseRadioBtn(AreThereAnySourcesOfDieselInTheRatedPremises, ReadFromExcel.get("Are there any sources of diesel"));
           }
        } catch (Exception e) {

        }
    }

    public void EnterDetailsIntoReviewSummary(){
        try{
            jsClick(CalculateRating);
        }catch (Exception e){
        }
    }

    public void EnterDetailsIntoCertificationProcess(){
        try{
            HashMap<String, String> ReadFromExcel = DataFromExcell("DataCenter", "Certification process");
            ScrollUntil(EmailInvoiceText);
            jsClick(IConfirm);
            jsClick(ConfirmCustomerAuthorisation);
            String path = System.getProperty("user.dir") + "\\src\\test\\java\\Documents\\dummy-pdf_2.pdf";
            UploadFile(UploadFile,path);
            ScrollByRobot(1);
            if (ReadFromExcel.get("Has this rating been carried out").equalsIgnoreCase("Yes")){
                ChooseRadioBtn(HasThisRatingBeenCarriedOut,ReadFromExcel.get("Has this rating been carried out"));
            }else {
                ChooseRadioBtn(HasThisRatingBeenCarriedOut,ReadFromExcel.get("Has this rating been carried out"));
                TextField(HasThisRatingBeenCarriedOutTextarea,"Nabers");
            }

            if (ReadFromExcel.get("Did you carry out a site visit?").equalsIgnoreCase("Yes")){
                ChooseRadioBtn(DidYouCarryOutSiteVisit,ReadFromExcel.get("Did you carry out a site visit?"));
            }
            else {
                ChooseRadioBtn(DidYouCarryOutSiteVisit,ReadFromExcel.get("Did you carry out a site visit?"));
                TextField(DidYouCarryOutSiteVisitTextarea,"Nabers");
            }
            if (ReadFromExcel.get("Do you have any conflict of interest").equalsIgnoreCase("No")){
                ChooseRadioBtn(DoYouHaveAnyConflictOfInterest,ReadFromExcel.get("Do you have any conflict of interest"));
            }else {
                ChooseRadioBtn(DoYouHaveAnyConflictOfInterest,ReadFromExcel.get("Do you have any conflict of interest"));
                TextField(DoYouHaveAnyConflictOfInterestTextarea,"Nabers");
            }
            WaitUntil(ConfirmationOfAccuracy);
            jsClick(ConfirmationOfAccuracy);
            jsClick(LodgeRating);




        }catch (Exception e){

        }
    }

}
