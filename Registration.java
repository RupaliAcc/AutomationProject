package basicProgram;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Registration 
{
	@Test
	public void newUser() throws Exception
	{
		//Step 1: Create Object Of PropertiesClass
		Properties p= new Properties();

		//Step 2: Create Object Of FileInputStream: To Store Properties file path
		FileInputStream file= new FileInputStream("C:\\Users\\ASUS\\Desktop\\Automation Testing\\Eclipse1\\Automation_FinalProject\\src\\test\\resources\\PropertyFile\\Registration.properties");

		//Step 3: Load property file
		p.load(file);

		System.setProperty(p.getProperty("BrowserName"),p.getProperty("BrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();

		//Open URL
		driver.get(p.getProperty("URL"));
		Thread.sleep(2000);

		//Click on Registration
		driver.findElement(By.xpath(p.getProperty("Register"))).click();
		Thread.sleep(2000);

		//Gender
		driver.findElement(By.id(p.getProperty("Gender"))).click();
		Thread.sleep(2000);

		//Enter First Name
		driver.findElement(By.id(p.getProperty("FirstName"))).sendKeys(p.getProperty("Fname"));
		Thread.sleep(2000);

		//Enter Last Name
		driver.findElement(By.id(p.getProperty("LastName"))).sendKeys(p.getProperty("Lname"));
		Thread.sleep(2000);

		//Day
		Select s1= new Select(driver.findElement(By.xpath(p.getProperty("Day"))));
		s1.selectByVisibleText(p.getProperty("DayValue"));
		Thread.sleep(2000);

		//Month
		Select s2= new Select(driver.findElement(By.xpath(p.getProperty("Month"))));
		s2.selectByVisibleText(p.getProperty("MonthValue"));
		Thread.sleep(2000);

		//Year
		Select s3= new Select(driver.findElement(By.xpath(p.getProperty("Year"))));
		s3.selectByVisibleText(p.getProperty("YearValue"));
		Thread.sleep(2000);

		//Enter Email
		driver.findElement(By.id(p.getProperty("Email"))).sendKeys(p.getProperty("mail"));
		Thread.sleep(2000);

		//Company Details
		driver.findElement(By.id(p.getProperty("Company"))).sendKeys(p.getProperty("CName"));
		Thread.sleep(2000);
		
		//Password
		driver.findElement(By.id(p.getProperty("Password"))).sendKeys(p.getProperty("Pvalue"));
		Thread.sleep(2000);
		
		//ReEnter Password
		driver.findElement(By.id(p.getProperty("ConfirmPassword"))).sendKeys(p.getProperty("CPvalue"));
		Thread.sleep(2000);
		
		driver.findElement(By.id(p.getProperty("RegisterButton"))).click();
		System.out.println("Your registration completed");
		Thread.sleep(2000);
		
		
	}
}
