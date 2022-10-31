package week4.day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//--------Dragggable----------
		WebElement source = driver.findElement(By.xpath("//span[text() = 'Drag me around']"));
		
		Point locationofsource= source.getLocation();
		System.out.println(locationofsource);
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(source, 350, 25).perform();
		
		//---------Droppable------------
		
		WebElement drag = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		
		WebElement drop = driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		builder.dragAndDrop(drag, drop).perform();
		
		
		//------------Draggable Columns-------------
		
		WebElement sourcecolumn = driver.findElement(By.xpath("//span[text()='Category']"));
		
		WebElement targetcolumn = driver.findElement(By.xpath("//span[text()='Name']"));
			
		builder.dragAndDrop(sourcecolumn, targetcolumn).perform();
		
		//------------Draggable Rows ---------------
		
		WebElement sourcerow = driver.findElement(By.xpath("(//td[text()='Black Watch'])[2]"));
		
		WebElement targetrow = driver.findElement(By.xpath("(//td[text()='Bamboo Watch'])[2]"));
			
		builder.dragAndDrop(sourcerow, targetrow).perform();
		//--------------Resize image----------------
		
		WebElement image = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable')]"));
		
		System.out.println(image.getSize());
		
		builder.clickAndHold(image).moveByOffset(90, 0).perform();
		
		//-------------Progress bar---------------
		
		WebElement startbtn = driver.findElement(By.xpath("//span[text()='Start']"));
		
		startbtn.click();
		Thread.sleep(6000);
		WebElement cancelbtn = driver.findElement(By.xpath("//span[text()='Cancel']"));
		
		WebElement progressbar = driver.findElement(By.xpath("//div[contains(@class,'ui-progressbar-label')]"));
		
		String progress = progressbar.getText();
		
		System.out.println(progress);
		
		cancelbtn.click();
		
		//----------Range slider-----------------------
		
		WebElement slideleft = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[1]"));
		System.out.println(slideleft);
		builder.dragAndDropBy(slideleft, 10, 0).perform();
		WebElement slideright = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[2]"));
		System.out.println(slideleft);
		builder.dragAndDropBy(slideright, 90, 0).perform();
		driver.quit();
		
	}

}
