package steps;

import common.CommonAPI;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageobjects.LoginPage;

public class LoginSteps extends CommonAPI {

    LoginPage loginPage = new LoginPage(driver);

    @Given("user navigates to the login page")
    public void userNavigatesToTheLoginPage() throws Exception {
        this.loginPage.navigateToLoginPage();
        Thread.sleep(1500);
    }

    @And("user enters an invalid email and an invalid password")
    public void userEntersAnInvalidEmailAndAnInvalidPassword() throws Exception {
        this.loginPage.enterInEmail("faketest123");
        Thread.sleep(1000);
        this.loginPage.enterInPassword("fakepass123");
        Thread.sleep(1000);
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() throws Exception {
        this.loginPage.login();
        Thread.sleep(1000);
    }

    @Then("user should see an error message")
    public void userShouldSeeAnErrorMessage() throws Exception {
        Assert.assertEquals(true, this.loginPage.alertMessageIsDisplayed());
        Thread.sleep(1000);
    }
}
