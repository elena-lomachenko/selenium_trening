package Tests;

import Other.OptionsTests;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class LinksInNewWindow extends OptionsTests {
    @Test
    public void linkInNewWindow(){

        driver.navigate().to( "http://localhost/litecart/admin/?app=countries&doc=countries" );
        driver.findElement( By.name( "username" ) ).sendKeys( "admin" );
        driver.findElement( By.name( "password" ) ).sendKeys( "admin" );
        driver.findElement( By.name( "login" ) ).click();
        wait.until( ExpectedConditions.visibilityOf( driver.findElement( By.xpath( "//div[@id='notices']" ) ) ) );


        driver.findElement(By.cssSelector("[title='Edit']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(), " +
                "'Edit Country')]"))));

        String sourceWindow = driver.getWindowHandle();
        System.out.println(sourceWindow);

        List<WebElement> externalLinks = driver.findElements(By.className("fa-external-link"));
        int numberOflinks = externalLinks.size();
        for(int i = 0; i < numberOflinks; i++){
            externalLinks.get(i).click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> externaWindows = driver.getWindowHandles();
            externaWindows.remove(sourceWindow);
            String newWindow = externaWindows.iterator().next();
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(sourceWindow);
        }
    }
}
