package DemoFullScreenshot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeFullScreenshot {
	
	@Test
	public void checkFullScreenshot() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		try {
			driver.findElement(By.xpath("//button[text()= '✕']")).click();
		}catch(NoSuchElementException e) {
			
		}
		
		driver.findElement(By.name("q")).sendKeys("Iphone x", Keys.ENTER);
		
		String msg = driver.findElement(By.xpath("//span[starts-with(text(),'Showing')]")).getText();
		System.out.println(msg);
		
		// capturing full page screenshot
		Shutterbug.shootPage(driver, Capture.FULL, true).withName("IphoneResult").save("./FullPageScreenshot/");
		
		System.out.println("pass");
		driver.quit();
	}
}














