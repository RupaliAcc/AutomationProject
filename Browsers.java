package crossBrowserTesting;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Browsers 
{
	@Test
	public void diffBrowsers() 
	{
		Scanner s= new Scanner(System.in);
		System.out.println("*******WELCOME TO BROWSERS*******");
		System.out.println("Enter 1 for GOOGLE CHROME \nEnter 2 for MICROSOFT EDGE \nEnter 3 for MOGILLA FIRFOX \nEnter 4 for OPERA MINI ");
		int choice=s.nextInt();

		switch(choice)
		{
		case 1:
			System.out.println("\nWELCOME TO GOOGLE CHROME ");
			System.setProperty("WebDriver.chrome.driver", "C:\\Users\\ASUS\\Desktop\\Automation Testing\\ChromeDriver\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.get("https://www.google.co.in/");
			driver.manage().window().maximize();
			driver.findElement(By.id("APjFqb")).sendKeys("Amazon");
			driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//*[@id=\"tads\"]/div/div/div/div/div[1]/a/div[1]/span")).click();
			break;

		case 2:
			System.out.println("\nWELCOME TO Microsoft Edge ");
			System.setProperty("webdriver.Edge.driver", "C:\\Users\\ASUS\\Desktop\\Automation Testing\\Browser Extension\\msedgedriver.exe");
			WebDriver driver1=new EdgeDriver();
			driver1.get("https://www.google.co.in/");
			driver1.manage().window().maximize();
			driver1.findElement(By.id("APjFqb")).sendKeys("Amazon");
			driver1.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);
			driver1.findElement(By.xpath("//*[@id=\"tads\"]/div/div/div/div/div[1]/a/div[1]/span")).click();
			break;
			
		case 3:
			System.out.println("\nWELCOME TO FireFox ");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ASUS\\Desktop\\Automation Testing\\Browser Extension\\geckodriver.exe");
			WebDriver driver2=new FirefoxDriver();
			driver2.get("https://www.google.co.in/");
			driver2.manage().window().maximize();
			driver2.findElement(By.id("APjFqb")).sendKeys("Amazon");
			driver2.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);
			driver2.findElement(By.xpath("//*[@id=\"tads\"]/div/div/div/div/div[1]/a/div[1]/span")).click();
			break;

		}


	}
}
