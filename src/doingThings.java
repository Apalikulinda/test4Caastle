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
		driver.findElement(By.cssSelector("div:nth-child(1) div:nth-child(1) form.storefront-password-form:nth-child(2) div.actions:nth-child(5) > input.btn")).click();
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

		WebElement Subscriber = driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header:nth-child(48) div.header-v1-container.header-elements-container:nth-child(2) header.row.expanded.clearfix.header-common.header-elements:nth-child(1) section.logo-nav-container section.logo-bar.clearfix.promotion-bar-new section.small-4.medium-4.column.right-side-links.new-utility-header:nth-child(12) div.contact-info.utility-header:nth-child(2) div.head-nav div.customer.clearfix ul.row.closet-link-ul > li.p-relative.user-dd-wrap.gb-point:nth-child(4)"));
		String specialClass = Subscriber.getAttribute("class");
		System.out.println(specialClass);
		Assert.assertTrue(specialClass.contains("customer-name-header"));
	}

	@Test(priority = 4)
	public void verifyCollectionPageOpened() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Fill-1")));
		WebElement openAtqCollection = driver.findElement(By.cssSelector("#atqa-collection"));
		openAtqCollection.click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#BreadFiltComb")));
		WebElement atqaCollection = driver.findElement(By.cssSelector("#BreadFiltComb"));
		String atqaCollectionText = atqaCollection.getText();
		System.out.println(atqaCollectionText);
		Assert.assertTrue(atqaCollectionText.equalsIgnoreCase("ATQA collection"));

	}

	@Test(priority = 5)
	public void verifyProductPage() {
		//new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pageContentTitle")));
		driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(50) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.row.small-up-2.medium-up-3.large-up-3.small-block-grid-2.medium-block-grid-3.large-block-grid-3.product-ul.text-center:nth-child(2) li.column.column-block.pos-rel:nth-child(1) div.hover-item a.js-product-anchor div:nth-child(1) > img.full-width.product-img.ae-img")).click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#galen-dekstop-garment-title")));
		WebElement product = driver.findElement(By.cssSelector("#galen-dekstop-garment-title"));
		String productText = product.getText();
		Assert.assertTrue(productText.contains("PRODUCT"));
	}

	@Test(priority = 6)
	public void verifyItemWasAdded() {

		//pick size and add to cart
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header:nth-child(49) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.row.responsive.m-t.product-page-container div.product-detail-responsive.test-cam-product-71.one_image.clearfix div.product_body.clearfix div:nth-child(1) div.small-12.large-7.medium-7.columns.galen-left-column:nth-child(2) div.product-large-image.featured.small-12.large-10.medium-10.columns.image:nth-child(2) div:nth-child(2) > img.ae-img")));
		driver.findElement(By.cssSelector("#btn-size-100071-BLK-S")).click();
		driver.findElement(By.cssSelector("#add-to-cart")).click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("size-selector__in-closet-label")));
		WebElement closetLabel = driver.findElement(By.className("size-selector__in-closet-label"));
		String closetLabelText = closetLabel.getText();
		System.out.println(closetLabelText);
		Assert.assertTrue(closetLabelText.contains("IN CLOSET"));
/*
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#unclosetable_message")));
		WebElement changedButton = driver.findElement(By.cssSelector("#unclosetable_message"));
		String changedButtonText = changedButton.getText();
		System.out.println(changedButtonText);
		//Assert.assertTrue(changedButtonText.equalsIgnoreCase("In your closet"));
 */
	}

	@Test(priority = 7)
	public void verifyClosetPage() {

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#closet_link_nh")));
		driver.findElement(By.cssSelector("#closet_link_nh")).click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#on-rack-li"))));
		WebElement closetHeadingRackElement = driver.findElement(By.cssSelector("#on-rack-li"));
		String closetHeadingBarElementText = closetHeadingRackElement.getText();
		System.out.println(closetHeadingBarElementText);
		closetHeadingRackElement.click();
	}
/*
	@Test(priority = 8)
	public boolean verifyRankPage() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("#onRack"));
		System.out.println("On-the-Rank-Page! Wow!");

		WebElement closetHeadingRackActiveElement = driver.findElement(By.cssSelector("#on-rack-li"));
	}

 */
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




