package org.prog.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumDemo {

    /*
     * 1. Open browser
     * 2. Load allo.ua
     * 3. Press profile btn
     * 4. Select login/password
     * 5. Set incorrect login/password
     * 6. Press login
     * 7. Print error messages
     */

    public static void main(String[] args) {
        //start browse
        WebDriver driver = new ChromeDriver();
        try {
            //full screen
            driver.manage().window().maximize();
            //load allo ua
            driver.get("https://allo.ua/");
            // Press profile button
            WebElement profileBtn = driver.findElement(By.className("mh-profile"));
            profileBtn.click();
            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(3L));
            WebElement pwdBtnWait = driverWait.until(
                    ExpectedConditions.presenceOfElementLocated(By.className("auth__enter-password")));
            pwdBtnWait.click();
            //Press login
            WebElement loginBtn = driverWait.until(
                    ExpectedConditions.presenceOfElementLocated(By.className("a-button--primary")));
            loginBtn.click();
            //Print error messages
            System.out.println("wrong password!");
        } finally {
            driver.quit();
        }
    }
}

