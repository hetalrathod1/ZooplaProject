package Zoopla;

import org.openqa.selenium.By;

public class LondonProperty extends Utils {

    private By _sortLowPrice=By.xpath("//select[@name='results_sort']");
    public void verifyUserIsOnLondonProperty()
    {
        assertTextMessage("Property for sale in London", By.xpath("//h1[contains(text(),'Property for sale in London')]"));
    }

    public void userSortLowPrice()
    {
        selectDropdownValue(_sortLowPrice,"lowest_price");

    }
}
