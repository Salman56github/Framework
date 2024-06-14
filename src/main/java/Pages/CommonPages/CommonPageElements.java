package Pages.CommonPages;

import FrameWork.Browsers;
import FrameWork.hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPageElements {

    public CommonPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[text()='Description of coverage']//following-sibling::lightning-input//input[@class='slds-input']")
    public  WebElement DescriptionOfCoverage;

    @FindBy(xpath = "//label[text()='NMI']//following-sibling::lightning-input//input[@class='slds-input']")
    public  WebElement NMI;

    @FindBy(xpath = "//label[text()='Electricity provider/supplier']//following-sibling::lightning-input//input[@class='slds-input']")
    public  WebElement ElectricityProvider;

    @FindBy(xpath = "//label[text()='Account number']//following-sibling::lightning-input//input[@class='slds-input']")
    public WebElement AccountNumber;

    @FindBy(xpath = "//label[text()='Meter number']/../div/input")
    public  WebElement Meter_Number;

    @FindBy(xpath = "//label[text()='Gas provider/supplier']//following-sibling::lightning-input//input[@class='slds-input']")
    public  WebElement GasProvider;

    @FindBy(xpath = "//label[text()='Water provider/supplier']//following-sibling::lightning-input//input[@class='slds-input']")
    public  WebElement WaterProvider;


    @FindBy(xpath = "//label[text()='Start billing period']//following-sibling::lightning-input//input")
    public  WebElement StartingDate;

    @FindBy(xpath = "//label[text()='End billing period']//following-sibling::lightning-input//input")
    public WebElement EndingDate;

    @FindBy(xpath = "//div[text()='Was any of the GreenPower you’ve entered above on-sold?']//label")
    public List<WebElement> WasAnyOfTheGreenPowerYou_veEnteredAboveOn_Sold;

    @FindBy(xpath = "//label[text()='Do you have proof that all Remote Metering Reading Systems (RMRS) have been validated within the last 10 years?']/following-sibling::lightning-radio-group//label")
    public List<WebElement> ProofOfRMRSHaveValidatedFor10years;

    @FindBy(xpath = "//label[text()='During meter validation, did any meters require adjustment?']/following-sibling::lightning-radio-group//label")
    public List<WebElement> DidAnyMetersRequireAdjustment;

    @FindBy(xpath = "//label[text()='Please answer this question if you haven’t allocated a parent utility meter to every exclusion. ']/following-sibling::lightning-textarea//textarea")
    public WebElement NUM_MandatoryTextarea;

    @FindBy(xpath = "//a[text()='Download validation record template']")
    public WebElement DownloadTemplate;

    @FindBy(xpath = "//c-no-rating-gas-overview/div[@class='slds-col slds-size_3-of-3']/label/text()/../../lightning-radio-group//label")
    public List<WebElement> AreThereAnySourcesOfGas_LPGInTheRatedPremises;

    @FindBy(xpath = "//label[text()='Are there any sources of diesel in the rated premises? (Add all sources even if consumption is zero).']/following-sibling::lightning-radio-group//label")
    public List<WebElement> AreThereAnySourcesOfDieselInTheRatedPremises;


    @FindBy(xpath = "//label[text()='Does the premises have an Onsite Renewable Energy Generation (OREG) system?']/following-sibling::lightning-radio-group//span[@class='slds-form-element__label']")
    public List<WebElement> Do_System_Has_OREG;

    @FindBy(xpath = "//span[text()='Or drop files']")
    public WebElement UploadFile;

    @FindBy(xpath = "//div[text()='If known, what is the total capacity of the OREG system (kW)?']/lightning-input/lightning-primitive-input-simple/div/div/input")
    public WebElement TotalAmountOfOREG;

    @FindBy(xpath = "//div[text()='If the OREG system is connected to a Remote Meter Reading System (RMRS), has the meter been validated?']//label")
    public List<WebElement> OREGIsConnectedToRMRS;

    @FindBy(xpath = "//label[text()='Date of validation']/..//input")
    public WebElement DateOfValidation;

    @FindBy(xpath = "//div[text()='What is the total amount of GreenPower ']/lightning-input/lightning-primitive-input-simple/div/div/input")
    public WebElement TotalAmountOfGreenPower;

    @FindBy(xpath = "//b[text()='total onsite renewable electricity consumption']/../following-sibling::lightning-input//input")
    public WebElement TotalOnsiteeRenewableEnergyConsumption;

    @FindBy(xpath = "//b[text()='LGCs were created and sold']/../lightning-input//input")
    public WebElement LGCsWereCreatedAndSold;

    @FindBy(xpath = "//b[text()='LGCs were voluntarily surrendered']/../lightning-input//input")
    public WebElement LGCsWereVoluntarilySurrendered;

    @FindBy(xpath = "//div[10]/lightning-radio-group/fieldset/div/span/label/span[@class='slds-form-element__label']")
    public List<WebElement> HasOnsiteRenewableConsumptionEnteredOnThisPage;

    @FindBy(xpath = "//div[text()='What is the total amount of ']//input")
    public WebElement  totalAmountOfDe_CoupledGreenpower;

    @FindBy(xpath = "//div[text()='What is the quantity of ']//input")
    public WebElement offsiteLargeScaleGenerationCertificates;

    @FindBy(xpath = "//textarea[@placeholder='Please add explanations here']")
    public WebElement RenewableElectricityTextarea;

    @FindBy(xpath = "//button[text()='Calculate rating']")
    public WebElement CalculateRating;

//   Certification process

    @FindBy(xpath = "//p[text()='Invoicing details']")
    public WebElement InvoicingDetails;

    @FindBy(xpath = "//b[text()='Email invoice to:']")
    public  WebElement EmailInvoiceText;

    @FindBy(xpath = "//span[text()='I confirm that the invoicing details are correct and up to date']/../span[@class='slds-checkbox_faux']")
    public WebElement IConfirm;

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

    @FindBy(xpath = "//span[text()='To the best of my knowledge, the information provided in this rating is accurate, including any changes made during the level 1 audit process, if applicable.']/../span[@class='slds-checkbox_faux']")
    public WebElement ConfirmationOfAccuracy;

    @FindBy(xpath = "//button[text()='Lodge rating']")
    public WebElement LodgeRating;

    @FindBy(xpath = "//div[@class='notificationInnerContainer']")
    public WebElement ToolTip;

}
