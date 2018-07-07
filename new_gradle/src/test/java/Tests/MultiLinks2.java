package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MultiLinks2 extends OptionsTests {

    @Test
    public void multiLinks() {

        driver.navigate().to( "http://localhost/litecart/admin/" );
        driver.findElement( By.name( "username" ) ).sendKeys( "admin" );
        driver.findElement( By.name( "password" ) ).sendKeys( "admin" );
        driver.findElement( By.name( "login" ) ).click();
        wait.until( ExpectedConditions.visibilityOf( driver.findElement( By.xpath( "//div[@id='notices']" ) ) ) );


        List<WebElement> menu = driver.findElements( By.cssSelector( "#box-apps-menu > li[id='app-'] > a" ) );
        int top_level_links_amount = menu.size();

        for (int i = 0; i < top_level_links_amount; i++) {
            menu = driver.findElements( By.cssSelector( "#box-apps-menu > li[id='app-'] > a" ) );
            menu.get( i ).click();

            try {
                List<WebElement> sub_menu = driver.findElements( By.className( "docs" ) );
                List<WebElement> puncts = sub_menu.get( 0 ).findElements( By.cssSelector( "li > a" ) );
                int sub_menu_size = puncts.size();

                for (int j = 0; j < sub_menu_size; j++) {
                    sub_menu = driver.findElements( By.className( "docs" ) );
                    puncts = sub_menu.get( 0 ).findElements( By.cssSelector( "li > a" ) );
                    puncts.get( j ).click();
                    WebElement content = driver.findElement( By.id( "content" ) );
                    WebElement content_h1 = content.findElement( By.tagName( "h1" ) );
                    assert content_h1.isDisplayed();
                }

            } catch (IndexOutOfBoundsException ex) {
                WebElement content = driver.findElement( By.id( "content" ) );
                WebElement content_h1 = content.findElement( By.tagName( "h1" ) );
                assert content_h1.isDisplayed();


            }
        }
    }
}