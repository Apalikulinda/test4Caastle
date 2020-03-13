import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class doingThings {
	public String baseUrl = "https://camelot-qa.caastle.com/password";
	public WebDriver driver;

	@BeforeTest
	//public static void main (String[] args) {
	public void setBaseUrl() {
		driver = new ChromeDriver();
		driver.get(baseUrl);
		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("caastle");
		driver.findElement(By.cssSelector("[name='commit']")).click();
	}

	@Test(priority = 0)
	public void verifyHomepageTitle() {
		String expectedTitle = "NY&Company Closet";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 1)
	public void verifyPopup() {
		WebElement openSignUpForm = driver.findElement(By.id("account_link_nh"));
		openSignUpForm.click();
		WebElement signUp = driver.findElement(By.cssSelector("#login_content"));
		Assert.assertTrue(signUp.isDisplayed());
	}

	@Test(priority = 2)
	public void verifyLogin() {
		WebElement customerEmail = driver.findElement(By.cssSelector("#customer_email"));
		customerEmail.sendKeys("test+precondition+stripe+subscriber+1581341632948@gwynniebee.com");
		WebElement customerPassword = driver.findElement(By.cssSelector("#customer_password"));
		customerPassword.sendKeys("123456");
		driver.findElement(By.cssSelector("#login-submit")).click();
	}

	@Test(priority = 3)
	public void verifySubscriber() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Fill-1")));
		WebElement noneSubscriber = driver.findElement(By.cssSelector("#subscribe_link_nh"));
		Assert.assertFalse(noneSubscriber.isDisplayed());

		WebElement Subscriber = driver.findElement(By.cssSelector("div[role='button']"));
		String specialClass = Subscriber.getAttribute("class");
		Assert.assertTrue(specialClass.contains("customer-name-header"));
	}

	@Test(priority = 4)
	public void verifyCollectionPageOpened() {
		WebElement openAtqCollection = driver.findElement(By.cssSelector("#atqa-collection"));
		openAtqCollection.click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#BreadFiltComb")));
		WebElement atqaCollection = driver.findElement(By.cssSelector("#BreadFiltComb"));
		String atqaCollectionText = atqaCollection.getText();
		System.out.println(atqaCollectionText);
		Assert.assertTrue(atqaCollectionText.equalsIgnoreCase("ATQA collection"));

	}
	@Test(priority = 5)
	public void verifyAvailableItem () {
		WebElement enableHangerIcon = driver.findElement(By.cssSelector("[data-position='1'] > span:nth-child(1)"));
		Assert.assertTrue(enableHangerIcon.isEnabled());

	}

	@Test(priority = 6)
	public void verifyProductPageOpened() {
		driver.findElement(By.cssSelector("[data-position='1'] .product-img")).click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#galen-dekstop-garment-title")));
		WebElement product = driver.findElement(By.cssSelector("#galen-dekstop-garment-title"));
		String productText = product.getText();
		Assert.assertTrue(productText.contains("PRODUCT"));
	}

	@Test(priority = 7)
	public void verifyItemWasAdded() {

		//pick size and add to cart
		driver.findElement(By.cssSelector("[content='100071-BLK-S']")).click();
		driver.findElement(By.cssSelector("button#add-to-cart")).click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("size-selector__in-closet-label")));
		WebElement closetLabel = driver.findElement(By.className("size-selector__in-closet-label"));
		String closetLabelText = closetLabel.getText();
		Assert.assertTrue(closetLabelText.contains("IN CLOSET"));







		//new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#add-to-cart")));
		//WebElement changedButton = driver.findElement(By.cssSelector("button#add-to-cart"));
		//String changedButtonText = changedButton.getText();
		//System.out.println(changedButtonText);
		//Assert.assertTrue(changedButtonText.equalsIgnoreCase("In your closet"));

	}

	@Test(priority = 8)
	public void verifyClosetPage() {

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#closet_link_nh")));
		driver.findElement(By.cssSelector("#closet_link_nh")).click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#on-rack-li"))));
		WebElement closetHeaderBar = driver.findElement(By.cssSelector(".closet-heading-bar__menu"));
		String closetHeaderBarText = closetHeaderBar.getText();
		Assert.assertTrue(closetHeaderBarText.contains("AT-HOME\n" + "ON-THE-RACK\n" + "ON-HOLD"));
		//System.out.println(closetHeaderBarText);

		WebElement closetHeadingRackElement = driver.findElement(By.cssSelector("#on-rack-li"));
		closetHeadingRackElement.click();
	}


	@Test(priority = 9)
	public void optionsWrapper() {
		WebElement openOptions = driver.findElement(By.cssSelector(".closet-item-description-inner"));
		openOptions.click();

		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".closet-item-actions-wrapper")));
		WebElement optionsWrapper = driver.findElement(By.cssSelector(".closet-item-actions-wrapper"));
		String optionsWrapperText = optionsWrapper.getText();
		System.out.println(optionsWrapperText);
		Assert.assertTrue(optionsWrapperText.contains("PRIORITIZE\n" + "OFF\n" + "HOLD\n" + "DELETE"));

	}

	@Test(priority = 10)
	public void verifyRemovingItem() {
		WebElement deleteButon = driver.findElement(By.id("100071-BLK-S-delete"));
		deleteButon.click();

		WebElement noProducts = driver.findElement(By.cssSelector(".on-rack-products"));
	}



}









/*
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#on-rack-li")));
		WebElement rank = driver.findElement(By.cssSelector("#on-rack-li"));
		String rankText = rank.getText();
		System.out.println(rankText);
		Assert.assertTrue(rankText.equalsIgnoreCase("ON-THE-RACK"));
*/

/*
	@Test (priority = 8)
	public void verifyItemOptions() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("on-rack-products row ppt ppb closet-items-wrapper")));
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#option-100071-BLK-S")));
		driver.findElement(By.cssSelector("#option-100071-BLK-S")).getText();
		//WebElement dropMenu = driver.findElement((By.className("bottom-buttons-wrap")));
		//System.out.println(dropMenu.getText());
 */

/*
	@Test (priority = 9)
	public void verifyDelete(){
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.className("bottom-buttons-wrap")));
		driver.findElement(By.cssSelector("#100071-BLK-S-delete")).click();
	}
 */

/*
	@AfterTest
	public void endSession () {
		driver.quit();
	}
*/




