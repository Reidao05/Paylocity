package utils;

import com.paylocity.pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Utility {
    public static WebDriver driver;
    public static void setUtilityDriver(){
        driver = BasePage.driver;
    }
    // Generate random numbers
    // Generate a random integer between a given range
    public static int generateRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Max must be greater than or equal to min");
        }
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    //Return String to UpperCase
    public static String convertToUpperCase(String input) {
        return input.toUpperCase();
    }
}
