package   com.college.shre.controller;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

// Add Spring Boot annotations
@SpringBootApplication
@RestController
public class InstahyreJobApplier {

    public static void main(String[] args) {
        SpringApplication.run(InstahyreJobApplier.class, args); // Start Spring Boot application
    }

    // New endpoint to trigger job application
    @PostMapping("/apply-jobs")
    public String applyForJobs(@RequestParam String email, @RequestParam String password) {
        // Initialize ChromeDriver and apply for jobs
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update with your path
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        try {
            loginToInstahyre(driver, email, password); // Use provided credentials
            applyForAllJobs(driver);
            return "Job applications submitted successfully.";
        } catch (Exception e) {
            return "Error applying for jobs: " + e.getMessage();
        } finally {
            driver.quit(); // Ensure the driver is closed
        }
    }

    private static void loginToInstahyre(WebDriver driver, String email, String password) {
        driver.get("https://www.instahyre.com/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Enter email
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(email);

        // Enter password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        // Click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
        loginButton.click();
    }

    private static void applyForAllJobs(WebDriver driver) {
        driver.get("https://www.instahyre.com/jobs");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Find all job listings
        List<WebElement> jobListings = driver.findElements(By.className("job-listing-class")); // Replace with actual class name

        for (WebElement job : jobListings) {
            try {
                job.click(); // Click on the job listing
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                // Click the apply button
                WebElement applyButton = driver.findElement(By.className("apply-button-class")); // Replace with actual class name
                applyButton.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                // Go back to the job listings
                driver.navigate().back();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } catch (Exception e) {
                System.out.println("Error applying for job: " + e.getMessage());
            }
        }
    }
}