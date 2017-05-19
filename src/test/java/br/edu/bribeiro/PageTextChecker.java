package br.edu.bribeiro;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTextChecker {

	private WebDriver driver;
	private Actions actions;
	private Util util;
	private int timeOut = 45;

	private String desiredString;
	private String currentString;
	private String externalFile;

	private WebElement pageElement;
	private String path = "src/test/java/";

	@Before
	public void setup() throws Exception {

		// chrome browser set up
		System.setProperty("webdriver.chrome.driver", "/Users/breno.ribeiro/Documents/vip_projects/chromedriver");
		this.driver = new ChromeDriver();

		// setting up a time out
		this.driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		this.actions = new Actions(driver, timeOut);
		this.util = new Util(actions);

	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void textCheckerForTermsPage() {

		String page = "https://www.socialsweethearts.de/terms.html";
		actions.openAndMaxPage(page);

		// name of the txt file already created and with the desired text
		externalFile = "TermsText.txt";

		try {
			pageElement = (WebElement) driver.findElement(By.tagName("body"));
			System.out.println(pageElement.getText());
			currentString = pageElement.getText();
			desiredString = util.readFile(path + externalFile);

		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(actions.isTheDesiredTextThere(desiredString, currentString));
	}

	@Test
	public void textCheckerForPrivacyPage() {

		String page = "https://www.socialsweethearts.de/privacy.html";
		actions.openAndMaxPage(page);

		// name of the txt file already created and with the desired text
		externalFile = "PrivacyText.txt";

		try {
			pageElement = (WebElement) driver.findElement(By.tagName("body"));
			System.out.println(pageElement.getText());
			currentString = pageElement.getText();
			desiredString = util.readFile(path + externalFile);

		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(actions.isTheDesiredTextThere(desiredString, currentString));
	}

}