import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class guestOpensCollectionPage {

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

		System.out.println("Atqa click");

		//open ATQA collection page
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.id("atqa-collection")));
		driver.findElement(By.id("atqa-collection")).click();

		System.out.println("Something is going on");

		//pick red color
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-3.js-collapse-filters:nth-child(1) div.color-filters.color-filters_round div.color-filters__buttons > button.color-filters__button.color-filters__button_red.js-color-filter.qa_color-filter.ae-button:nth-child(6)")));
		System.out.println("Page loaded");
		driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-3.js-collapse-filters:nth-child(1) div.color-filters.color-filters_round div.color-filters__buttons > button.color-filters__button.color-filters__button_red.js-color-filter.qa_color-filter.ae-button:nth-child(6)")).click();

		//check color-label
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.filter-combo.bread-filt-comb:nth-child(1) li.js-color-filter.mod-bar:nth-child(2) > span.gb-point")));
		System.out.println("Wait for label");
		//WebElement filterBar = driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.filter-combo.bread-filt-comb:nth-child(1) > li.js-color-filter.mod-bar:nth-child(2)"));
		//Assert.assertTrue(filterBar.isDisplayed());

		String filterName = driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.filter-combo.bread-filt-comb:nth-child(1) > li.js-color-filter.mod-bar:nth-child(2)")).getText();
		System.out.println(filterName);

		Assert.assertTrue(filterName.contains("GREEN"));
		Assert.assertFalse(filterName.contains("RED"));








	}
}
