package Zoopla;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Utils{

    private By _searchbox=By.xpath("//input[@id='search-input-location'] ");
    private By _clickOnSearch=By.xpath("//button[@id='search-submit']");
    public void userIsOnHomePage()
    {
        assertCurrentURL("https://www.zoopla.co.uk/");
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(_searchbox));
    }
    public void enterToSearchBox()
    {
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(_searchbox));

        enterElements(_searchbox,"london");
    }
    public void userClickOnSearchButton()
    {
        clickElements(_clickOnSearch);
    }


}
