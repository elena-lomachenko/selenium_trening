package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementValue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class StickersOfDucks extends OptionsTests {

    @Test
    public void stickersOfDucks() {

        driver.navigate().to( "http://localhost/litecart/admin/" );

    }
}