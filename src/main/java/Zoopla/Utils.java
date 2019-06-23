package Zoopla;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {
    // clicking elements
    public static void clickElements(By by) {
        driver.findElement(by).click();

    }

    // entering elements
    public static void enterElements(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //clear Text from inout box/area
    public static void clearElements(By by)
    {
        driver.findElement(by).clear();
    }

    //clear and enter text in input field
    public static void clear_enter_text(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    //get selected data from dropdown
    public static void selectDropdownValue(By by, String data) {
        Select dob = new Select(driver.findElement(by));
        dob.selectByValue(data);
    }

    //get selected text from dropdown
    public static void selectDropdownText(By by, String text) {
        Select dob = new Select(driver.findElement(by));
        dob.selectByVisibleText(text);
    }

    //get selected index from dropdown
    public static void selectDropdownIndex(By by, int index) {
        Select dob = new Select(driver.findElement(by));
        dob.selectByIndex(index);
    }

    //  wait for visibility of element with given time
    public void waitForElementDisplay(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Wait for locator to be clickable for given time in seconds
    public static void waitForLocatorTobeClickable(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    // create Timestamp method with current day-month-year-minute-second
    public static String currentdatetime() {
        //create date format object
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyHHss");
        return dateFormat.format(new Date());
    }

    //create Timestamp method with current day-month-hour-minute-
    public static String currentdaymonth() {
        //create date format object
        DateFormat dateFormat = new SimpleDateFormat("ddMMHHmm");
        return dateFormat.format(new Date());
    }

    // actual result - getting text from web
    public static void assertTextMessage(String expected, By by) {
        String actual = getTextFromElement(by);
        Assert.assertEquals(expected, actual);
    }
    // method for getting text from web(so getting text from assertTextMessage method)
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // if url contain specific word
    public static void assertURLtext(String text) {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    // assert with current url
    public static void assertCurrentURL(String text) {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, text);
    }

    // only hover to element mouse hover method
    public void hoverElement(By by) {
        WebElement ele = driver.findElement(by); //xpath store in ele or you can use direct
        Actions act = new Actions(driver);
        act.moveToElement(ele).build().perform();// single element .perform if multiple we use build.perform//
    }
    public static  void takeScreenShot(WebDriver driver, String screenshotName)
    {
        try
        {
            //create screenshot
            TakesScreenshot ts=(TakesScreenshot)driver;
            //call method to capture scrrenshot
            File source=ts.getScreenshotAs(OutputType.FILE);

            // Copy files to specific location here it will save all screenshot in our project home directory and
            // result.getName() will return name of test case so that screenshot name will be same
            FileUtils.copyFile(source,new File("src\\CaptureScreenshots"+screenshotName+".png"));
            System.out.println("screenshot taken");

        }
        catch (IOException e)
        {
            System.out.println("Exception while taking screenshot"+e.getMessage());

        }
    }

}
