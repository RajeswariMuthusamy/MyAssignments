package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver(); 
		 driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		 driver.switchTo().frame("iframeResult");
		 driver.findElement(By.xpath("//button[text() = 'Try it']")).click();
		 
		 Alert text = driver.switchTo().alert();
		 text.sendKeys("Rajeswari Muthusamy");
		 text.accept();
		 WebElement alerttext = driver.findElement(By.id("demo"));
		 String textdisplayed = alerttext.getText();
		 System.out.println(textdisplayed);
		 
	}

}
