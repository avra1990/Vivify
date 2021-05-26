import org.openqa.selenium.chrome.ChromeDriver;

public class MyVivfyAuto {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://gallery-app.vivifyideas.com/login");
		driver.manage().window().maximize();
		
		//Fill all datas
		FindElements allElements = new FindElements(driver);
		allElements.verifyAllExercises();
		
		//Negative login case
		negativeLogin cantLogin = new negativeLogin(driver);
		cantLogin.verifyAllExercises();
		
		//Negative create gallery case
		negativeCreateGallery negativeGallery = new negativeCreateGallery(driver);
		negativeGallery.verifyAllExercises();
		
		//Negative my gallery case
		negativeMyGalleries myGallery = new negativeMyGalleries(driver);
		myGallery.verifyAllExercises();
		
		//Logout case
		negativeLogoutCase logoutCase = new negativeLogoutCase(driver);
		logoutCase.verifyAllExercises();
		
	}

}
