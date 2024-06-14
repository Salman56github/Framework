package StepDefinations;

import FrameWork.Browsers;
import FrameWork.hooks;
import Pages.ApplicationPages.DataCenter;
import Pages.ApplicationPages.Office;
import Pages.CommonPages.CreateRating;
import Pages.CommonPages.LoginPage;
import io.cucumber.java.en.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.HashMap;

import static FrameWork.Browsers.GetBrowser;
import static FrameWork.Browsers.GetUrl;
import static FrameWork.Resuable_Methods.*;
import static Pages.ApplicationPages.DataCenter.AddUtilityMeter;
import static Pages.CommonPages.Contacts.EnterDetailsIntoContacts;
import static Pages.CommonPages.CreateRating.SelectBuildingTypeAndScope;
import static Pages.CommonPages.Premises.EnterDetailsIntoPremises;
import static Pages.CommonPages.Rating_Period.EnterDetailsIntoRatingPeriod;


public class MyStepdefs {

    static WebDriver driver = Browsers.driver;


    @Given("user login as {string}")
    public void userLoginAs(String URL) {
        try {
            GetBrowser();
            GetUrl(URL);
//            TakeScreenShot("Login");
        } catch (Exception e) {
            System.out.println("Exception in userLoginAs Method " + e);
            TakeScreenShot("Login");
        }
    }

    @When("user enter the {string} and {string}")
    public void userEnterTheAnd(String username, String password) {
        try {
            LoginPage lp = new LoginPage();
            lp.SignIn(username, password);
        } catch (Exception e) {
            System.out.println("Exception in SignIn Method " + e);
            TakeScreenShot("SignIn");
        }
    }

    @Then("user should be on HomePage")
    public void userShouldBeOnHomePage() {
        try {
            LoginPage lp = new LoginPage();
            lp.VerifyCurrentPage();
//            TakeScreenShot("Home Page");
        } catch (Exception e) {
            System.out.println("Exception in Verify Home Page Method " + e);
            TakeScreenShot("Home Page");
        }
    }

    @When("user click on create a new rating")
    public void userClickOnCreateANewRating() {
        try {
            CreateRating cr = new CreateRating();
            cr.CreateRating();
//            TakeScreenShot("Create Rating");
        } catch (Exception e) {
            System.out.println("Exception in Create Rating Method " + e);
            TakeScreenShot("Create Rating");
        }
    }

    @Then("user should see {string} page")
    public void userShouldSeePage(String arg0) {
        try {
            CreateRating cr = new CreateRating();
            cr.VerifyCreateRatingPage();
//            TakeScreenShot("Verify Create Rating");
        } catch (Exception e) {
            System.out.println("Exception in Verify Create Rating Method " + e);
            TakeScreenShot("Verify Create Rating");
        }
    }

    @When("user select the building type {string}")
    public void userSelectTheBuildingType(String buildingType) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InterruptedException {
        try {
            CreateRating cr = new CreateRating();
            cr.SelectBuildingType(buildingType);
//            TakeScreenShot("Select Building Type");
        } catch (Exception e) {
            System.out.println("Exception in Select Building Type Method " + e);
            TakeScreenShot("Select Building Type");
        }
    }

    @And("user should see {string} in {string} page")
    public void userShouldSeeInPage(String text, String element) {
        try {
            VerifyCurrentPage(text, element);
        } catch (Exception e) {
            TakeScreenShot("Verify Current Page " + text + " ");
        }
    }


    @When("user enter details into Rating details on current page")
    public void userEnterDetailsIntoRatingDetailsOnCurrentPage() {
        try {
            DataCenter dc = new DataCenter();
            dc.EnterDetailsIntoRatingDetails();
        } catch (Exception e) {
            System.out.println("Exception in EnterDetailsIntoRatingDetails Method " + e);
            TakeScreenShot("EnterDetailsIntoRatingDetails");
        }
    }

    @Then("user save the {string} and click on {string}")
    public void userSaveTheAndClickOn(String arg0, String text) {
        try {
            SaveAndClick(text);
        } catch (Exception e) {
            System.out.println("Exception in SaveAndClick " + text + " Method " + e);
            TakeScreenShot("Save and click " + text + " ");
        }
    }


    @Then("user enter details into Rating period on current page")
    public void userEnterDetailsIntoRatingPeriodOnCurrentPage() {
        try {
            DataCenter dc = new DataCenter();
            dc.EnterDetailsIntoRatingPeriod();
        } catch (Exception e) {
            System.out.println("EnterDetailsIntoRatingPeriod Method " + e);
            TakeScreenShot("EnterDetailsIntoRatingPeriod");
        }
    }

    @When("user enter details into Rating period of {string}")
    public void userEnterDetailsIntoRatingPeriodOf(String Sector) {
        try{
            EnterDetailsIntoRatingPeriod(Sector);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @When("user enter details into Premises of {string}")
    public void userEnterDetailsIntoPremisesOf(String Sector) {
        try {
            EnterDetailsIntoPremises(Sector);
        } catch (Exception e) {
            System.out.println("Premises Method " + e);
            TakeScreenShot("Premises");
        }
    }


    @When("user When user enter details into Contacts of {string}")
    public void userWhenUserEnterDetailsIntoContactsOf(String arg0) {
        try {
            EnterDetailsIntoContacts(arg0);
        } catch (Exception e) {
            System.out.println("Contacts Method " + e);
            TakeScreenShot("Contacts");
        }
    }


    @When("user When user enter details into Heat rejection on current page")
    public void userWhenUserEnterDetailsIntoHeatRejectionOnCurrentPage() {
        try {
            DataCenter dc = new DataCenter();
            dc.EnterDetailsIntoHeatRejection();
        } catch (Exception e) {
            System.out.println("EnterDetailsIntoHeatRejection Method " + e);
            TakeScreenShot("EnterDetailsIntoHeatRejection");
        }

    }

    @When("user enter details into Grid electricity on current page")
    public void userEnterDetailsIntoGridElectricityOnCurrentPage() {
        try {
            DataCenter dc = new DataCenter();
            dc.EnterDetailsIntoGridElectricity();
        } catch (Exception e) {
            System.out.println("EnterDetailsIntoGridElectricity Method " + e);
            TakeScreenShot("EnterDetailsIntoGridElectricity");
        }
    }

    @When("user enter details into Grid electricity of {string}")
    public void userEnterDetailsIntoGridElectricityOf(String arg0) {
        try {
            EnterDetailsIntoGridElectricity(arg0);
        } catch (Exception e) {
            System.out.println("Grid electricity Method " + e);
            TakeScreenShot("Grid electricity");
        }
    }

    @When("user enter details into Renewable electricity on current page")
    public void userEnterDetailsIntoRenewableElectricityOnCurrentPage() {
        try {
            DataCenter dc = new DataCenter();
            dc.EnterDetailsIntoRenewableElectricity();
        } catch (Exception e) {
            System.out.println("EnterDetailsIntoRenewableElectricity Method " + e);
            TakeScreenShot("EnterDetailsIntoRenewableElectricity");
        }
    }


    @When("user enter details into Gas and LPG on current page")
    public void userEnterDetailsIntoGasAndLPGOnCurrentPage() {
        try {
            DataCenter dc = new DataCenter();
            dc.EnterDetailsIntoGasAndLPG();
        } catch (Exception e) {
            System.out.println("EnterDetailsIntoGasAndLPGOnCurrentPage Method " + e);
            TakeScreenShot("EnterDetailsIntoGasAndLPGOnCurrentPage");
        }
    }

    @When("user enter details into Diesel on current page")
    public void userEnterDetailsIntoDieselOnCurrentPage() {
        try {
            DataCenter dc = new DataCenter();
            dc.EnterDetailsIntoDiesel();

        } catch (Exception e) {
        }
    }

    @When("user enter details into Diesel of {string}")
    public void userEnterDetailsIntoDieselOf(String arg0) throws IOException, InterruptedException {
        EnterDetailsIntoDiesel(arg0);
    }

    @When("user calculate the Review summary on current page")
    public void userCalculateTheReviewSummaryOnCurrentPage() {
        try {
            DataCenter dc = new DataCenter();
            dc.EnterDetailsIntoReviewSummary();
        } catch (Exception e) {

        }
    }


    @When("user complete the Certification process on current page")
    public void userCompleteTheCertificationProcessOnCurrentPage() {
        try {
            DataCenter dc = new DataCenter();
            dc.EnterDetailsIntoCertificationProcess();
        } catch (Exception e) {

        }
    }

    @Then("user click on {string}")
    public void userClickOn(String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Thread.sleep(3000);
            WebElement element = driver.findElement(By.xpath("//span[text()='Certification process']"));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Thread.sleep(3000);
            jsClick(element);
        } catch (Exception e) {

        }

    }

    @When("user select {string} as Building type and {string} as scope")
    public void userSelectAsBuildingTypeAndAsScope(String arg0, String arg1) {
        try {
            SelectBuildingTypeAndScope(arg0, arg1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @And("user Verify the tabs displayed in the navigation menu")
    public void userVerifyTheTabsDisplayedInTheNavigationMenu() {
        try {
            Office office = new Office();
            office.verifyMenuItem();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @When("user select the {string}")
    public void userSelectTheType(String arg0) {
        try {
            Office office = new Office();
            office.SelectRatingType(arg0);
        } catch (Exception e) {
            System.out.println("Exception in SelectRatingType method " + e);
            TakeScreenShot("SelectRatingType");
        }
    }

    @And("user should see Data summary table in Area and hours page")
    public void userShouldSeeDataSummaryTableInAreaAndHoursPage() {
        try {
            Office office = new Office();
            office.verifyDataSummaryTable();
        } catch (Exception e) {

        }
    }

    @When("user verify whether Data entry table is displaying with all the components or not")
    public void userVerifyWhetherDataEntryTableIsDisplayingWithAllTheComponentsOrNot() {
        try {
            Office office = new Office();
            office.verifyDataEntryTable();
        } catch (Exception e) {

        }
    }

    @Then("user enter data into Data Entry table")
    public void userEnterDataIntoDataEntryTable() {
        try {
            Office office = new Office();
            office.EnterDataIntoDataEntryTable();
        } catch (Exception e) {
            System.out.println("Exception in EnterDataIntoDataEntryTable method  " + e);
            TakeScreenShot("EnterDataIntoDataEntryTable");
        }
    }

    @Given("user visit the {string}")
    public void userVisitThe(String arg0) {
        driver.get(arg0);
    }

    @Then("user enter {string} in the text field")
    public void userEnterInTheTextField(String arg0) {
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(arg0);
    }



    @And("user should see Data summary table in {string} page")
    public void userShouldSeeDataSummaryTableInPage(String arg0) {
        Office office = new Office();
        office.GridElectricit_Office(arg0);
    }

    @Then("user verify the inclusion section")
    public void userVerifyTheInclusionSection() {
        Office office = new Office();
        office.verifyInclusionSection();
    }

    @Then("user verify the Exclusion section")
    public void userVerifyTheExclusionSection() {
        Office office = new Office();
        office.verifyExclusionSection();

    }

    @When("user click on {string} in {string} page")
    public void userClickOnInPage(String arg0, String arg1) {
        try{
            Office office = new Office();
            office.ClickAddUtilityMeterInclusion(arg0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("user should see {string} in the navigation menu")
    public void userShouldSeeInTheNavigationMenu(String arg0) throws Exception {
        VerifyTabInNavigationMenu(arg0);
    }

    @When("user click a {string} button")
    public void userClickAButton(String arg0) {
        try {
            UserClickOnButton(arg0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("user click on Utility {int}")
    public void userClickOnUtility(int arg0) throws InterruptedException {
        Office office = new Office();
        office.ClickOnUtilty();
    }

    @Then("user verify whether Meter detail section is displayed")
    public void userVerifyWhetherMeterDetailSectionIsDisplayed() {
        try{
            Office office = new Office();
            office.verifyMeterDetailSection();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @And("user remove the utility meter")
    public void userRemoveTheUtilityMeter() throws InterruptedException {
        shortWait();
        driver.findElement(By.xpath("//small[text()='Remove this meter']")).click();
    }

    @When("user select any source of gas and lpg in the rated premises")
    public void userSelectAnySourceOfGasAndLpgInTheRatedPremises() throws IOException, InterruptedException {
        Office office = new Office();
        office.SelectanySourceOfGasAndLpg();
    }

    @When("user enter details into Gas and LPG of {string}")
    public void userEnterDetailsIntoGasAndLPGOf(String arg0) throws Exception {
        EnterDetailsIntoGasAndLPG(arg0);
    }

    @When("user enter details into {string} of {string}")
    public void userEnterDetailsIntoOf(String PageName, String sectorName) throws Exception {
        EnterDetailsIntoGasAndLPG1(PageName,sectorName);
    }


    @When("user enter details into Water of {string}")
    public void userEnterDetailsIntoWaterOf(String Sector) {
        Office office = new Office();
       office.EnterDetailsIntoWater(Sector);
    }

    @When("user enter details into Renewable electricity of {string}")
    public void userEnterDetailsIntoRenewableElectricityOf(String Sector) {
       try{
           EnterDetailsIntoRenewableElectricity(Sector);
       }catch (Exception e){
           e.printStackTrace();
       }
    }


    @And("user calculate rating on Review summary page")
    public void userCalculateRatingOnReviewSummaryPage() throws Exception {
        CalculateRating();
        validateRatingResults();
    }

    @When("user clicks on {string} in the navigation menu")
    public void userClicksOnInTheNavigationMenu(String arg0) throws InterruptedException {
        ClickOnMenuItem(arg0);
    }

    @When("user complete the Certification process of {string}")
    public void userCompleteTheCertificationProcessOf(String arg0) {
        EnterDetailsIntoCertificationProcess(arg0);

    }


}
