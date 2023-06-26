package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;
import com.main.baseclass.Base_Class;

public class Sonar_Datadriven extends Base_Class {
	
	public static void main(String[] args) throws InterruptedException {
		
		Xls_Reader reader = new Xls_Reader ("C:\\Users\\krishloe\\Desktop\\SonarACES\\OutboundCampaigns.xlsx");
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krishloe\\eclipse-workspace\\ExcelUtility\\Driver\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String clone = reader.getCellData("Outbound", 1, 16);
		System.out.println(clone);
		
	// Opening SONAR Campaign 						
		//driver.get(clone);
		url(driver, clone);
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//button[@class='btn copy-to-new ng-binding']")).click();	 
		Thread.sleep(3000);
		
	// SUMMARY TAB
		          
	    driver.findElement(By.xpath("//input[@title='Campaign Name']")).clear();
	    Thread.sleep(3000);

	    String campname = reader.getCellData("Outbound", 1, 17);
		driver.findElement(By.xpath("//input[@title='Campaign Name']")).sendKeys(campname);
		Thread.sleep(3000);
		
	// Description Tab for EMPs  ---> clear description and add specific country's BE 
	
//		String startDate = reader.getCellData("Outbound", 1, 20);
//	    driver.findElement(By.xpath("//input[@name='campaign.startDate']")).click();
//	    driver.findElement(By.xpath("//td[@data-handler = 'selectDay']")).sendKeys(startDate);

		driver.findElement(By.xpath("//input[@id='duration']")).clear();
		Thread.sleep(3000);
		
//		String duration = reader.getCellData("Outbound", 1, 22);
//		System.out.println(duration);
		

		
        driver.findElement(By.xpath("//input[@id='duration']")).sendKeys("2");
        Thread.sleep(3000);
	
        driver.findElement(By.xpath("//input[@name='campaign.startTimeMinutesOffset']")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='campaign.startTimeMinutesOffset']")).sendKeys("3:00 PM");
//      String startTime = reader.getCellData("Outbound", 1, 23);
//		System.out.println(startTime);
//        driver.findElement(By.xpath("//input[@name='campaign.startTimeMinutesOffset']")).sendKeys(startTime);
//		  Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='campaign.endTimeMinutesOffset']")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='campaign.endTimeMinutesOffset']")).sendKeys("9:00 PM");
        Thread.sleep(3000);
//		String endTime = reader.getCellData("Outbound", 1, 24);
//		driver.findElement(By.xpath("//input[@name='campaign.endTimeMinutesOffset']")).sendKeys(endTime);
			
		driver.findElement(By.xpath("(//button[contains(text(), 'Save')])[1]")).click();
		
		
		
		
	// After Saving, it'll ask Reason Pop-up if duration is less than 2 or 3 days. If program has to be used			
		driver.findElement(By.xpath("//textarea[@name='requiredReason']")).clear();
		String reason = reader.getCellData("Outbound", 1, 25);
		driver.findElement(By.xpath("//textarea[@name='requiredReason']")).sendKeys(reason);
//	    driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();  
		Thread.sleep(3000);
		     
	
		 
	}

}
