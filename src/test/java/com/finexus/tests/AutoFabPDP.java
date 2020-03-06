package com.finexus.tests; 
 import io.github.bonigarcia.wdm.WebDriverManager; 
 import java.util.ArrayList;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoFabPDP {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAutoFabPDP() throws Exception {
    driver.get("https://www.fabautoparts.com/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All-Weather Mats, Carpet Mats, Rubber Mats'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Added to wishlist'])[27]/following::img[1]")).click();
    driver.findElement(By.id("year")).click();
    new Select(driver.findElement(By.id("year"))).selectByVisibleText("2020");
    driver.findElement(By.id("year")).click();
    driver.findElement(By.id("make")).click();
    new Select(driver.findElement(By.id("make"))).selectByVisibleText("Acura");
    driver.findElement(By.id("make")).click();
    driver.findElement(By.id("model")).click();
    new Select(driver.findElement(By.id("model"))).selectByVisibleText("ILX");
    driver.findElement(By.id("model")).click();
    driver.findElement(By.id("product-addtocart-button")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search'])[3]/following::a[1]")).click();
    driver.findElement(By.id("top-cart-btn-checkout")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email Address'])[3]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email Address'])[3]/following::input[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email Address'])[3]/following::input[1]")).sendKeys("blubd.softtech@gmail.com");
  }

public void selectFrame(int index) {
		try {
			Thread.sleep(5000);
			driver.switchTo().frame(index);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void selectParentFrame() {		
		driver.switchTo().parentFrame();
	}

	public void selectWindow(int index) {
		try {
			Thread.sleep(5000);
			ArrayList<String> productCatalogueWindow = new ArrayList<String>(driver.getWindowHandles());
			// change focus to new tab
			driver.switchTo().window(productCatalogueWindow.get(index));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
