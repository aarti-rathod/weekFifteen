package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utility.Util;

public class SignUp extends Util {

    @FindBy(xpath = "//div[contains(@class,'header_bar-sign_in')]//span[contains(text(),'Sign in / sign up')]")
    WebElement sign_Up;

    @FindBy(xpath = "//input[@id='login']")
    WebElement _email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement _password;

    @FindBy(xpath = "//input[@id='password-conf']")
    WebElement _conPassword;

    @FindBy(xpath = "//a[@class='popup-button default-popup-button create-account-link']")
    WebElement createAnAct;

    @FindBy(xpath = "//div[contains(@class,'button submit')]//button[contains(@class,'submit')]")
    WebElement createBtn;


    public void clickOnSignUp() {
        clickOnElement(sign_Up);
    }

    public void clickOnCreateAnAccount() {
        clickOnElement(createAnAct);
    }

    public void enterEmail(String email) {
        waitFor(5);
        String emails = getRandomString(4)+"@gmail.com";
        sendTextToElement(_email, emails);
    }

    public void enterPassword(String pwd) {
        sendTextToElement(_password, pwd);
    }

    public void enterConfirmPassword(String pwd) {
        sendTextToElement(_conPassword, pwd);
    }

    public void clickOnCreateBtn() {
        clickOnElement(createBtn);
        waitFor(4);
    }
    public void verifyTitle(){
        String expectedTitle = "X-Cart Demo store company > My account";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}