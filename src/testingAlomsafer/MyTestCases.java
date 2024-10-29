package testingAlomsafer;

import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver driver = new ChromeDriver();
	LocalDate today;
	Random rand = new Random();

	@BeforeTest
	public void setUp() {
		driver.manage().window().maximize();

		driver.get("https://global.almosafer.com/en");
		driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")).click();
	}

	@Test(priority = 1)
	public void checkWebLungae() {
		String actualResulat = driver.findElement(By.tagName("html")).getAttribute("lang");
		String expectedResulat = "en";
		org.testng.Assert.assertEquals(actualResulat, expectedResulat);
	}

	@Test(priority = 2)
	public void checkCurrency() {
		String actualResulat = driver.findElement(By.xpath("//Button[@data-testid='Header__CurrencySelector']"))
				.getText();
		String expectedResulat = "SAR";
		org.testng.Assert.assertEquals(actualResulat, expectedResulat);

	}

	@Test(priority = 3)
	public void checkPhoneNumber() {
		String actualResulat = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		//System.out.println("the output in test number 3 is :"+ actualResulat);
		String expectedResulat = "+966554400000";
		org.testng.Assert.assertEquals(actualResulat, expectedResulat);

	}

	@Test(priority = 4)
	public void checkQitafLogo() {
		boolean actualResulat = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
		boolean expectedResulat = true;
		org.testng.Assert.assertEquals(actualResulat, expectedResulat);

	}

	@Test(priority = 5)
	public void checkIfSearchHotelIsSelected() {
		WebElement HotelSearchBar = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String iSHotelSearchBarSelectedAtculResult = HotelSearchBar.getAttribute("aria-selected");
		String expectedResulat = "false";
		// System.out.println("the output in test number 5 is :"+ISHotelSearchBarSelectedAtculResult);
		org.testng.Assert.assertEquals(iSHotelSearchBarSelectedAtculResult, expectedResulat);

	}

	@Test(priority = 6)
	public void checkFlightDeparture() {
		WebElement FlightDeparture = driver.findElement(By.xpath(
				"//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div/div[1]/span[2]"));
		String flightDepartureDateactualResulat = FlightDeparture.getText();
		today = LocalDate.now();
		int dayOfMonthexpectedResulat = today.getDayOfMonth() + 1;
		String dayOfMonthexpectedResulatToString = String.valueOf(dayOfMonthexpectedResulat);
		// System.out.println("the output in test number 6 is :" +
		// flightDepartureDateactualResulat);
		Assert.assertEquals(flightDepartureDateactualResulat, dayOfMonthexpectedResulatToString);

	}

	@Test(priority = 7)
	public void checkFlightReturn() {
		WebElement flightReturn = driver.findElement(By.xpath(
				"//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div/div[2]"));
		String flightReturnDateactualResulat = flightReturn.getText();
		String[] flightReturnDateactualResulatAfterspilt = flightReturnDateactualResulat.split("\n");
		String flightReturnDateactualResulatAfterspiltFinal = flightReturnDateactualResulatAfterspilt[1];
		today = LocalDate.now();
		int dayOfMonthexpectedResulat = today.getDayOfMonth() + 2;
		String dayOfMonthexpectedResulatToString = String.valueOf(dayOfMonthexpectedResulat);
		// System.out.println("the output in test number 7 is :"
		// +flightReturnDateactualResulat1[1]);
		Assert.assertEquals(flightReturnDateactualResulatAfterspiltFinal, dayOfMonthexpectedResulatToString);

	}

	@Test(priority = 8,invocationCount = 5)
	public void chuangenLaungeRandomly() {
		String []url= {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
		int randchose=rand.nextInt(2);
		driver.get(url[randchose]);
		if(driver.getCurrentUrl().contains("en")) {
			String actualResulat = driver.findElement(By.tagName("html")).getAttribute("lang");
			String expectedResulat = "en";
			org.testng.Assert.assertEquals(actualResulat, expectedResulat);
		}
		else {
			String actualResulat = driver.findElement(By.tagName("html")).getAttribute("lang");
			String expectedResulat = "ar";
			org.testng.Assert.assertEquals(actualResulat, expectedResulat);
			
		}
	}

}
