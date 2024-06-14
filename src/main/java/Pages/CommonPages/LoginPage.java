package Pages.CommonPages;

import FrameWork.Browsers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Base64;
import java.util.HashMap;

import static FrameWork.Resuable_Methods.*;

public class LoginPage {

    static WebDriver driver=Browsers.driver;

    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement PasswordField;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement LoginBtn;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public void SignIn(String username, String password) throws Exception {
        WaitForTitle("Login");
        HashMap<String, String> ReadFromExcel = DataFromExcell("Office", "Login");
        TextField(usernameField,ReadFromExcel.get(username));
        String encodedPassword = ReadFromExcel.get(password);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword.getBytes());
        TextField(PasswordField, new String(decodedBytes));
        LoginBtn.click();
    }
    public void VerifyCurrentPage() throws InterruptedException {
      try{
          WaitForTitle("Home");
          Assert.assertEquals(driver.getTitle(),"Home");
      }
      catch (Exception e){
          System.out.println("Exception in VerifyCurrentPage()  "+ e);
      }
    }

}
