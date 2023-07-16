package mainFunctionalities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Module2_Electronics {
  @Test
  public void product2() throws Exception 
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

		//click on Electronics Module
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a")).click();
		Thread.sleep(2000);

//		//Scroll 
//		JavascriptExecutor j1= (JavascriptExecutor)driver;
//		j1.executeScript("window.scrollBy(0,300)");
//		Thread.sleep(2000);

		//Click on Cell Phones
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/h2/a")).click();

//		//Scroll
//		JavascriptExecutor j2= (JavascriptExecutor)driver;
//		j2.executeScript("window.scrollBy(0,200)");
//		Thread.sleep(2000);

		//Sort By 
		Select s1= new Select(driver.findElement(By.id("products-orderby")));
		s1.selectByVisibleText("Price: Low to High");
		Thread.sleep(2000);

		//Select Display
		Select s2= new Select(driver.findElement(By.id("products-pagesize")));
		s2.selectByVisibleText("9");
		Thread.sleep(2000);

		//Click on Product
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[1]/a/img")).click();
		Thread.sleep(2000);
		
		//Quantity 2 
		driver.findElement(By.id("product_enteredQuantity_18")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("product_enteredQuantity_18")).sendKeys("2");
		Thread.sleep(2000);
		
		//Scroll
		JavascriptExecutor j2= (JavascriptExecutor)driver;
		j2.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		
		//Screenshot
		File SS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SS , new File("C:\\Users\\ASUS\\Desktop\\Automation Testing\\Eclipse1\\Automation_FinalProject\\src\\test\\resources\\Screenshot\\Module2\\product2.jpg") );
		
		//Add to cart
		driver.findElement(By.id("add-to-cart-button-18")).click();
		
		
  }
}
