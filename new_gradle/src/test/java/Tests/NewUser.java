package Tests;

import Other.RandomString;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;


public class NewUser extends OptionsTests {

    @Test
    public void newUser() throws NoSuchAlgorithmException {

        RandomString randommail = new RandomString();
        String firstName = "Елена";
        String lastName = "Светлая";
        String adress = "RF Novosibirsk Garanina 8";
        String postCode = "658594";
        String city = "Новосибирск";
        String country = "Russian Federation";
        String email = "" + randommail + ".com";
        String phone = "89612224534";
        String userPass = "12345";


        driver.navigate().to( "http://localhost/litecart" );

        WebElement createAccountLink = driver.findElement( By.xpath( ".//a[text() = 'Create Account']" ) );
        createAccountLink.click();

        WebElement firstNameInput = driver.findElement( By.name( "firstname" ) );
        firstNameInput.sendKeys( firstName );

        WebElement lastNameInput = driver.findElement( By.name( "lastname" ) );
        lastNameInput.sendKeys( lastName );

        WebElement adress1Input = driver.findElement( By.name( "address1" ) );
        adress1Input.sendKeys( adress );

        WebElement postcodeInput = driver.findElement( By.name( "postcode" ) );
        postcodeInput.sendKeys( postCode );

        WebElement cityInput = driver.findElement( By.name( "city" ) );
        cityInput.sendKeys( city );

        WebElement countrySelect = driver.findElement( By.name( "country_code" ) );
        new Select( countrySelect ).selectByVisibleText( country );

        WebElement emailInput = driver.findElement( By.name( "email" ) );
        emailInput.sendKeys( email );

        WebElement phoneInput = driver.findElement( By.name( "phone" ) );
        phoneInput.sendKeys( phone );

        WebElement desiredPassInput = driver.findElement( By.name( "password" ) );
        desiredPassInput.sendKeys( userPass );

        WebElement confirmPassInput = driver.findElement( By.name( "confirmed_password" ) );
        confirmPassInput.sendKeys( userPass );

        WebElement createAccountButton = driver.findElement( By.name( "create_account" ) );
        createAccountButton.click();

        driver.findElement( By.xpath( ".//a[text()='Logout']" ) ).click();


        driver.findElement( By.name( "email" ) ).sendKeys(email);
        driver.findElement( By.name( "password" ) ).sendKeys(userPass);
        driver.findElement( By.name( "login" ) ).click();
        wait.until( ExpectedConditions.visibilityOf( driver.findElement( By.xpath( "//div[@id='notices']" ) ) ) );


        driver.findElement( By.xpath( ".//a[text()='Logout']" ) ).click();


    }


}
