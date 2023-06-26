package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;
import com.main.baseclass.Base_Class;

public class Test_Script extends Base_Class {
	
	public static void main(String[] args) throws InterruptedException, ParseException {
		
		Xls_Reader reader = new Xls_Reader ("C:\\Users\\krishloe\\Desktop\\SonarACES\\OutboundCampaigns.xlsx");
		
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\krishloe\\eclipse-workspace\\ExcelUtility\\Driver\\chromedriver.exe");
//				WebDriver driver = new ChromeDriver();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String clone = reader.getCellData("Outbound", 1, 16);
		System.out.println(clone);
		
	// Opening SONAR Campaign 						
		//driver.get(clone);
//		url(driver, clone);
//		Thread.sleep(10000);
//		driver.manage().window().maximize();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//button[@class='btn copy-to-new ng-binding']")).click();	 
//		Thread.sleep(3000);
		
	// SUMMARY TAB
		
	// Description Tab for EMPs  ---> clear description and add specific country's BE 
		
		String startDate = reader.getCellData("Outbound", 1, 20);
		System.out.println(startDate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		Date parsedate = sdf.parse(startDate);
		String format = sdf.format(parsedate);
		
		//String format = sdf.format(startDate);
		System.out.println(format);
		
//	    driver.findElement(By.xpath("//input[@name='campaign.startDate']")).click();
//	    driver.findElement(By.xpath("//a[@class='ui-state-default']")).click();
//	    WebElement start = driver.findElement(By.xpath("//td[@data-handler = 'selectDay']"));
//	    String trim = startDate.trim();
//	    System.out.println(trim);
		String duration = reader.getCellData("Outbound", 1, 22);
		System.out.println(duration);
		//String trim = duration.trim();
		//System.out.println(trim);
//	    driver.findElement(By.xpath("//input[@id='duration']")).sendKeys(trim);
//		

//		driver.findElement(By.xpath("//input[@name='campaign.startTimeMinutesOffset']")).clear();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@name='campaign.startTimeMinutesOffset']")).sendKeys("3:00 PM");
        String startTime = reader.getCellData("Outbound", 1, 23);
		System.out.println(startTime);
//        driver.findElement(By.xpath("//input[@name='campaign.startTimeMinutesOffset']")).sendKeys(startTime);
//		  Thread.sleep(3000);

//        driver.findElement(By.xpath("//input[@name='campaign.endTimeMinutesOffset']")).clear();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@name='campaign.endTimeMinutesOffset']")).sendKeys("9:00 PM");
//        Thread.sleep(3000);
		String endTime = reader.getCellData("Outbound", 1, 24);
		System.out.println(endTime);
//		driver.findElement(By.xpath("//input[@name='campaign.endTimeMinutesOffset']")).sendKeys(endTime);
			

		
	}
	
}