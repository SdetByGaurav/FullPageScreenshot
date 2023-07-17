package DemoGmail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SentMail {

	@Test
	public void sendNewMail() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys("username");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("signIn")).click();
		
		driver.findElement(By.id("compose")).click();
		driver.findElement(By.id("toRecipient")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("subject")).sendKeys("demo mail");
		driver.findElement(By.id("bodymail")).sendKeys("Hello");
		driver.findElement(By.id("sendBtn")).click();
		
		driver.findElement(By.id("sentMail")).click();
		driver.findElement(By.xpath("//table/tbody/tr[*]/td[1]")).click();
		
		String subject = driver.findElement(By.id("subjectMsg")).getText();
		Assert.assertEquals(subject, "demo mail");
		
		String mailBody = driver.findElement(By.id("mailBody")).getText();
		Assert.assertEquals(mailBody, "Hello");
	}
}










