package marathon.one;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTask {

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
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']"));
		search.click();
		search.sendKeys("task");

		driver.findElement(By.xpath("//mark[text()='Task']")).click();

		driver.findElement(By.xpath("//a[@title='Show one more action']")).click();

		driver.findElement(By.xpath("//a[@title='New Task']")).click();

		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Bootcamp");

		driver.findElement(By.xpath("//a[text()='Not Started']")).click();

		driver.findElement(By.xpath("//a[text()='Waiting on someone else']")).click();

		driver.findElement(By.xpath("//button[@title='Save']")).click();

		WebElement message = driver.findElement(By.xpath("//span[@class = 'toastMessage slds-text-heading--small forceActionsText']"));
		
		Thread.sleep(5000);
		String actualmessage = message.getText();
		System.out.println("Actual message: " + actualmessage);

		String expectedmessage = "Bootcamp";
		System.out.println("Expected message: " + expectedmessage);

		if (actualmessage.contains(expectedmessage)) {
			System.out.println("Message displayed as expected");
		} else {
			System.out.println("Message not displayed as expected");
		}
	}

}
