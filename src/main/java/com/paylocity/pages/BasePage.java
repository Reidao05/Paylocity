package com.paylocity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    protected WebElement find(By locator){
        try{
            return driver.findElement(locator);
        }catch (Exception e){
            throw new RuntimeException("Element not found: " + locator);
        }
    }

    protected  void set(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }
    protected void click(By locator){
        find(locator).click();
    }
    public static void delay(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch(InterruptedException exc){
            exc.printStackTrace();
        }
    }
    public void waitForVisibility(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
