package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementValue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Countries extends OptionsTests {

    @Test
    public void countries() {
        //*************************
        //Заходим на сайт и авторизуемся
        //*************************

        driver.navigate().to( "http://localhost/litecart/admin/?app=countries&doc=countries" );
        driver.findElement( By.name( "username" ) ).sendKeys( "admin" );
        driver.findElement( By.name( "password" ) ).sendKeys( "admin" );
        driver.findElement( By.name( "login" ) ).click();
        wait.until( ExpectedConditions.visibilityOf( driver.findElement( By.xpath( "//div[@id='notices']" ) ) ) );

        //*************************
        //Заходим в раздел стран и составляем списки
        //*************************

        List<WebElement> countries = driver.findElements( By.cssSelector( "table.dataTable tr.row" ) );
        List<String> countriesName = new LinkedList<>();
        List<String> zonesName = new LinkedList<>();
        PrintStream out = System.out;

        for (WebElement country : countries) {

            String countryName = (country.findElement( By.cssSelector( "td:nth-child(5) a" ) ).getText());
            int countryZonesAmount = Integer.parseInt( country.findElement( By.cssSelector( "td:nth-child(6)" ) ).getText() );

            countriesName.add( countryName );

            if (countryZonesAmount > 0) {
                zonesName.add( countryName );
            }
        }

        out.println( "Несоответствие алфавиту" );

        for (String countryWithZonesName : zonesName) {

            WebElement countryWithZonesLink = driver.findElement( By.xpath( ".//a[text() = '" + countryWithZonesName + "']" ) );

            countryWithZonesLink.click();

            List<WebElement> zones = driver.findElements( By.cssSelector( ".dataTable td:nth-child(3) input" ) );
            List<String> allzonesName = new ArrayList<>();

            for (WebElement zone : zones) {
                allzonesName.add( zone.getText() );
            }
            out.println( "Несоответствие алфавиту" );

            zones = null;

            driver.navigate().back();
        }
    }


}
