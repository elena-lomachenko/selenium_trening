package Tests;

import Other.OptionsTests;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class SortingCountriesAndGeozones extends OptionsTests {


    int numbersCountries, numbersZones, numbersGeozones;
    int[] zones;
    WebElement countriesRow, zonesRow, geozonesRow;
    List<WebElement> countriesRows, zonesRows, geozonesRows;
    String[] countryName, zoneName;
    int a, az;

    public static int testAlphabet(String[] testArr, int arrSize) {
        int isAlphab = 1;
        for (int i = 1; i < arrSize; i++) {
            int k;
            k = testArr[i - 1].compareToIgnoreCase( testArr[i] );
            if (k >= 0) isAlphab = -1;
        }
        return isAlphab;
    }

    @Test
    public void CheckCountries() {
        driver.navigate().to( "http://localhost/litecart/admin/?app=countries&doc=countries" );
        driver.findElement( By.name( "username" ) ).sendKeys( "admin" );
        driver.findElement( By.name( "password" ) ).sendKeys( "admin" );
        driver.findElement( By.name( "login" ) ).click();
        wait.until( ExpectedConditions.visibilityOf( driver.findElement( By.xpath( "//div[@id='notices']" ) ) ) );

        countriesRows = driver.findElements( By.cssSelector( "[name=countries_form] .row" ) );

        numbersCountries = countriesRows.size();
        countryName = new String[numbersCountries];
        zones = new int[numbersCountries];

        for (int i = 0; i < numbersCountries; i++) {
            countriesRow = countriesRows.get( i );
            countryName[i] = countriesRow.findElement( By.cssSelector( "a" ) ).getText();
            zones[i] = Integer.parseInt( countriesRow.findElement( By.cssSelector( "td:nth-child(6)" ) ).getText() );
        }

        a = testAlphabet( countryName, numbersCountries );

        Assert.assertTrue( a == 1 );

        for (int i = 0; i < numbersCountries; i++) {
            if (zones[i] > 0) {
                countriesRows = driver.findElements( By.cssSelector( "[name=countries_form] .row" ) );
                countriesRow = countriesRows.get( i );
                countriesRow.findElement( By.cssSelector( "a" ) ).click();

                zonesRows = driver.findElements( By.cssSelector( "[id=table-zones] tr" ) );
                numbersZones = zonesRows.size() - 2;
                zoneName = new String[numbersZones];

                for (int j = 1; j <= numbersZones; j++) {
                    zonesRow = zonesRows.get( j );
                    zoneName[j - 1] = zonesRow.findElement( By.cssSelector( "td:nth-child(3)" ) ).getText();
                }
                az = testAlphabet( zoneName, numbersZones );
                Assert.assertTrue( az == 1 );

                driver.get( "http://localhost/litecart/admin/?app=countries&doc=countries" );
            }
        }

        driver.get( "http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones" );

        geozonesRows = driver.findElements( By.cssSelector( "[name=geo_zones_form] .row" ) );
        numbersGeozones = geozonesRows.size();

        for (int i = 0; i < numbersGeozones; i++) {
            geozonesRows = driver.findElements( By.cssSelector( "[name=geo_zones_form] .row" ) );
            geozonesRow = geozonesRows.get( i );
            geozonesRow.findElement( By.cssSelector( "a" ) ).click();

            zonesRows = driver.findElements( By.cssSelector( "[id=table-zones] tr" ) );
            numbersZones = zonesRows.size() - 2;
            zoneName = new String[numbersZones];

            for (int j = 1; j <= numbersZones; j++) {
                zonesRow = zonesRows.get( j );
                zoneName[j - 1] = zonesRow.findElement(
                        By.cssSelector( "[id=table-zones] tr td:nth-child(3) [selected=selected]" ) ).
                        getAttribute( "textContent" );
            }
            az = testAlphabet( zoneName, numbersZones );
            Assert.assertTrue( az == 1 );
            driver.get( "http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones" );
        }
    }

}

