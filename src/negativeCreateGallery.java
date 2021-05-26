import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class negativeCreateGallery {
			//Login elements
			By username = By.xpath("//input[@id='email']");
			By password = By.xpath("//input[@id='password']");
			By submitLogin = By.xpath("//button[@type='submit']");
			By bugCredentionals = By.xpath("//p[@class='alert alert-danger']");
			
			//Create gallery elements
			By createGallery = By.xpath("//a[@href='/create']");
			By createGalleryTitle = By.xpath("//input[@id='title']");
			By createGalleryDescription = By.xpath("//input[@id='description']");
			By createGalleryImage = By.xpath("//input[@placeholder='image url']");
			By createGalleryAddimage = By.xpath("//button[@type='button']");
			By createGallerySubmit = By.xpath("//button[@type='submit']");
			By wrongFormat = By.xpath("//p[@class = 'alert alert-danger']");
			
			
			WebDriver driver;
			
			public negativeCreateGallery(WebDriver driver) {
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
			
			// Can't create gallery
			public void cantCreateGallery() throws InterruptedException {
				
				WebElement newGallery = driver.findElement(createGallery);
				newGallery.click();
				Thread.sleep(2000);
				
				WebElement gallTitle = driver.findElement(createGalleryTitle);
				gallTitle.sendKeys("my_gallery_bug");
				Thread.sleep(2000);
					
				WebElement gallDesc = driver.findElement(createGalleryDescription);
				gallDesc.sendKeys("test gallery");
				Thread.sleep(2000);
				
				WebElement gallImage = driver.findElement(createGalleryImage);
				gallImage.sendKeys("https://raw-hats");
				Thread.sleep(2000);
				
				WebElement addImageGallery = driver.findElement(createGalleryAddimage);
				addImageGallery.click();
				Thread.sleep(2000);
				
				WebElement gallSubmit = driver.findElement(createGallerySubmit);
				gallSubmit.click();
				Thread.sleep(2000);
				
				WebElement bugParagraph = driver.findElement(wrongFormat);
				
				if(bugParagraph.isDisplayed()) {
					System.out.print("Gallery can not be created.");
				}
			}
			
			//Verify
			
			public void verifyAllExercises() throws InterruptedException {
				this.login();
				this.cantCreateGallery();
			}		
}
