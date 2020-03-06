import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
//import org.sellcom.javafx.*;

	public class camelotHeader {
	public String baseUrl = "https://camelot-qa.caastle.com/password";
	public WebDriver driver;

	@BeforeTest
		//public static void main (String[] args) {
		public void setBaseUrl () {
			driver = new ChromeDriver();
			driver.get(baseUrl);
			WebElement password = driver.findElement(By.cssSelector("#password"));
			password.sendKeys("caastle");
			driver.findElement(By.cssSelector("div:nth-child(1) div:nth-child(1) form.storefront-password-form:nth-child(2) div.actions:nth-child(5) > input.btn")).click();
		}

		@Test
		public void verifyHomepageTitle () {
			String expectedTitle = "NY&Company Closet";
			String actualTitle = "NY&Company Closet";
			Assert.assertEquals(actualTitle, expectedTitle);
		}

		@AfterTest
		public void endSession () {
			driver.quit();
		}
	}


