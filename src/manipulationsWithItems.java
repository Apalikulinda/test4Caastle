import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


	public class manipulationsWithItems {

		//@BeforeTest
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

			//login
			WebElement customerEmail = driver.findElement(By.cssSelector("#customer_email"));
			customerEmail.sendKeys("test+precondition+stripe+subscriber+1581341632948@gwynniebee.com");
			//customerEmail.sendKeys("wbnmuuvl@yomail.info");
			WebElement customerPassword = driver.findElement(By.cssSelector("#customer_password"));
			customerPassword.sendKeys("123456");
			System.out.println("Filled fields with data");
			//customerPassword.sendKeys("qwaqwa123");
			driver.findElement(By.cssSelector("#login-submit")).click();


			//@Test
			//public void doSomething() {
				//check that test was loged in as subscriber
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Fill-1")));
				WebElement noneSubscriber = driver.findElement(By.cssSelector("#subscribe_link_nh"));
				Assert.assertFalse(noneSubscriber.isDisplayed());

				WebElement subscribersName = driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header:nth-child(48) div.header-v1-container.header-elements-container:nth-child(2) header.row.expanded.clearfix.header-common.header-elements:nth-child(1) section.logo-nav-container section.logo-bar.clearfix.promotion-bar-new section.small-4.medium-4.column.right-side-links.new-utility-header:nth-child(12) div.contact-info.utility-header:nth-child(2) div.head-nav div.customer.clearfix ul.row.closet-link-ul li.p-relative.user-dd-wrap.gb-point:nth-child(4) > div.customer-name-header.hide-for-small-only.new-header-dropdown-link.customer-name-link"));
				String specialClass = subscribersName.getAttribute("class");
				Assert.assertTrue(specialClass.contains("customer-name-header"));

				//open ATQA collection page
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Fill-1")));
				WebElement openAtqCollection = driver.findElement(By.cssSelector("#atqa-collection"));
				openAtqCollection.click();

				//check that ATQA collection was opened
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#BreadFiltComb")));
				WebElement atqaCollection = driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.filter-combo.bread-filt-comb:nth-child(1) li:nth-child(1) > h2.subtitle-seo"));
				String atqaCollectionText = atqaCollection.getText();
				System.out.println(atqaCollectionText);
				Assert.assertTrue(atqaCollectionText.equalsIgnoreCase("ATQA collection"));

				//open Product Page
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.row.small-up-2.medium-up-3.large-up-3.small-block-grid-2.medium-block-grid-3.large-block-grid-3.product-ul.text-center:nth-child(2) li.column.column-block.pos-rel:nth-child(1) div.hover-item a.js-product-anchor div:nth-child(1) > img.full-width.product-img.ae-img")));
				driver.findElement(By.cssSelector("body.ae-lang-en.ae-device-desktop.ae-:nth-child(2) div.page-wrapper.below.header.collection-scroll-fix:nth-child(48) div.page-wrapper-below-header:nth-child(4) div.main-content.main-content-new-header:nth-child(1) section.clearfix div.responsive.seo-collection-wrapper.faceted-search-hb-div.clearfix.collection-variation-b:nth-child(2) div.clearfix.faceted-mobile:nth-child(4) section.column.small-12.medium-9.gb-product-section:nth-child(2) ul.row.small-up-2.medium-up-3.large-up-3.small-block-grid-2.medium-block-grid-3.large-block-grid-3.product-ul.text-center:nth-child(2) li.column.column-block.pos-rel:nth-child(1) div.hover-item a.js-product-anchor div:nth-child(1) > img.full-width.product-img.ae-img")).click();

				//check that Product page was opened
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#galen-dekstop-garment-title")));
				WebElement product = driver.findElement(By.cssSelector("#galen-dekstop-garment-title"));
				//System.out.println(product.getText());
				String productText = product.getText();
				Assert.assertTrue(productText.contains("PRODUCT"));
			}
		}





