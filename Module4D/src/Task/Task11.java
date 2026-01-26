package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task11 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // 1. Open Testify website directly
            driver.get("https://testifyltd.com");

            // Small pause for realism
            Thread.sleep(2000);

            // 2. Navigate directly to LinkedIn company page (NO GOOGLE)
            driver.get("https://ng.linkedin.com/company/testifyacademy");

            // 3. Wait for LinkedIn page body to load
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

            // 4. Close sign-in modal if it appears
            try {
                WebElement closeButton = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//button[contains(@aria-label,'Dismiss')]")
                        )
                );
                closeButton.click();
            } catch (Exception ignored) {
                // Modal did not appear – perfectly fine
            }

            // 5. Scroll page
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,600);");

            Thread.sleep(2000);

            // 6. Validate page title
            String title = driver.getTitle();
            System.out.println("Page title: " + title);

            if (!title.toLowerCase().contains("testify")) {
                throw new RuntimeException("LinkedIn page did not load correctly");
            }

            System.out.println("Task11 completed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
