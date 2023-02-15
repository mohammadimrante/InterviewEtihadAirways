package pages.etihad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EtihadSearchPage {
	
	WebDriver driver=null;
	
	private By userName =  By.id("username");
	
	private By passWord = By.xpath("//input[@name='pwd']");
	
	private By loginButton = By.xpath("//div[.='Login ']");
	
	public EtihadSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsernamePassword(String username,String password) {
		driver.findElement(userName).sendKeys(username);
		driver.findElement(passWord).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
}
