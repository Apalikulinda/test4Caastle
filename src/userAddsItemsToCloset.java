import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class userAddsItemsToCloset {
	public static void main(String[] args) {

		String baseUrl = "https://camelot-qa.caastle.com/";
		WebDriver driver = new ChromeDriver();

		//enter password
		driver.get(baseUrl);
		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("caastle");
		driver.findElement(By.cssSelector("div:nth-child(1) div:nth-child(1) form.storefront-password-form:nth-child(2) div.actions:nth-child(5) > input.btn")).click();

		//open login popup
		WebElement openLoginForm = driver.findElement(By.id("account_link_nh"));
		openLoginForm.click();

		//login
		WebElement customerEmail = driver.findElement(By.cssSelector("#customer_email"));
		customerEmail.sendKeys("test+precondition+stripe+subscriber+1581341632948@gwynniebee.com");
		WebElement customerPassword = driver.findElement(By.cssSelector("#customer_password"));
		customerPassword.sendKeys("123456");
		driver.findElement(By.cssSelector("#login-submit")).click();

		//open ATQA collection page
		new WebDriverWait(driver, 10).until(ExpectedConditions.)
	}
}
