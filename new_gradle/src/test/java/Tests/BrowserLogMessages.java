package Tests;

import Other.OptionsTests;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class BrowserLogMessages extends OptionsTests {

    @Test
    public void testBrowserLogMessages() {
        // Логинимся под админом
        driver.navigate().to( "http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1" );
        driver.findElement( By.name( "username" ) ).sendKeys( "admin" );
        driver.findElement( By.name( "password" ) ).sendKeys( "admin" );
        driver.findElement( By.name( "login" ) ).click();
        wait.until( ExpectedConditions.visibilityOf( driver.findElement( By.xpath( "//div[@id='notices']" ) ) ) );

        // Сохраняем список продуктов
        List<WebElement> products = driver.findElements( By.cssSelector( "a[href*='product_id']" ) );
        List<String> productNames = new ArrayList<String>();
        for (int i = 0; i < products.size(); i += 2) {
            productNames.add( products.get( i ).getText() );
        }

        // Открываем страницы продуктов и возвращаемся на предыдущую страницу
        for (String productName : productNames) {
            driver.findElement( By.linkText( productName ) ).click();
            driver.navigate().back();
        }

        // Проверяем логи

        driver.manage().logs().get("browser").forEach(l -> {
            System.out.println(l);
            Assert.assertFalse(l.equals(""));});
    }

}


