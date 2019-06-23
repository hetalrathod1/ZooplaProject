
import Zoopla.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class MyStepdefs {
    HomePage homePage=new HomePage();
    @Given("^user is on homepage$")
    public void userIsOnHomepage() {
        homePage.userIsOnHomePage();
    }

    @And("^user enter location$")
    public void userEnterLocation() {
        homePage.enterToSearchBox();
    }

    @And("^user click on search button$")
    public void userClickOnSearchButton() {

    }

    @Then("^user is able to see property list$")
    public void userIsAbleToSeePropertyList() {
    }
}
