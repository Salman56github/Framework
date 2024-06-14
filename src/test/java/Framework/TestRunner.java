package Framework;


import FrameWork.Browsers;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/OFFICE.feature",
        glue = {"StepDefinations","FrameWork"},
        plugin = {"pretty","json:target/cucumber.json"}
)

public class TestRunner {


    }


