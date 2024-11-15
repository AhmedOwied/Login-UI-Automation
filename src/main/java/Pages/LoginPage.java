package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage{

    public WebDriver driver;
    public WebDriverWait wait;

    //web elements
    private By userNameField=By.xpath("//input[@name='user-name']");
    private By passwordField=By.cssSelector("input[name='password']");
    private By loginButton=By.xpath("//input[@name='login-button']");
    private By errorValidation=By.xpath("//h3[@data-test='error']");
    private By requiredValidationMessage=By.xpath("//h3[@data-test='error']");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver =driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    //Methods
    public void addUserName(String userName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void addPassword(String password){

        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnLoginButton(){

        driver.findElement(loginButton).click();
    }

    //Used in case of invalid Username or Pass
    public boolean isInvalidErrorMessageVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorValidation));
        boolean error =driver.findElement(errorValidation).isDisplayed();
        return error;
    }

    //Used in case of Empty Username or Pass
    public boolean isRequiredErrorMessageVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(requiredValidationMessage));
        return driver.findElement(requiredValidationMessage).isDisplayed();
    }


}
