package week4.day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableChittorgarh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("(//i[@class ='fa fa-caret-down'])[3]")).click();
		
		driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("(//table[contains(@class,'table table-bordered table-condensed table-striped')])//tbody//td[3]"));
		int size = list.size();
		System.out.println(size);
		
		List<String> allSecurityNames = new ArrayList<String> ();		
		for(int i=1;i<size;i++)
		{
			String test = driver.findElement(By.xpath("(//table[contains(@class,'table table-bordered table-condensed table-striped')])//tbody//tr["+i+"]//td[3]")).getText();
			System.out.println(test);
			allSecurityNames.add(test);
			System.out.println(allSecurityNames);
			
		}
		
		Set<String> setnames = new LinkedHashSet<String>();
		
		for(String eachname : allSecurityNames)
		{
		if(!setnames.add(eachname))
		{
			System.out.println("Duplicate Security Names are : "+eachname);
		}
		}
	
	}

}

