import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


	public class manipulationsWithItems {
	public static void main(String[] args) {

		String baseUrl = "https://camelot-qa.caastle.com/";
		WebDriver driver = new ChromeDriver();

		//enter password
		driver.get(baseUrl);
		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("caastle");
		driver.findElement(By.cssSelector("div:nth-child(1) div:nth-child(1) form.storefront-password-form:nth-child(2) div.actions:nth-child(5) > input.btn")).click();

		//check that Home Page was opened
		WebElement homePageObject = driver.findElement(By.cssSelector("#login_content"));
		Assert.assertTrue(homePageObject.isDisplayed());

		//open sign up popup
		WebElement openSignUpForm = driver.findElement(By.id("account_link_nh"));
		openSignUpForm.click();

		//check that Sign up form was opened
		WebElement signUp = driver.findElement(By.cssSelector("#login_content"));
		Assert.assertTrue(signUp.isDisplayed());
		}





	}




