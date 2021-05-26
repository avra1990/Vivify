import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElements {
	
	//Login elements
	By username = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='password']");
	By submitLogin = By.xpath("//button[@type='submit']");
	
	//Create gallery elements
	By createGallery = By.xpath("//a[@href='/create']");
	By createGalleryTitle = By.xpath("//input[@id='title']");
	By createGalleryDescription = By.xpath("//input[@id='description']");
	By createGalleryImage = By.xpath("//input[@placeholder='image url']");
	By createGalleryAddimage = By.xpath("//button[@type='button']");
	By createGallerySubmit = By.xpath("//button[@type='submit']");
	
	//My gallery elements
	By myGallery = By.xpath("//a[@href='/my-galleries']");
	By searchMyGalleryInput = By.xpath("//input[@class='form-control']");
	By filterMyGalleryButton = By.xpath("//button[@class='btn btn-outline-secondary input-button']");
	By galleryBox = By.xpath("//div[@class='box-title']");
	
	//Logout
	By logout = By.xpath("//a[@role='button ']");
	
	
	
	
	WebDriver driver;
	
	public FindElements(WebDriver driver) {
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
	
	//Create gallery
	public void createGallery() throws InterruptedException {
		
		WebElement newGallery = driver.findElement(createGallery);
		newGallery.click();
		Thread.sleep(2000);
		
		WebElement gallTitle = driver.findElement(createGalleryTitle);
		gallTitle.sendKeys("my_gallery_2");
		Thread.sleep(2000);
			
		WebElement gallDesc = driver.findElement(createGalleryDescription);
		gallDesc.sendKeys("test gallery");
		Thread.sleep(2000);
		
		WebElement gallImage = driver.findElement(createGalleryImage);
		gallImage.sendKeys("https://image.shutterstock.com/image-photo/three-girls-straw-hats-on-600w-1728731677.jpg");
		Thread.sleep(2000);
		
		WebElement addImageGallery = driver.findElement(createGalleryAddimage);
		addImageGallery.click();
		Thread.sleep(2000);
		
		WebElement gallSubmit = driver.findElement(createGallerySubmit);
		gallSubmit.click();
		Thread.sleep(2000);
	}
	
	//My gallery page
	public void myGalleries() throws InterruptedException {
		WebElement userOwnGallery = driver.findElement(myGallery);
		userOwnGallery.click();
		Thread.sleep(2000);
		
		WebElement myGallInput = driver.findElement(searchMyGalleryInput);
		myGallInput.sendKeys("my_gallery_2");
		Thread.sleep(2000);
		
		WebElement myGallFilter = driver.findElement(filterMyGalleryButton);
		myGallFilter.click();
		Thread.sleep(2000);
		/*
		WebElement myDivGallery = driver.findElement(galleryBox);
		if(myDivGallery.isDisplayed() && myDivGallery.getText().contains("my_galllery_2")) {
			System.out.println("Gallery with name my_gallery_2 exist.");
		} else {
			System.out.println("Gallery with name my_gallery_2 doesn't exist.");
		}
		*/
	}
	
	//Logout
	public void logOut() throws InterruptedException {
		WebElement logOutUser = driver.findElement(logout);
		logOutUser.click();
		Thread.sleep(2000);
	}
	
	//Verify
	
	public void verifyAllExercises() throws InterruptedException {
		this.login();
		this.createGallery();
		this.myGalleries();
		this.logOut();
	}
			
}
