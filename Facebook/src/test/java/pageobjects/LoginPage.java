package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.FBRunner;

public class LoginPage extends FBRunner {

    private String loginPageUrl = "https://www.facebook.com/login/";

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "loginbutton")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(), 'doesn’t match any account')]")
    private WebElement alertMessage;

    public void navigateToLoginPage() {
        driver.navigate().to(this.loginPageUrl);
    }

    public void enterInEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void enterInPassword(String pass) {
        driver.findElement(By.id("pass")).sendKeys(pass);
    }

    public void login() {
        driver.findElement(By.id("loginbutton")).click();
    }

    public boolean alertMessageIsDisplayed() {
        return driver.findElement(By.xpath("//div[contains(text(), 'doesn’t match any account')]")).isDisplayed();
    }

}
