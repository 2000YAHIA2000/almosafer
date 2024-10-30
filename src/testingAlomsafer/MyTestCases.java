package testingAlomsafer;

import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;

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
		// System.out.println("the output in test number 3 is :"+ actualResulat);
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
		// System.out.println("the output in test number 5 is
		// :"+ISHotelSearchBarSelectedAtculResult);
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
		String flightReturnDateActualResulat = flightReturn.getText();
		String[] flightReturnDateactualResulatAfterspilt = flightReturnDateActualResulat.split("\n");
		String flightReturnDateActualResulatAfterspiltFinal = flightReturnDateactualResulatAfterspilt[1]
				.replaceFirst("^0+", "");
		today = LocalDate.now();
		int dayOfMonthExpectedResulat = today.plusDays(2).getDayOfMonth();
		String dayOfMonthExpectedResulatToString = String.valueOf(dayOfMonthExpectedResulat);
		/*
		 * System.out.println("the actualResulat is :"+
		 * flightReturnDateActualResulatAfterspiltFinal);
		 * System.out.println("the expectedResulat is :"+dayOfMonthExpectedResulat);
		 */
		Assert.assertEquals(flightReturnDateActualResulatAfterspiltFinal, dayOfMonthExpectedResulatToString);

	}

	@Test(priority = 8 /* invocationCount = 5 */)
	public void chuangenLaungeRandomly() {
		String[] url = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
		int randchose = rand.nextInt(2);
		driver.get(url[randchose]);
		if (driver.getCurrentUrl().contains("en")) {
			String actualResulat = driver.findElement(By.tagName("html")).getAttribute("lang");
			String expectedResulat = "en";
			org.testng.Assert.assertEquals(actualResulat, expectedResulat);
		} else {
			String actualResulat = driver.findElement(By.tagName("html")).getAttribute("lang");
			String expectedResulat = "ar";
			org.testng.Assert.assertEquals(actualResulat, expectedResulat);
		}
	}

	@Test(priority = 9)
	public void switchToHotelSerarhBar() {
		if (driver.getCurrentUrl().contains("en")) {
			// String actualResulat =
			// driver.findElement(By.tagName("html")).getAttribute("lang");
			String[] cityName = { "Amman", "Maca", "Lodan" };
			int randchose = rand.nextInt(cityName.length);
			WebElement hotelSerach = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
			hotelSerach.click();
			WebElement textarea = driver.findElement(By.xpath(
					"//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div/div/div/input"));
			textarea.sendKeys(cityName[randchose]);
		} else if (driver.getCurrentUrl().contains("ar")) {
			// String actualResulat =
			// driver.findElement(By.tagName("html")).getAttribute("lang");
			String[] cityName = { "عمان", "مكة", "لندن" };
			int randchose = rand.nextInt(cityName.length);
			WebElement hotelSerach = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
			hotelSerach.click();
			WebElement textarea = driver.findElement(By.xpath(
					"//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div/div/div/input"));
			textarea.sendKeys(cityName[randchose]);
		}
		WebElement firstctoptin = driver.findElement(By.xpath("//li[contains(@class, 'AutoComplete__ListItem')][3]"));
		firstctoptin.click();
	}

	@Test(priority = 10)
	public void choseNumberOfGuests() throws InterruptedException {
		WebElement numOfGuests = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
		int randomChose = rand.nextInt(2);
		Select select = new Select(numOfGuests);
		select.selectByIndex(randomChose);
		WebElement SerachBouttn = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SerachBouttn.click();
		Thread.sleep(15000);
		WebElement serachReuslite = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));
		boolean actualResulat = (serachReuslite.getText().contains("stays found in")
				|| serachReuslite.getText().contains("مكان إقامة في"));
		// System.out.println(serachReuslite.getText());
		boolean expectedResulat = true;
		Assert.assertEquals(actualResulat, expectedResulat);

	}
	@Test(priority = 11)
	public void checkLostPrice() {
		WebElement lostPrice= driver.findElement(By.xpath("//div[@data-testid='srp_sort_LOWEST_PRICE']"));
		lostPrice.click();
		List<WebElement> listofPrice=driver.findElements(By.cssSelector(".__ds__comp.undefined.MuiBox-root.muiltr-1nylpq2"));
		System.out.println(listofPrice.size());
	}

}
