package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Calendar;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class NewProduct extends OptionsTests {

    String enName, enProdName, validFrom, validTo, prefix;


    @Test
    public void NewProduct() throws InterruptedException {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        Calendar calendar = Calendar.getInstance();
        int h = calendar.get(calendar.HOUR_OF_DAY);
        int m = calendar.get(calendar.MINUTE);
        int s = calendar.get(calendar.SECOND);

        enName = "more Fox";
        prefix = Integer.toString(h) + Integer.toString(m) + Integer.toString(s);
        enProdName = enName + " " + prefix;


        int y = calendar.get(calendar.YEAR);
        int month = calendar.get(calendar.MONTH);
        int d = calendar.get(calendar.DAY_OF_MONTH);

        validFrom = Integer.toString(y);
        validTo = Integer.toString(y+2);

        if(month < 10) {
            validFrom = validFrom+"-0"+Integer.toString(month);
            validTo = validTo+"-0"+Integer.toString(month);
        } else {
            validFrom = validFrom+"-"+Integer.toString(month);
            validTo = validTo+"-"+Integer.toString(month);
        }

        if(d < 10) {
            validFrom = validFrom+"-0"+Integer.toString(d);
            validTo = validTo+"-0"+Integer.toString(d);
        } else {
            validFrom = validFrom+"-"+Integer.toString(d);
            validTo = validTo+"-"+Integer.toString(d);
        }


        driver.findElement(By.cssSelector("[href*=catalog]")).click();
        // открыть каталог

        driver.findElement(By.linkText("Add New Product")).click();
        // открываем форму регистрации нового продукта


        // устанавливаем статус Enabled
        driver.findElement(By.name("status")).click();

        // вводим название товара en
        driver.findElement(By.name("name[en]")).clear();
        driver.findElement(By.name("name[en]")).sendKeys(enProdName);

        // вводим код товара
        driver.findElement(By.name("code")).sendKeys(prefix + Keys.TAB);

        // устанавливаем категорию Rubber Ducks
        driver.findElement(By.xpath("(//input[@name='categories[]'])[2]")).click();

        // Устанавливаем группу Unisex
        driver.findElement(By.xpath("(//input[@name='product_groups[]'])[3]")).click();

        // устанавливаем количество 1
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("11");

        // устанавливаем дату начала годности
        driver.findElement(By.name("date_valid_from")).sendKeys(validFrom);

        // устанавливаем дату конца годности
        driver.findElement(By.name("date_valid_to")).sendKeys(validTo);

        // Прикладываем картинку
        File file = new File("src/test/java/other/Culpeo_Fox.jpg");
        driver.findElement(By.name("new_images[]")).sendKeys(file.getAbsolutePath());
        Thread.sleep(1000);

        // переходим на вкладку Information
        driver.findElement(By.linkText("Information")).click();


        // выбираем корпорацию
        new Select(driver.findElement(By.name("manufacturer_id"))).selectByVisibleText("ACME Corp.");

        // Ввводим ключевое слово
        driver.findElement(By.name("keywords")).sendKeys(enProdName);

        // задаем краткое описание
        driver.findElement(By.name("short_description[en]")).sendKeys(enProdName);

        // задаем описание
        driver.findElement(By.name("description[en]")).sendKeys(enProdName);

        // задаем заголовок
        driver.findElement(By.name("head_title[en]")).sendKeys(enProdName);

        // задаем метаописание
        driver.findElement(By.name("meta_description[en]")).sendKeys(enProdName);


        // переходим на вкладку Prices
        driver.findElement(By.linkText("Prices")).click();


        // задаем цену
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("5");

        // выбираем валюту
        new Select(driver.findElement(By.name("purchase_price_currency_code"))).selectByVisibleText("Euros");

        // задаем цену в долларах
        driver.findElement(By.name("gross_prices[USD]")).clear();
        driver.findElement(By.name("gross_prices[USD]")).sendKeys("10");

        // задаем цену в EURO
        driver.findElement(By.name("gross_prices[EUR]")).clear();
        driver.findElement(By.name("gross_prices[EUR]")).sendKeys("5");

        // сохраняем продукт
        driver.findElement(By.name("save")).click();


        Thread.sleep(2000);


        // Проверяем наличие такого элемента на странице
        driver.findElement(By.linkText(enProdName));
    }

}
