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
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Fill-1")));
		driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header:nth-child(48) div.header-v1-container.header-elements-container:nth-child(2) header.row.expanded.clearfix.header-common.header-elements:nth-child(1) section.small-12.clearfix.navigation-bar nav.main.top-bar section.customer.hide-for-small-only.text-center ul.clearfix.left.header-elements-nav.text-left.ae-exclude li:nth-child(8) a.navigation-menu > span:nth-child(1)")).click();

		//open Product Page
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.row.small-up-2.medium-up-3.large-up-3.small-block-grid-2.medium-block-grid-3.large-block-grid-3.product-ul.text-center:nth-child(2) li.column.column-block.pos-rel:nth-child(1) div.hover-item a.js-product-anchor div:nth-child(1) > img.full-width.product-img.ae-img")));
		driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.row.small-up-2.medium-up-3.large-up-3.small-block-grid-2.medium-block-grid-3.large-block-grid-3.product-ul.text-center:nth-child(2) li.column.column-block.pos-rel:nth-child(1) div.hover-item a.js-product-anchor div:nth-child(1) > img.full-width.product-img.ae-img")).click();

		//pick size
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header:nth-child(49) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.row.responsive.m-t.product-page-container div.product-detail-responsive.test-cam-product-71.one_image.clearfix div.product_body.clearfix div:nth-child(1) div.small-12.large-7.medium-7.columns.galen-left-column:nth-child(2) div.product-large-image.featured.small-12.large-10.medium-10.columns.image:nth-child(2) div:nth-child(2) > img.ae-img")));
		driver.findElement(By.cssSelector("#btn-size-100071-BLK-S")).click();

		//add to closet
		driver.findElement(By.cssSelector("#add-to-cart")).click();

		//open closet page
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header:nth-child(49) div.header-v1-container.header-elements-container:nth-child(2) header.row.expanded.clearfix.header-common.header-elements:nth-child(1) section.logo-nav-container section.logo-bar.clearfix.promotion-bar-new section.small-4.medium-4.column.right-side-links.new-utility-header:nth-child(12) div.contact-info.utility-header:nth-child(2) div.head-nav div.customer.clearfix ul.row.closet-link-ul li.closet-link-li.p-relative.gb-point:nth-child(1) a:nth-child(1) span.cart-total-items.cart-total-items-nh:nth-child(2) > span.count")));
		driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header:nth-child(49) div.header-v1-container.header-elements-container:nth-child(2) header.row.expanded.clearfix.header-common.header-elements:nth-child(1) section.logo-nav-container section.logo-bar.clearfix.promotion-bar-new section.small-4.medium-4.column.right-side-links.new-utility-header:nth-child(12) div.contact-info.utility-header:nth-child(2) div.head-nav div.customer.clearfix ul.row.closet-link-ul > li.closet-link-li.p-relative.gb-point:nth-child(1)")).click();

		//open on the rank page
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#on-rack-li")));
		driver.findElement(By.cssSelector("#on-rack-li")).click();

		//open options
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#option-100071-BLK-S")));
		WebElement option = driver.findElement(By.cssSelector("#option-100071-BLK-S"));
		option.click();
		/*
		I don't know the reason of the error here:
		driver.findElement(By.cssSelector("#option-100071-BLK-S")).click();
		*/

		//click to size button
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#size-100071-BLK-S")));
		WebElement size = driver.findElement(By.cssSelector("#size-100071-BLK-S"));
		size.click();
		System.out.println(size.getText());

		//check size editor
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#size-button-100071-BLK-S")));
		WebElement sizeButton = driver.findElement(By.cssSelector("#size-button-100071-BLK-S"));
		sizeButton.click();
		System.out.println(sizeButton.getText());

		String classes = sizeButton.getAttribute("class");
		Assert.assertTrue(classes.contains("selected-size"));


		//!!wait exist!!
	}
	}


