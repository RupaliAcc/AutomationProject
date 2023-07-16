package mainFunctionalities;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class SmokeTesting_WithScreenshots 
{
	WebDriver driver ;

	@Test
	public void smoke() throws Exception 
	{
		Properties p= new Properties();
		FileInputStream file= new FileInputStream("C:\\Users\\ASUS\\Desktop\\Automation Testing\\Eclipse1\\Automation_FinalProject\\src\\test\\resources\\PropertyFile\\LoginLogout.properties");
		p.load(file);

		System.setProperty(p.getProperty("BrowserName"),p.getProperty("BrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.get(p.getProperty("URL"));
		Thread.sleep(2000);

		Actions a = new Actions(driver);

		List<WebElement>ls=driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li"));

		int size=ls.size();
		System.out.println("No of webelements: "+size);

		for(int i=1; i<=size; i++)
		{
			//Wait
			Thread.sleep(2000);

			//Display web-element name
			//System.out.println(driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li["+i+"]")).getText());
			WebElement web =driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li["+i+"]"));
			String text = web.getText();
			System.out.println(text);
			
			//Perform Mouse Hover
			a.moveToElement(driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li["+i+"]"))).click().perform();
			Thread.sleep(2000);
			
			//Screenshot
			File SS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(SS , new File("C:\\Users\\ASUS\\Desktop\\Automation Testing\\Eclipse1\\Automation_FinalProject\\src\\test\\resources\\Screenshot\\"+text+".jpg") );
		}
		
		

	}


}
