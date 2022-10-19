package marathon.one;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);

		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();

		driver.findElement(By.className("slds-icon-waffle")).click();

		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		WebElement acct = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", acct);

		driver.findElement(By.xpath("//div[text()='New']")).click();

		WebElement name = driver.findElement(By.xpath("//input[@name='Name']"));
		name.sendKeys("Rajeswari Muthusamy");

		WebElement dropdown = driver.findElement(By.xpath("(//button[@role='combobox'])[3]"));
		driver.executeScript("arguments[0].click();", dropdown);

		driver.findElement(By.xpath("//span[text()='Public']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		WebElement message = driver
				.findElement(By.xpath("//span[@class = 'toastMessage slds-text-heading--small forceActionsText']"));

		String actualmessage = message.getText();
		System.out.println("Actual message: " + actualmessage);

		String expectedmessage = "Rajeswari Muthusamy";
		System.out.println("Expected message: " + expectedmessage);

		if (actualmessage.contains(expectedmessage)) {
			System.out.println("Message displayed as expected");
		} else {
			System.out.println("Message not displayed as expected");
		}
	}

}
