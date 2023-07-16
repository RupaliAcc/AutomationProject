package basicProgram;

import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login_Logout {
	@Test
	public void Login() throws Exception 
	{
		Properties p= new Properties();
		FileInputStream file= new FileInputStream("C:\\Users\\ASUS\\Desktop\\Automation Testing\\Eclipse1\\Automation_FinalProject\\src\\test\\resources\\PropertyFile\\LoginLogout.properties");
		p.load(file);

		System.setProperty(p.getProperty("BrowserName"),p.getProperty("BrowserPath"));
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();

		//Open URL
		driver.get(p.getProperty("URL"));
		Thread.sleep(2000);

		//Click on Login 
		driver.findElement(By.xpath(p.getProperty("Login"))).click();
		Thread.sleep(2000);

		//Enter Email
		String Send_Email=JOptionPane.showInputDialog("Enter Email");
		driver.findElement(By.id(p.getProperty("Email"))).sendKeys(Send_Email);
		Thread.sleep(2000);
		
		//Enter Password
		String Send_Pass=JOptionPane.showInputDialog("Enter Password");
		driver.findElement(By.id(p.getProperty("Password"))).sendKeys(Send_Pass);
		Thread.sleep(2000);
		
		//Click on Login Button 
		driver.findElement(By.xpath(p.getProperty("LoginButton"))).click();
		Thread.sleep(2000);
		System.out.println("Login Sucessfully ");
		
		//Click on Logout Button
		driver.findElement(By.xpath(p.getProperty("LogoutButton"))).click();
		Thread.sleep(2000);
		System.out.println("Logout Sucessfully ");
	}
}
