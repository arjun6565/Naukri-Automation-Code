package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NaukriAutomate {

    // Method to perform the automation task
    public static void automateTask() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Arjun\\chromedriver-win64\\\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Open the Naukri login page
        driver.get("https://www.naukri.com/nlogin/login?utm_source=google&utm_medium=cpc&utm_campaign=Brand_Login_Register&gad_source=1&gclid=CjwKCAjwuJ2xBhA3EiwAMVjkVCAj0lDG1dVmJzMYzalBYr2EpJDzbyBt_E23fi2J8kgMOlMbBw6Y4hoCCwsQAvD_BwE&gclsrc=aw.ds");

        // Enter email address and password
        WebElement email = driver.findElement(By.id("usernameField"));
        email.sendKeys("abc@gmail.com");
        WebElement password = driver.findElement(By.id("passwordField"));
        password.sendKeys("Password");

        // Click the login button
        WebElement loginButton = driver.findElement(By.cssSelector(".blue-btn"));
        loginButton.click();

        // Wait for the login to complete
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click on the view profile link
        WebElement viewProfileLink = driver.findElement(By.xpath("//a[contains(@href, '/mnjuser/profile' )]"));
        viewProfileLink.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click on the edit profile button
        driver.findElement(By.xpath("//em[@class ='icon edit']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Scroll down to the end of the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        // Click on the save basic details button
        driver.findElement(By.id("saveBasicDetailsBtn")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Close the browser
        driver.quit();
    }

    // Method to schedule the task
    public static void scheduleTask() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Set the delay between each run in seconds (e.g., every 10 seconds)
        int delayBetweenRunsSeconds = 20;

        // Schedule the task to run at fixed intervals
        scheduler.scheduleAtFixedRate(() -> {
            // Execute the automated task
            automateTask();
        }, 0, delayBetweenRunsSeconds, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        // Call the scheduleTask method to start scheduling the task
        scheduleTask();
    }
}
