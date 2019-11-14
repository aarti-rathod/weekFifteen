package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Util;


public class SelectItem extends Util {


    @FindBy(xpath = "//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][contains(text(),'Hot deals')]")
    WebElement hotdeals;

    @FindBy(xpath = "//li[@class='leaf has-sub']//span[contains(text(),'Sale')]")
    WebElement sale;

    @FindBy(xpath = "//a[contains(text(),'Lace-Up Boots in Light Brown')]")
    WebElement shoes;

    @FindBy(xpath = "//h1[@class='fn title']")
    WebElement text;


    public void selectHotdeals() {
        clickOnElement(hotdeals);
        waitFor(4);
    }

    public void selectSaleOpt() {
        sale.click();
    }

    public void selectShoes() {
        doubleClick(shoes);
        waitFor(8);
    }

    public void selectText() {
        String actualText = getTextFromElement(text);
        String expectedText = "Lace-Up Boots in Light Brown";
        verifyExpectedAndActual(expectedText, actualText);
    }

}
