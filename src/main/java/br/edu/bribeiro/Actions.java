package br.edu.bribeiro;

import org.openqa.selenium.WebDriver;

public class Actions {

	private WebDriver driver;
	private int timeOut;

	public Actions(WebDriver driver, int timeOut) {
		this.driver = driver;
		this.timeOut = timeOut;
	}

	// open and maximize a page
	public void openAndMaxPage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public boolean isTheDesiredTextThere(String desiredText, String currentString) {
		boolean result = false;
		try {
			if (desiredText.trim().replaceAll("\\s+", " ")
					.equalsIgnoreCase(currentString.trim().replaceAll("\\s+", " "))) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}
