package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementValue;

public class LitecartAut extends OptionsTests {

    @Test
    public void myFirstTest() {
        driver.navigate().to( "http://localhost/litecart" );
        driver.findElement( By.xpath( "//div[@id='box-account-login']//input[@type='text']" ) ).sendKeys( "elena.lomachenko@bk.ru" );
        driver.findElement( By.xpath( "//div[@id='box-account-login']//input[@type='password']" ) ).sendKeys( "Jctym2014" );
        driver.findElement( By.name( "login" ) ).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath( "//div[@id='notices']" ) )));

    }
}
