import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class negativeLogin {
	//Login elements
	By username = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='password']");
	By submitLogin = By.xpath("//button[@type='submit']");
	By bugCredentionals = By.xpath("//p[@class='alert alert-danger']");

	
	WebDriver driver;
	
	public negativeLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	//Check if Login page is open
	public void currentPage(String verifyTitle) {
		String title = driver.getTitle().toString();
		
		if(title.contains(verifyTitle)) {
			System.out.println(driver.getCurrentUrl() + " is open");
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
        else {
            System.out.println("Page isn't open");
        }
	}
	
	
	//Login
	public void notLogin() throws InterruptedException {
		
		WebElement userEmail = driver.findElement(username);
		userEmail.sendKeys("milos1990@gmail.com");
		Thread.sleep(2000);
		
		WebElement passUser = driver.findElement(password);
		passUser.sendKeys("14061990");
		Thread.sleep(2000);
		
		WebElement submitLog = driver.findElement(submitLogin);
		submitLog.click();
		Thread.sleep(2000);
		
		WebElement bugMessage = driver.findElement(bugCredentionals);
		if(bugMessage.isDisplayed()) {
			System.out.println("User is not regitered,try again");
		};
		
	}
	
	

	//Verify
	
	public void verifyAllExercises() throws InterruptedException {
		this.notLogin();
	}
}
