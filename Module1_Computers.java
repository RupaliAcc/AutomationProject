package mainFunctionalities;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Module1_Computers 
{
	@Test
	public void product1() throws Exception 
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

		//click on Computer Module
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
		Thread.sleep(2000);

		//Scroll 
		JavascriptExecutor s1= (JavascriptExecutor)driver;
		s1.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);

		//Click on Notebook
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/h2/a")).click();

		//Scroll
		JavascriptExecutor s2= (JavascriptExecutor)driver;
		s2.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);

		//Select CPU Type
		driver.findElement(By.id("attribute-option-7")).click();
		Thread.sleep(2000);

		//Memory
		driver.findElement(By.id("attribute-option-10")).click();
		Thread.sleep(2000);

		//Click on Product
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div/div/div[1]/a/img")).click();
		Thread.sleep(2000);

		//Scroll
		JavascriptExecutor j2= (JavascriptExecutor)driver;
		j2.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);

		//Screenshot
		File SS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SS , new File("C:\\Users\\ASUS\\Desktop\\Automation Testing\\Eclipse1\\Automation_FinalProject\\src\\test\\resources\\Screenshot\\Module1\\product1.jpg") );


		//Add To Cart
		driver.findElement(By.id("add-to-cart-button-5")).click();

		//Scroll Up
		JavascriptExecutor s3= (JavascriptExecutor)driver;
		s3.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(2000);

	}
}
