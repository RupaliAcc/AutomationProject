package frameworks;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Hybrid 
{
	@Test
	public void hybridFrame() throws Exception 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\ASUS\\Desktop\\Automation Testing\\FinalProject.xlsx");

		XSSFWorkbook w = new XSSFWorkbook(file); 

		XSSFSheet s = w.getSheet("Hybrid");

		int size = s.getLastRowNum();

		System.out.println("No of Credentials: "+size);

		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Desktop\\Automation Testing\\Browser Extension\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);


		for(int i=1; i<=size; i++) //DataDriven
		{
			//Store credentials in variables
			String Email=s.getRow(i).getCell(1).getStringCellValue();
			String Password=s.getRow(i).getCell(2).getStringCellValue();
			System.out.println(Email+"\t\t"+Password);

			//To handle exception
			try
			{
	
				for(int j=1; j<=size; j++) //KeywordDriven
				{
					String key = s.getRow(j).getCell(0).getStringCellValue();

					if(key.equals("MaximizeBrowser"))
					{
						driver.manage().window().maximize();
						Thread.sleep(2000);
					}
					else if(key.equals("EnterURL"))
					{
						driver.get("https://demo.nopcommerce.com/");
						Thread.sleep(2000);
					}
					else if(key.equals("Login"))
					{
						driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
						Thread.sleep(2000);
					}
					else if(key.equals("EnterEmail"))
					{
						driver.findElement(By.id("Email")).sendKeys(Email);
						Thread.sleep(2000);
					}
					else if(key.equals("EnterPassword"))
					{
						driver.findElement(By.id("Password")).sendKeys(Password);
						Thread.sleep(2000);
					}
					else if(key.equals("ClickOnLoginButton"))
					{
						driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
						Thread.sleep(2000);
					}
					else if(key.equals("ClickOnLogoutButton"))
					{
						driver.findElement(By.className("ico-logout")).click();
						Thread.sleep(2000);
						System.out.println("Correct Email and password.");
						System.out.println("");
						s.getRow(i).createCell(3).setCellValue("Correct Email and password.");	
					}
				}
			}

			catch(Exception e)
			{
				//If Credential is incorrect it will handle by catch block and print invalid data on console as well as in excel sheet
				System.out.println("Incorrect Email and password.");
				System.out.println("");
				s.getRow(i).createCell(3).setCellValue("Incorrect Email and password.");	
				Thread.sleep(2000);
			}	
		}
		driver.close();
		//Write Data
		FileOutputStream out = new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Automation Testing\\Eclipse1\\Automation_FinalProject\\src\\test\\resources\\ExcelSheet\\FinalProject.xlsx");
		w.write(out);
	}
}
