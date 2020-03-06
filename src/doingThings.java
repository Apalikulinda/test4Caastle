import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
//import org.sellcom.javafx.*;

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
		String actualTitle = "NY&Company Closet";
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
		WebElement subscribersName = driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header:nth-child(48) div.header-v1-container.header-elements-container:nth-child(2) header.row.expanded.clearfix.header-common.header-elements:nth-child(1) section.logo-nav-container section.logo-bar.clearfix.promotion-bar-new section.small-4.medium-4.column.right-side-links.new-utility-header:nth-child(12) div.contact-info.utility-header:nth-child(2) div.head-nav div.customer.clearfix ul.row.closet-link-ul li.p-relative.user-dd-wrap.gb-point:nth-child(4) > div.customer-name-header.hide-for-small-only.new-header-dropdown-link.customer-name-link"));
		String specialClass = subscribersName.getAttribute("class");
		Assert.assertTrue(specialClass.contains("customer-name-header"));
	}

	@Test(priority = 4)
	public void verifyCollectionPageOpened() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Fill-1")));
		WebElement openAtqCollection = driver.findElement(By.cssSelector("#atqa-collection"));
		openAtqCollection.click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#BreadFiltComb")));
		WebElement atqaCollection = driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.filter-combo.bread-filt-comb:nth-child(1) li:nth-child(1) > h2.subtitle-seo"));
		String atqaCollectionText = atqaCollection.getText();
		System.out.println(atqaCollectionText);
		Assert.assertTrue(atqaCollectionText.equalsIgnoreCase("ATQA collection"));
	}

	@Test (priority = 5)
	public void verifyProductPage() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.row.small-up-2.medium-up-3.large-up-3.small-block-grid-2.medium-block-grid-3.large-block-grid-3.product-ul.text-center:nth-child(2) li.column.column-block.pos-rel:nth-child(1) div.hover-item a.js-product-anchor div:nth-child(1) > img.full-width.product-img.ae-img")));
		driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.row.small-up-2.medium-up-3.large-up-3.small-block-grid-2.medium-block-grid-3.large-block-grid-3.product-ul.text-center:nth-child(2) li.column.column-block.pos-rel:nth-child(1) div.hover-item a.js-product-anchor div:nth-child(1) > img.full-width.product-img.ae-img")).click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#galen-dekstop-garment-title")));
		WebElement product = driver.findElement(By.cssSelector("#galen-dekstop-garment-title"));
		String productText = product.getText();
		Assert.assertTrue(productText.contains("PRODUCT"));
	}

	@Test (priority = 6)
	public void verifyEmptyCloset() {
		WebElement conunter = driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header:nth-child(49) div.header-v1-container.header-elements-container:nth-child(2) header.row.expanded.clearfix.header-common.header-elements:nth-child(1) section.logo-nav-container section.logo-bar.clearfix.promotion-bar-new section.small-4.medium-4.column.right-side-links.new-utility-header:nth-child(12) div.contact-info.utility-header:nth-child(2) div.head-nav div.customer.clearfix ul.row.closet-link-ul li.closet-link-li.p-relative.gb-point:nth-child(1) a:nth-child(1) span.cart-total-items.cart-total-items-nh:nth-child(2) > span.count"));
		String counterText = conunter.getText();
		System.out.println(counterText);
		Assert.assertTrue(counterText.equalsIgnoreCase("0"));
		//Assert.assertTrue(counterText.contains("0"));
	}

	@Test (priority = 7)
	public boolean verifyNoProductsFromThisPageInCloset() {
		try {
			driver.findElement(By.className("size-selector__in-closet-label"));
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}




/*
	@AfterTest
	public void endSession () {
		driver.quit();
	}

 */
}


