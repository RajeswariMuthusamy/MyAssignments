package week4.day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHTML1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// 1. Launch the URL https://html.com/tags/table/
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		//2. Get the count of number of rows
		
		List<WebElement> listrow = driver.findElements(By.xpath("(//table[@class = 'attributes-list'])//tbody//tr"));
		int numberOfRows = listrow.size();
		System.out.println("Number of Rows = "+numberOfRows);
		
		//3. Get the count of number of columns

			List<WebElement> listColumn = driver.findElements(By.xpath("(//table[@class = 'attributes-list'])//tbody//tr[2]//td"));
			int numberOfColumns = listColumn.size();
			System.out.println("Number of Columns = "+numberOfColumns);

	}

}
