package test;

import loadproperty.LoadProperty;
import org.testng.annotations.Test;
import pages.SelectItem;
import pages.SignUp;

public class TestSuite extends TestBase {

    LoadProperty loadProperty = new LoadProperty();
    SelectItem selectItem;
    SignUp signUp;


    @Test
    public void UserShouldAbleToSignUpSuccessfully() {

        test = extentReports.createTest("signUp");
        signUp = new SignUp();
        signUp.clickOnSignUp();
        signUp.clickOnCreateAnAccount();
        signUp.enterEmail(loadProperty.getProperty("email"));
        signUp.enterPassword(loadProperty.getProperty("password"));
        signUp.enterConfirmPassword(loadProperty.getProperty("password"));
        signUp.clickOnCreateBtn();
        signUp.verifyTitle();

    }


    @Test
    public void UserShouldAbleToSelectItemSuccessfully() {
        test = extentReports.createTest("Verify Text");
        selectItem = new SelectItem();
        selectItem.selectHotdeals();
        selectItem.selectSaleOpt();
        selectItem.selectShoes();
        selectItem.selectText();
    }
}
