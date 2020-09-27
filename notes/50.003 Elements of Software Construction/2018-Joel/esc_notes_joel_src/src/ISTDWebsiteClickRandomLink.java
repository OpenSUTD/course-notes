import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class ISTDWebsiteClickRandomLink {
		
	public static void main(String[] args) throws InterruptedException {		
		System.setProperty("webdriver.chrome.driver","/Users/Joel/Desktop/SUTD/Term 5/50.003 Elements of Software Construction/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://istd.sutd.edu.sg");
        Random rand = new Random();

		while (true) {
            // get all the links
			java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println(links.size());

			// click a random link
            int nextLink = rand.nextInt(links.size());
			System.out.println("*** Navigating to" + " " + links.get(nextLink).getAttribute("href"));
            if (links.get(nextLink).getAttribute("href") == null) continue;

            try {
                driver.navigate().to(links.get(nextLink).getAttribute("href"));
                Thread.sleep(3000);
                //driver.navigate().back();
                System.out.println("*** Navigated to" + " " + links.get(nextLink).getAttribute("href"));
                //staleElementLoaded = false;
            } catch (StaleElementReferenceException e) {
                //staleElementLoaded = true;
            }
        }
    }
}