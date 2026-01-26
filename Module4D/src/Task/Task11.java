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

            driver.get("https://testifyltd.com");

            Thread.sleep(2000);

            driver.get("https://ng.linkedin.com/company/testifyacademy");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

            try {
                WebElement closeButton = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//button[contains(@aria-label,'Dismiss')]")
                        )
                );
                closeButton.click();
            } catch (Exception ignored) {

            }

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,600);");

            Thread.sleep(2000);

            String title = driver.getTitle();
            System.out.println("Page title: " + title);

            if (!title.toLowerCase().contains("testify")) {
                throw new RuntimeException("LinkedIn page did not load correctly");
            }

            System.out.println("Task11 completed successfully");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
