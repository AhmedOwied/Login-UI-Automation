import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTest extends BaseTest {

    @Test
    public void testValidLogin(){
        //add Username
        loginPage.addUserName("standard_user");

        //add password
        loginPage.addPassword("secret_sauce");

        //click login
        loginPage.clickOnLoginButton();

        // ToEnsure redirect to the correct page After Click on loginButton
        //assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testInvalidUserName(){
        loginPage.addUserName("ahmed");
        loginPage.addPassword("secret_sauce");
        loginPage.clickOnLoginButton();    ////h3[@data-test='error']

        //To Ensure error Validation message displayed successfully When Enter username invalid
        assertTrue(loginPage.isInvalidErrorMessageVisible());
    }

    @Test
    public void testInvalidPassword(){
        loginPage.addUserName("standard_user");
        loginPage.addPassword("ahmed123");
        loginPage.clickOnLoginButton();    ////h3[@data-test='error']

        //To Ensure error Validation message displayed successfully When Enter username invalid
        assertTrue(loginPage.isInvalidErrorMessageVisible());
    }

    @Test
    public void testEmptyUsername(){
        loginPage.addUserName("");
        loginPage.addPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        //To Ensure error Validation message displayed successfully When Username is empty
        assertTrue(loginPage.isRequiredErrorMessageVisible());

    }

    @Test
    public void testEmptyPassword(){
        loginPage.addUserName("standard_user");
        loginPage.addPassword("");
        loginPage.clickOnLoginButton();

        //To Ensure error Validation message displayed successfully When Password is empty
        assertTrue(loginPage.isRequiredErrorMessageVisible());
    }

    @Test
    public void testEmptyUsernameAndPassword(){
        loginPage.addUserName("");
        loginPage.addPassword("");
        loginPage.clickOnLoginButton();

        //To Ensure error Validation message displayed successfully When Password is empty
        assertTrue(loginPage.isRequiredErrorMessageVisible());
    }
}
