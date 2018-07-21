package Tests;
import Other.OptionsTests;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementValue;

public class StickersOfDucks extends OptionsTests {

    @Test
    public void stickersOfDucks() {
        driver.navigate().to( "http://localhost/litecart/" );
        List<WebElement> products = driver.findElements( By.cssSelector( "li.product" ) );

        for(WebElement product : products) {
            assert isDucksOneSticker(product) : "Product has more than one sticker or no stickers";
        }
    }

    private boolean isDucksOneSticker(WebElement product) {
        return product.findElements(By.cssSelector("div.sticker")).size() == 1;
    }
}






