package week4.day1assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//2. Enter UserName and Password Using Id Locator
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("Demosalesmanager");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");
		// 3. Click on Login Button using Class Locator
		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		login.click();
		//4. Click on CRM/SFA Link
		WebElement link1 = driver.findElement(By.linkText("CRM/SFA"));
		link1.click();
		//5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();

		String title = driver.getTitle();
		System.out.println(title);

		Set<String> windows = driver.getWindowHandles();
		List<String> listhandle = new ArrayList<String>(windows);
		System.out.println(listhandle);

		driver.switchTo().window(listhandle.get(1));
		String title1 = driver.getTitle();
		System.out.println(title1);
		// 8. Click on First Resulting Contact
		WebElement fromContact = driver.findElement(By.xpath("(//tbody//tr//td//div//a)[1]"));
		fromContact.click();
		driver.switchTo().window(listhandle.get(0));
		String title2 = driver.getTitle();
		System.out.println(title2);
		// 9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> towindowhandleSet = driver.getWindowHandles();
		List<String> towindowhandlelist = new ArrayList<String>(towindowhandleSet);
		System.out.println(towindowhandlelist);
		driver.switchTo().window(towindowhandlelist.get(1));
		String title3 = driver.getTitle();
		System.out.println(title3);
		//10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//tbody//tr//td//div//a)[5]")).click();
		driver.switchTo().window(towindowhandlelist.get(0));
		String title4 = driver.getTitle();
		System.out.println(title4);
		//11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		Alert alertText = driver.switchTo().alert();
		String Text = alertText.getText();
		System.out.println("Alert Message = "+ Text);
		//12. Accept the Alert
		alertText.accept();
		//Alert text verification
		if(Text.contains("Are you sure?"))
		{
			System.out.println("Message displayed as expected");
		}else
		{
			System.out.println("Message not displayed as expected");
		}
		//13. Title of the page verification
		String title5 = driver.getTitle();
		System.out.println("Actual Title ="+title5);
		String expectedTitle = "View Contact | opentaps CRM";
		String actualTitle = title5;
		
		if(expectedTitle.equals(actualTitle))
		{
			System.out.println("Title displayed as expected");
		}else
		{
			System.out.println("Title not displayed as expected");
		}
	}

}
