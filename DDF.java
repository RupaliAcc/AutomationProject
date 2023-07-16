package frameworks;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DDF {
	@Test
	public void dataDriven() throws Exception 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\ASUS\\Desktop\\Automation Testing\\Eclipse1\\Automation_FinalProject\\src\\test\\resources\\ExcelSheet\\FinalProject.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(file); 

		XSSFSheet s = w.getSheet("DataDriven");

		int size = s.getLastRowNum();

		System.out.println("No of Credentials: "+size);

		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Desktop\\Automation Testing\\Browser Extension\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);

		driver.manage().window().maximize();
		Thread.sleep(2000);

		//Open URL
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(2000);

		
		for(int i=1; i<=size; i++)
		{
			//Store credentials in variables
			String Email=s.getRow(i).getCell(0).getStringCellValue();
			String Password=s.getRow(i).getCell(1).getStringCellValue();
			System.out.println(Email+"\t\t"+Password);

			//To handle exception
			try
			{
				//Click on Login 
				driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
				Thread.sleep(2000);
				
				//Enter Email
				driver.findElement(By.id("Email")).sendKeys(Email);
				Thread.sleep(2000);

				//Enter Password
				driver.findElement(By.id("Password")).sendKeys(Password);
				Thread.sleep(2000);

				//Click on Login Button 
				driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
				Thread.sleep(2000);
				
				//Click on logout button
				driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
				Thread.sleep(2000);
				
				//If credential is correct it will print valid data on console as well as in excel sheet
				System.out.println("Correct Email and password.");
				System.out.println("");
				s.getRow(i).createCell(2).setCellValue("Correct Email and password.");				
				Thread.sleep(2000);
			}

			catch(Exception e)
			{
				//If Credential is incorrect it will handle by catch block and print invalid data on console as well as in excel sheet
				System.out.println("Incorrect Email and password.");
				System.out.println("");
				s.getRow(i).createCell(2).setCellValue("Incorrect Email and password.");	
				Thread.sleep(2000);
			}	
		}
		//Write Data
		FileOutputStream out = new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Automation Testing\\Eclipse1\\Automation_FinalProject\\src\\test\\resources\\ExcelSheet\\FinalProject.xlsx");
		w.write(out);
	}
}
