package week4.day1assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		String parentWindow = driver.getWindowHandle();
		Set<String> setwindow = driver.getWindowHandles();
		List<String> listWindow = new ArrayList<String>(setwindow);
		System.out.println(parentWindow);
		System.out.println(setwindow);
		
		driver.switchTo().window(listWindow.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		String title = driver.getTitle();
		System.out.println("Title of the window 2 is  "+title);
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		
	}

}
