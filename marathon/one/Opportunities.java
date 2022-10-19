package marathon.one;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opportunities {

	public static void main(String[] args) throws InterruptedException {
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
		
		WebElement acct = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", acct);

		driver.findElement(By.xpath("//div[text()='New']")).click();

		WebElement name = driver.findElement(By.xpath("//input[@name='Name']"));
		name.sendKeys("Test Leaf");
		
		WebElement stage = driver.findElement(By.xpath("(//button[@role='combobox'])[1]"));
		driver.executeScript("arguments[0].click();", stage);
		
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
		 driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
		
		driver.findElement(By.xpath("//button[@name='today']")).click();
		
		WebElement account = driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']"));
		driver.executeScript("arguments[0].click();", account);
		
		account.sendKeys("Rajeswari Muthusamy");
		
		driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title = 'Rajeswari Muthusamy']")).click();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		WebElement message = driver
				.findElement(By.xpath("//span[@class = 'toastMessage slds-text-heading--small forceActionsText']"));
		
		Thread.sleep(5000);
		String actualmessage = message.getText();
		System.out.println("Actual message: " + actualmessage);

		String expectedmessage = "Test Leaf";
		System.out.println("Expected message: " + expectedmessage);

		if (actualmessage.contains(expectedmessage)) {
			System.out.println("Message displayed as expected");
		} else {
			System.out.println("Message not displayed as expected");
		}
		
		driver.close();
	}

}
