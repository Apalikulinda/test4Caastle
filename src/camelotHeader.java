import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class camelotHeader {
	public static void main (String[] args) {
		String baseUrl = "https://camelot-qa.caastle.com/password";
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		WebElement password = driver.findElement(By.cssSelector("#password"));

		password.sendKeys("caastle");
		driver.findElement(By.cssSelector("div:nth-child(1) div:nth-child(1) form.storefront-password-form:nth-child(2) div.actions:nth-child(5) > input.btn")).click();

		WebElement homePageObject = driver.findElement(By.cssSelector("#login_content"));
		//WebElement homePageObject = driver.findElement(By.cssSelector("#BreadFiltComb"));
		Assert.assertTrue(homePageObject.isDisplayed());


		/*
		if (homePageObject.isDisplayed())

			System.out.println("We are on the Home Page");
		else
		{
			System.out.println("We aren't on the Home Page");
		}
        */

	}
}
