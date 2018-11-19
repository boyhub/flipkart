package com.flipkart.webpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.TestBase;

public class HomePage extends TestBase {

	By searcField = By.cssSelector("input[name='q']");

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

//	Webelement Initialization
	public static WebElement element;

	public void verifyHomePageByThrowingAlert() throws Exception {
		new WebDriverWait(driver, 50)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'gaurav')]")));
		element = driver.findElement(By.xpath("//div[contains(text(),'gaurav')]"));
		if (element.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("alert('Logged Successfully - Sajadh Singh -KokoNetwork Testing')");
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
		} else {
			System.out.println("Element not visible");
		}
	}

	public void clickElectronics() {
		element = driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void navigateTo(String m) {
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='q']")));
		driver.findElement(searcField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(searcField).clear();
		driver.findElement(searcField).sendKeys(m);
		driver.findElement(searcField).sendKeys(Keys.ENTER);
	}

	public void search(String a) throws InterruptedException {
		Thread.sleep(3000);
		new WebDriverWait(driver, 40)
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='q']")));
		driver.findElement(searcField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(searcField).clear();
		driver.findElement(searcField).sendKeys(a);
		driver.findElement(searcField).sendKeys(Keys.ENTER);
	}
}