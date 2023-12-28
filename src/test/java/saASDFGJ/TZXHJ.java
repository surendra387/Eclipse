package saASDFGJ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class TZXHJ {
	WebDriver driver;
	@Test
	public void login() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		System.out.println("Browser launched successfully");
		driver.get("https://www.flipkart.com");
	
	}
}
