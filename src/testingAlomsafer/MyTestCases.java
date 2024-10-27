package testingAlomsafer;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class MyTestCases {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void SetUp() {
		driver.manage().window().maximize();

		driver.get("https://global.almosafer.com/en");
		driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")).click();
	}

	@Test(priority = 1)
	public void CheckWebLungae() {
		String ActualResulat = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedResulat = "en";
		org.testng.Assert.assertEquals(ActualResulat, ExpectedResulat);
	}

	@Test(priority = 2)
	public void CheckCurrency() {
		String ActualResulat = driver.findElement(By.xpath("//Button[@data-testid='Header__CurrencySelector']"))
				.getText();
		String ExpectedResulat = "SAR";
		org.testng.Assert.assertEquals(ActualResulat, ExpectedResulat);

	}

	@Test(priority = 3)
	public void CheckPhoneNumber() {
		String ActualResulat = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		System.out.println("the number is: " + ActualResulat);
		String ExpectedResulat = "+966554400000";
		org.testng.Assert.assertEquals(ActualResulat, ExpectedResulat);

	}
	@Test(priority = 4)
	public void CheckQitafLogo() {
		boolean ActualResulat = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
		boolean ExpectedResulat = true;
		org.testng.Assert.assertEquals(ActualResulat, ExpectedResulat);

	}
}
