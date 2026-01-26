package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task8 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://idorenyinankoh.github.io/loginPage/");

        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        inputs.get(0).sendKeys("Qahharat");                  // First Name
        inputs.get(1).sendKeys("Ibrahim");                   // Last Name
        inputs.get(2).sendKeys("qahharat.ibrahim@test.com"); // Email

        inputs.get(4).click();                               // Female

        inputs.get(6).sendKeys("Test123");                   // Password
        inputs.get(7).sendKeys("Test123");                   // Confirm Password
        inputs.get(8).sendKeys("Testify task 8");            // About

        // 🔑 TRIGGER FORM VALIDATION (THIS IS THE KEY)
        driver.findElement(By.tagName("body")).click();

        WebElement button = driver.findElement(By.tagName("button"));
        System.out.println(button.isEnabled());
    }
}
