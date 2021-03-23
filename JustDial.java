package assessment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JustDial {

	@Test
	public void runJustDial()  throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.navigate().to("https://www.justdial.com/");

		driver.findElementById("city").clear();
		driver.findElementById("city").sendKeys("chennai");
		driver.findElementByXPath("//a[@id='Chennai']").click();

		driver.findElementByXPath("//span[text()='Auto care']").click();

		driver.findElementByXPath("//span[@title='Car Repair']").click();

		Thread.sleep(2000);
		driver.findElementByXPath("(//span[text()='Hyundai'])[2]").click();

		Thread.sleep(5000);
		driver.findElementByXPath("(//span[@title='Hyundai Xcent'])[2]").click();

		Thread.sleep(3000);
		driver.findElementById("srchbx").click();

		WebElement loc = driver.findElementById("insrch");
		Thread.sleep(2000);
		loc.sendKeys("Porur", Keys.ENTER);

		// driver.findElementByXPath("//span[text()='All Options']").click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElementByXPath("//section[@id='best_deal_div']/section[1]/span[1]")));
		Thread.sleep(5000);

		driver.findElementByXPath("//section[@id='best_deal_div']/section[1]/span[1]").click();

		driver.findElementByXPath("//span[text()='Distance ']").click();

	}

}
