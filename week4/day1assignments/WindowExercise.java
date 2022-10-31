package week4.day1assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowExercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//-----Click and Confirm new Window Opens------
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		
		Set<String> windowset = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowset);
		System.out.println(windowList);
		
		String childWindow = driver.switchTo().window(windowList.get(1)).getTitle();
		System.out.println("Title of childWindow/newly opened window = "+ childWindow);
		
		String expectedTitleodSecondWindow = "Dashboard";
		
		if(expectedTitleodSecondWindow.equals(childWindow))
		{
			System.out.println("Childwindow/New window is opened");
		}else
		{
			System.out.println("Childwindow/New window is not opened");	
		}
		driver.close();
		driver.switchTo().window(windowList.get(0));
		//------Find the number of opened tabs------
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		
		Set<String> WindowsOpenedSet = driver.getWindowHandles();
		List<String> windowsOpenedList = new ArrayList<String>(WindowsOpenedSet);
		int numberofWindowsOpened = windowsOpenedList.size();
		System.out.println("Number of Windows Opened = "+ numberofWindowsOpened);
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		System.out.println(windowsOpenedList);
		for(String eachwindow:WindowsOpenedSet)
		if(!eachwindow.equals(parentWindow))
		{
			driver.switchTo().window(eachwindow);
			driver.close();
		}
		
		driver.switchTo().window(parentWindow);
		
		//------Close all windows except Primary -------
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		
		Set<String> setwindow = driver.getWindowHandles();
		List<String> listwindow = new ArrayList<String>(setwindow);
		int sizeoflist = listwindow.size();
		System.out.println(sizeoflist);
		//String parentWindow1 = driver.getWindowHandle();
		//System.out.println(parentWindow1);
		System.out.println(setwindow);
		
		for(String eachWindow:setwindow)
		{
			if(!eachWindow.equals(parentWindow))
			{
				driver.switchTo().window(eachWindow);
				driver.close();
			}
		}
		
		driver.switchTo().window(parentWindow);
		
	//-----------Open with Delay--------------
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Thread.sleep(4000);
		Set<String> windowsets = driver.getWindowHandles();
		System.out.println("Open tab delayed ="+ windowsets);
		
		for(String eachvaluewindow : windowsets)
		{
			if(!eachvaluewindow.equals(parentWindow))
			{
				driver.switchTo().window(eachvaluewindow);
				driver.close();
			}
		}
		
	}

}
