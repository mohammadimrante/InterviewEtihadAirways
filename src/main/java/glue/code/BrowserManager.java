package glue.code;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import genric.methods.ReadTestData;
import io.cucumber.*;
import io.cucumber.core.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static SoftAssert sf;
	public static Actions actions;
	public static Robot robot;
	public static JavascriptExecutor javaScExecut;
	@Before
	public void beforeMethod() throws Exception
	{
		String broswerName=ReadTestData.propertyReader("browser");
		System.err.println("launching browser : "+broswerName);
		//System.setProperty(ReadTestData.propertyReader(broswerName+"_key"), ReadTestData.propertyReader(broswerName+"_value"));
		
		if (broswerName.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(broswerName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(broswerName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Please select any browser first");
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		sf=new SoftAssert();
		actions=new Actions(driver);
		robot=new Robot();
		javaScExecut = (JavascriptExecutor)driver;
	}
	
	@After
	public void afterMethod(Scenario sc) throws IOException, InterruptedException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		if (sc.isFailed()) {
			FileUtils.copyFileToDirectory(file, new File("Screenshots/FailedScenarioScreenshots"));
		}else {
			FileUtils.copyFileToDirectory(file, new File("Screenshots/LastPageScenarioScreenshots"));
		}
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
}
