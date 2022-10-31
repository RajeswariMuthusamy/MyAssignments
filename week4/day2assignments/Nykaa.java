
package week4.day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		2) Mouseover on Brands and Search L'Oreal Paris
		Actions action = new Actions(driver);
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		action.moveToElement(brand).perform();
		WebElement search = driver.findElement(By.id("brandSearchBox"));
		search.sendKeys("L'Oreal Paris");

//		3) Click L'Oreal Paris
		WebElement loreal = driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]"));
		loreal.click();

//		4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		System.out.println(title);

		String expectedtitle = "L'Oreal Paris";

		if (title.contains(expectedtitle)) {
			System.out.println("Title contains L'Oreal Paris");
		} else {
			System.out.println("Title does not contain L'Oreal Paris");
		}

//		5) Click sort By and select customer top rated

		driver.findElement(By.xpath("//button[@class=' css-n0ptfk']//*[@class='arrow-icon']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']//following::div[1]")).click();
//		6) Click Category and click Hair->Click haircare->Shampoo

		driver.findElement(By.xpath("//span[text()='Category']//following::div[1]")).click();
		driver.findElement(By.xpath("//div//span[text()='Hair']//following::span[1]//*[@class='arrow-icon']")).click();
		driver.findElement(By.xpath("//div//span[text()='Hair Care']//following::span[1]//*[@class='arrow-icon']"))
				.click();
		driver.findElement(By.xpath("(//input[@type='checkbox']//following::label)[1]//div[2]")).click();
//		7) Click->Concern->Color Protection

		driver.findElement(By.xpath("//span[text()='Concern']//following::div[1]")).click();
		driver.findElement(By.xpath("//span[text()='Heat Protection']//following::div[1]")).click();

//		8)check whether the Filter is applied with Shampoo(Colour protection is not displaying now in application)
//		WebElement filter = driver.findElement(By.xpath("//span[text()='Filters Applied']//following::div[1]//div[1]//span[1]"));
//		String filtertext = filter.getText();
//		System.out.println(filtertext);

//		9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();

//		10) GO to the new window and select size as 175ml (already displayed with 175ml . so I selected 360 ML)

		Set<String> windowset = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowset);
		driver.switchTo().window(windowList.get(1));
		WebElement dropdown = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dropdownvalue = new Select(dropdown);
		dropdownvalue.selectByVisibleText("360ml");

//		11) Print the MRP of the product

		WebElement mrpPriceText = driver.findElement(By.xpath(
				"(//h1[contains(text(),'Paris Colour Protect Shampoo')]/following-sibling::div[2]/div/span[2])"));
		String price = mrpPriceText.getText();
		System.out.println("MRP of the product: " + price);
		// String formattedprice = price.replace('?', ' ');
		// System.out.println("MRP of the product: " + formattedprice);

//		12) Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();

//		13) Go to Shopping Bag 
		driver.findElement(By.className("cart-count")).click();

//		14) Print the Grand Total amount
		driver.switchTo().frame(0);
		WebElement grandtotaltext = driver.findElement(By.xpath("//span[@class='css-n8gwxi e171rb9k3']"));
		String grandTotal = grandtotaltext.getText();
		System.out.println("Grand Total Amount: " + grandTotal);

//		15) Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();

//		16) Click on Continue as Guest - option not displayed

//		17) Check if this grand total is the same in step 14 - couldn't continue..

//		18) Close all windows
		driver.quit();

	}
}
