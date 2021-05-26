import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class negativeLogoutCase {
		//Login elements
		By username = By.xpath("//input[@id='email']");
		By password = By.xpath("//input[@id='password']");
		By submitLogin = By.xpath("//button[@type='submit']");
		By bugCredentionals = By.xpath("//p[@class='alert alert-danger']");
		
		WebDriver driver;
		
		public negativeLogoutCase(WebDriver driver) {
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
		
		
		//Logout
		public void userLogOut() throws InterruptedException {
			WebElement userEmail = driver.findElement(username);
			WebElement passUser = driver.findElement(password);
			WebElement button = driver.findElement(submitLogin)	;
			button.click();
			
			if(userEmail.getText() == "") {
				System.out.println("Email data is cleared.");
			}
					
			if(passUser.getText() == "") {
				System.out.println("Password data is  cleared.");
			}
		}
		
		//Verify
		
		public void verifyAllExercises() throws InterruptedException {
			this.userLogOut();
		}
}
