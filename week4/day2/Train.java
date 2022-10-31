package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Train {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver(); 
		 driver.get("https://erail.in/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		WebElement fromStation =  driver.findElement(By.id("txtStationFrom"));
		 fromStation.clear();
		 fromStation.sendKeys("ms");
		 fromStation.sendKeys(Keys.ENTER);
		 
		 WebElement toStation = driver.findElement(By.id("txtStationTo"));
		 toStation.clear();
		 toStation.sendKeys("mdu");
		 toStation.sendKeys(Keys.ENTER);
		 
		 driver.findElement(By.id("chkSelectDateOnly")).click();
		 
		 Thread.sleep(5000);
		 List<WebElement> allrows = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr"));
		 int rowsize = allrows.size();
		 System.out.println(rowsize);
		 
		 List<String> allTrainNames = new ArrayList<String>();
		 for(int i=2;i<=rowsize;i++)
		 {
			 //Thread.sleep(5000);
			String trainName =  driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr["+i+"]/td[2]")).getText();
			//String trainName = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr["+i+"]/td[2]")).getText();
			 allTrainNames.add(trainName);
			 //System.out.println(allTrainNames);
		 }
		 
		// int countofalltrainanameswithduplicate = allTrainNames.size();
		 
		 Set<String> SetTrainNames = new LinkedHashSet<String>();
		 
		 for(String eachtrainname: allTrainNames)
		 {
			if(!SetTrainNames.add(eachtrainname))
			{
				System.out.println("Duplicate train name: "+eachtrainname);
			}
		 }
		 
	
	}

}
