package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementValue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MultiLinks extends OptionsTests {

    @Test
    public void multiLinks() {
        //*************************
        //Заходим на сайт и авторизуемся
        //*************************

        driver.navigate().to( "http://localhost/litecart/admin/" );
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath( "//div[@id='notices']" ) )));

        //*************************
        //Кликаем на элемент Appearence и подпункты
        //*************************

        driver.findElement(By.linkText("Appearence")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Template']")))));

       driver.findElement(By.linkText("Logotype")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Logotype']")))));

        //*************************
        //Кликаем на элемент Catalog и подпункты
        //*************************

        driver.findElement(By.linkText("Catalog")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Catalog']")))));

        driver.findElement(By.linkText("Product Groups")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Product Groups']")))));

        driver.findElement(By.linkText("Option Groups")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Option Groups']")))));

        driver.findElement(By.linkText("Manufacturers")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Manufacturers']")))));

        driver.findElement(By.linkText("Suppliers")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Suppliers']")))));

        driver.findElement(By.linkText("Delivery Statuses")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Delivery Statuses']")))));

        driver.findElement(By.linkText("Sold Out Statuses")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Sold Out Statuses']")))));

        driver.findElement(By.linkText("Quantity Units")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Quantity Units']")))));

        driver.findElement(By.linkText("CSV Import/Export")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' CSV Import/Export']")))));

        //*************************
        //Кликаем на элемент Countries
        //*************************

        driver.findElement(By.linkText("Countries")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Countries']")))));

        //*************************
        //Кликаем на элемент Currencies
        //*************************

        driver.findElement(By.linkText("Currencies")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Currencies']")))));

        //*************************
        //Кликаем на элемент Customers и подпункты
        //*************************

        driver.findElement(By.linkText("Customers")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Customers']")))));

        driver.findElement(By.linkText("CSV Import/Export")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' CSV Import/Export']")))));

        driver.findElement(By.linkText("Newsletter")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Newsletter']")))));

        //*************************
        //Кликаем на элемент Geo Zones
        //*************************

        driver.findElement(By.linkText("Geo Zones")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Geo Zones']")))));

        //*************************
        //Кликаем на элемент Languages и подпункты
        //*************************

        driver.findElement(By.linkText("Languages")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Languages']")))));

        driver.findElement(By.linkText("Storage Encoding")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Storage Encoding']")))));

        //*************************
        //Кликаем на элемент Modules и подпункты
        //*************************

        driver.findElement(By.linkText("Modules")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Job Modules']")))));

        driver.findElement(By.linkText("Customer")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Customer Modules']")))));

        driver.findElement(By.linkText("Shipping")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Shipping Modules']")))));

        driver.findElement(By.linkText("Payment")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Payment Modules']")))));

        driver.findElement(By.linkText("Order Total")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Order Total Modules']")))));

        driver.findElement(By.linkText("Order Success")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Order Success Modules']")))));

        driver.findElement(By.linkText("Order Action")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Order Action Modules']")))));

        //*************************
        //Кликаем на элемент Orders и подпункты
        //*************************

        driver.findElement(By.linkText("Orders")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Orders']")))));

        driver.findElement(By.linkText("Order Statuses")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Order Statuses']")))));

        //*************************
        //Кликаем на элемент Pages
        //*************************

        driver.findElement(By.linkText("Pages")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Pages']")))));

        //*************************
        //Кликаем на элемент Reports и подпункты
        //*************************

        driver.findElement(By.linkText("Reports")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Monthly Sales']")))));

        driver.findElement(By.linkText("Most Sold Products")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Most Sold Products']")))));

        driver.findElement(By.linkText("Most Shopping Customers")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Most Shopping Customers']")))));

        //*************************
        //Кликаем на элемент Settings и подпункты
        //*************************

        driver.findElement(By.linkText("Settings")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Settings']")))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//li[@class='selected' and @id='doc-store_info']")))));

        driver.findElement(By.linkText("Defaults")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Settings']")))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//li[@class='selected' and @id='doc-defaults']")))));

        driver.findElement(By.linkText("General")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Settings']")))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//li[@class='selected' and @id='doc-general']")))));

        driver.findElement(By.linkText("Listings")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Settings']")))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//li[@class='selected' and @id='doc-listings']")))));

        driver.findElement(By.linkText("Images")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Settings']")))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//li[@class='selected' and @id='doc-images']")))));

        driver.findElement(By.linkText("Checkout")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Settings']")))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//li[@class='selected' and @id='doc-checkout']")))));

        driver.findElement(By.linkText("Advanced")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Settings']")))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//li[@class='selected' and @id='doc-advanced']")))));

        driver.findElement(By.linkText("Security")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Settings']")))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//li[@class='selected' and @id='doc-security']")))));

        //*************************
        //Кликаем на элемент Slides
        //*************************

        driver.findElement(By.linkText("Slides")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Slides']")))));

        //*************************
        //Кликаем на элемент Tax и подпункты
        //*************************

        driver.findElement(By.linkText("Tax")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Tax Classes']")))));

        driver.findElement(By.linkText("Tax Rates")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Tax Rates']")))));

        //*************************
        //Кликаем на элемент Translations и подпункты
        //*************************

        driver.findElement(By.linkText("Translations")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Search Translations']")))));

        driver.findElement(By.linkText("Scan Files")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Scan Files For Translations']")))));

        driver.findElement(By.linkText("CSV Import/Export")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' CSV Import/Export']")))));

        //*************************
        //Кликаем на элемент Users
        //*************************

        driver.findElement(By.linkText("Users")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' Users']")))));

        //*************************
        //Кликаем на элемент vQmods
        //*************************

        driver.findElement(By.linkText("vQmods")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//h1[text()=' vQmods']")))));

    }
}