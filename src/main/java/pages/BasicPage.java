package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WindowType;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;

    public abstract class BasicPage {
        protected WebDriver driver;
        protected WebDriverWait wait;

    public BasicPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public boolean elementExists(By by){
        return !driver.findElements(by).isEmpty();
    }
    public boolean elementExists(By by, int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        boolean elementExists = !driver.findElements(by).isEmpty();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return elementExists;
    }
}