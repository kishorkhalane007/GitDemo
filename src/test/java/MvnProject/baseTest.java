
package MvnProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class baseTest 
{

	public static WebDriver driver;
	public Properties prop;
	
    @Test
	public void initializeDriver() throws IOException 
	{

		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Kishor\\ProjectJava\\src\\test\\java\\MvnProject\\data.properties");
		//C:\Users\Kishor\ProjectJava\src\test\java\MvnProject

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kishor\\Downloads\\Ecclipse\\chromedriver.exe");
			driver = new ChromeDriver();
			// execute in chrome driver
			
			//driver.get("http://facebook.com"); //URL in the browser
			driver.get(prop.getProperty("url"));
			//driver.findElement(By.className("inputtext")).sendKeys("helloworld");
			/*driver.findElement(By.id("email")).sendKeys("Thisis my first code");
			driver.findElement(By.name("pass")).sendKeys("123456");
			driver.findElement(By.linkText("Forgot account?")).click();*/

			driver.findElement(By.cssSelector("#email")).sendKeys("emailaddress");
			driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
			driver.findElement(By.xpath("//*[@id='login_form']/table/tbody/tr[3]/td[2]/div/a")).click();

		} else if (browserName.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kishor\\Downloads\\Ecclipse\\geckodriver.exe");

			driver = new FirefoxDriver();
			// firefox code
			driver.get("http://google.com");
			driver.get(prop.getProperty("url"));
			//driver.findElement(By.className("inputtext")).sendKeys("helloworld");
			/*driver.findElement(By.id("email")).sendKeys("Thisis my first code");
			driver.findElement(By.name("pass")).sendKeys("123456");
			driver.findElement(By.linkText("Forgot account?")).click();*/

			driver.findElement(By.cssSelector("#email")).sendKeys("emailaddress");
			driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
			driver.findElement(By.xpath("//*[@id='login_form']/table/tbody/tr[3]/td[2]/div/a")).click();
		} else if (browserName.equals("IE")) 
		{
         //	IE code
		}

    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.close();

	}
}
