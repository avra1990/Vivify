import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class negativeMyGalleries {
	//Login elements
	By username = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='password']");
	By submitLogin = By.xpath("//button[@type='submit']");
	By bugCredentionals = By.xpath("//p[@class='alert alert-danger']");
	
	//My gallery elements
	By myGallery = By.xpath("//a[@href='/my-galleries']");
	By searchMyGalleryInput = By.xpath("//input[@class='form-control']");
	By filterMyGalleryButton = By.xpath("//button[@class='btn btn-outline-secondary input-button']");
	By galleryBox = By.xpath("//div[@class='box-title']");
	By noGalleryDisplay = By.xpath("//div/h4");
	
	
	WebDriver driver;
	
	public negativeMyGalleries(WebDriver driver) {
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
	public void login() throws InterruptedException {
		
		WebElement userEmail = driver.findElement(username);
		userEmail.sendKeys("milosavramovic1990@gmail.com");
		Thread.sleep(2000);
		
		WebElement passUser = driver.findElement(password);
		passUser.sendKeys("Biciklica14061990");
		Thread.sleep(2000);
		
		WebElement submitLog = driver.findElement(submitLogin);
		submitLog.click();
		Thread.sleep(2000);
		
	}
	
	//My gallery page
	public void withoutMyGalleries() throws InterruptedException {
		WebElement userOwnGallery = driver.findElement(myGallery);
		userOwnGallery.click();
		Thread.sleep(2000);
				
		WebElement myGallInput = driver.findElement(searchMyGalleryInput);
		myGallInput.sendKeys("aaaaaaaaaaaaaaaaaaaaa");
		Thread.sleep(2000);
				
		WebElement myGallFilter = driver.findElement(filterMyGalleryButton);
		myGallFilter.click();
		Thread.sleep(2000);
				
		WebElement noGallery = driver.findElement(noGalleryDisplay);
		if(noGallery.isDisplayed()) {
			System.out.println("Gallery with name aaaaaaaaaaa not exist.");
		} 
	}
	
	//Verify
	
	public void verifyAllExercises() throws InterruptedException {
		this.login();
		this.withoutMyGalleries();;
	}	
}
