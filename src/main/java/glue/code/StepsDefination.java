package glue.code;

import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import genric.methods.ExcelLibrary;
import genric.methods.ReadTestData;
import genric.methods.ReadXpath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefination {


	@Given("all cookies cleared")
	public void all_cookies_cleared() throws IOException {
		try {
			BrowserManager.driver.manage().deleteAllCookies();
			System.out.println("All cookies deleted succesfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Given("user enters the url")
	public void user_enters_the_url() throws IOException {
		try {
			BrowserManager.driver.get(ReadTestData.propertyReader("url"));
			System.out.println("User entered the url ");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}


	@Then("^user click on element \"([^\"]*)\"$")
	public void then_user_click_on_element_element(String element) {
		try {
			String xpath=ReadXpath.xpathReader(element);
			BrowserManager.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			BrowserManager.driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();
			BrowserManager.sf.assertAll();
		}
	}

	@And("^user waits for the element \"([^\"]*)\" availability$")
	public void user_waits_for_the_element_element_availability(String element) {
		try {
			BrowserManager.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(ReadXpath.xpathReader(element))));
			System.out.println(element+" is available now");
		} catch (Exception e) {
			e.printStackTrace();
			BrowserManager.sf.fail("Unable to wait for this elements availability");
		}
	}

	@And("^user waits for (.*) seconds$")
	public void user_waits_for_this_seconds(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (Exception e) {
			e.printStackTrace();
			BrowserManager.sf.fail("Unable to hard wait for this duration");
		}
	}


	@Then("^user is on \"([^\"]*)\"$")
	public void user_is_on_element(String page) {
		try {
			String xpath=ReadXpath.xpathReader(page);
			BrowserManager.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			BrowserManager.driver.findElement(By.xpath(xpath)).isDisplayed();
			System.out.println("User is at "+page);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}





	@Then("^user enters on \"([^\"]*)\" from sheet \"([^\"]*)\" at (.*) row at (.*) cell$")
	public void user_enters_city_element(String city, String sheetname, int row, int cell) {
		try {
			String xpath=ReadXpath.xpathReader(city);
			BrowserManager.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			WebElement element=BrowserManager.driver.findElement(By.xpath(ReadXpath.xpathReader(city)));
			element.click();
			if (!element.getAttribute("value").isEmpty()) {
				BrowserManager.javaScExecut.executeScript("arguments[0].value = '';", element);
			}
			String cityFromExcel=ExcelLibrary.getCellValue(ReadTestData.propertyReader(sheetname), row, cell);
			
			element.sendKeys(cityFromExcel);
			if (cityFromExcel.contains(" ")) {
				String []splitted=cityFromExcel.split(" ");
				cityFromExcel=splitted[1];
			}
			List<WebElement> list=BrowserManager.driver.findElements(By.xpath(ReadXpath.xpathReader("CityDropDown")));
			BrowserManager.wait.until(ExpectedConditions.visibilityOfAllElements(list));
			String CityXpath=ReadXpath.xpathReader("CityDropDownOptionSelect").replaceAll("City", cityFromExcel);
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getText().contains(cityFromExcel)) {
					BrowserManager.driver.findElement(By.xpath(CityXpath)).click();
				}
			}
			System.out.println("User is at "+cityFromExcel);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}



	@Then("^user enters date on \"([^\"]*)\" from sheet \"([^\"]*)\" at (.*) row at (.*) cell$")
	public void user_enters_date_element(String dateElement, String sheetname, int row, int cell) {
		try {
			String xpath=ReadXpath.xpathReader(dateElement);
			BrowserManager.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			WebElement element=BrowserManager.driver.findElement(By.xpath(ReadXpath.xpathReader(dateElement)));
			element.click();
			if (!element.getAttribute("value").isEmpty()) {
				BrowserManager.javaScExecut.executeScript("arguments[0].value = '';", element);
			}
			String DateFromExcel=ExcelLibrary.dateGetter(ReadTestData.propertyReader(sheetname), row, cell);

			DateFromExcel=DateFromExcel.replaceAll("-", " ");
			element.sendKeys(DateFromExcel);
			System.out.println("Formatted Date is "+DateFromExcel);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	@Then("^user closes the popup \"([^\"]*)\"$")
	public void closePopup(String popup) {
		try {
			String xpath=ReadXpath.xpathReader(popup);
			BrowserManager.driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
			WebElement element= BrowserManager.driver.findElement(By.xpath(xpath));
			if (element.isDisplayed()) {
				element.click();
			}
		} catch (Exception e) {
			System.out.println("Unable to find the popup");
			BrowserManager.sf.assertAll();
		}
	}

	@Then("^user gets the flight number \"([^\"]*)\" aircraft type \"([^\"]*)\" price of flight \"([^\"]*)\" at row (.*)$")
	public void getFlightDetails(String flightNumber, String aircraftType, String price, int row) {
		try {
			String flNumber=ReadXpath.xpathReader(flightNumber);
			String airType=ReadXpath.xpathReader(aircraftType);
			String priceFlight=ReadXpath.xpathReader(price);
			BrowserManager.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(flNumber)));
			WebElement fNum=BrowserManager.driver.findElement(By.xpath(flNumber));
			WebElement aTyp=BrowserManager.driver.findElement(By.xpath(airType));
			WebElement priFlig=BrowserManager.driver.findElement(By.xpath(priceFlight));
			String flightNumberValue=fNum.getText();
			String aircraftTypeValue=aTyp.getText();
			String priceValue=priFlig.getText();

			ExcelLibrary.putCellValue("sheetname", row, 7, flightNumberValue);
			ExcelLibrary.putCellValue("sheetname", row, 8, aircraftTypeValue);
			ExcelLibrary.putCellValue("sheetname", row, 9, priceValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}















	@Then("user refreshes control")
	public void user_refreshes_control() {
		try {
			BrowserManager.driver.switchTo().newWindow(WindowType.TAB);
			Thread.sleep(1000);
			Set<String> handles=BrowserManager.driver.getWindowHandles();
			ArrayList<String> list=new ArrayList<String>(handles);
			for (int i = 0; i < list.size(); i++) {
				BrowserManager.driver.switchTo().window(list.get(i));
				if(BrowserManager.driver.getTitle().contains("Etihad")) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Then("user closes browser")
	public void user_closes_browser() {
		try {
			String option=ReadTestData.propertyReader("CloseOrQuit");
			if (option.equalsIgnoreCase("close")) {
				BrowserManager.driver.close();
			}else if(option.equalsIgnoreCase("quit")) {
				BrowserManager.driver.quit();
			}else {
				System.out.println("Please choose close or quit options only");
			}
		} catch (Exception e) {
			e.printStackTrace();
			BrowserManager.sf.fail("Close function not working");
		}
	}



	@And("click on login button")
	public void click_on_login_button() {
		try {
			System.out.println("stepssuserclick on login button");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
