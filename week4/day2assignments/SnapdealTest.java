package week4.day2assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
//		1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//			2. Go to Mens Fashion
		driver.findElement(By.xpath("(//span[contains(text(),'Fashion')])[1]")).click();

//			3. Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();

//			4. Get the count of the sports shoes
		WebElement counttext = driver
				.findElement(By.xpath("//h1[contains(text(),'Sports Shoes for Men')]//following::span[1]"));
		String countofSHOES = counttext.getText();
		System.out.println(countofSHOES);
//			5. Click Training shoes

		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
//			6. Sort by Low to High
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Popularity')]//following::ul//li[2]")).click();
		Thread.sleep(3000);
//			7. Check if the items displayed are sorted correctly //need help
		//List<WebElement> listofele = driver.findElements(By.xpath("//span[contains(@class,'product-price')]"));
		
//		8.Select the price range (900-1200)
		WebElement pricefrom = driver.findElement(By.xpath("//div[@class='price-text-box']//input[1]"));
		pricefrom.clear();
		pricefrom.sendKeys("900");
		Thread.sleep(2000);
		WebElement priceto = driver.findElement(By.xpath("(//div[@class='price-text-box']//input)[2]"));
		priceto.clear();
		priceto.sendKeys("1200");
		
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
//		9.Filter with color Navy --- This is not happening
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		
//		10 verify the all applied filters 
		Boolean pricefilter = driver.findElement(By.xpath("//a[text()='Rs. 900 - Rs. 1200']")).isDisplayed();
		System.out.println("Filter based on Price = "+pricefilter);
		
//		11. Mouse Hover on first resulting Training shoes
		Actions action = new Actions(driver);
		WebElement fristResultingShoe = driver.findElement(By.xpath("(//p[@class = 'product-title'])[1]"));
		action.moveToElement(fristResultingShoe).perform();
		
//		12. click QuickView button
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		
//		13. Print the cost and the discount percentage
		String cost = driver.findElement(By.xpath("//span[@class = 'payBlkBig']")).getText();
		System.out.println("Cost of Shoe is "+cost);
		
		String percentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Offer Percentage is "+percentage);
//		14. Take the snapshot of the shoes.
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File("C:\\Users\\rajee\\screenshot.png");
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
//		15. Close the current window
		driver.findElement(By.xpath("(//div[contains(@class,'close1')])")).click();
		
//		16. Close the main window
		driver.close();
	
	}

}
