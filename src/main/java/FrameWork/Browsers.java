package FrameWork;

import Pages.CommonPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;

import static FrameWork.Resuable_Methods.SetBrowserWindow;


public class Browsers  {

    public static WebDriver driver=hooks.driver;

    public static void GetBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public static void GetUrl(String URl) throws InterruptedException, AWTException {
        driver.get(URl);
        SetBrowserWindow(5);
        LoginPage lp= new LoginPage();

    }
}
