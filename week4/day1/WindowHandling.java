package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver(); 
		 driver.get("https://www.irctc.co.in/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		 WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		 driver.executeScript("arguments[0].click();", button);
		 
		 driver.findElement(By.xpath("//i[@class = 'fa fa-align-justify']")).click();
		 driver.findElement(By.xpath("//label[text()='FLIGHTS']")).click();
	}

}
