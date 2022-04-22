package changingAddress.tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class MySteps {

    public static WebDriver driver;

    @Given("open the main page and press the singin")
    public void openLoginPAge() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl");
        driver.findElement(By.partialLinkText("Sign in")).click();
    }

    @When("^login into the shop page with my email (.*) and password (.*)$")
    public void loginIntoTheShopPageWithMyEmailEmailAndPasswordPassword(String email, String password) throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("submit-login")).click();
    }

    @And("^set the alias (.*) address (.*) city (.*) zip (.*) phone (.*)$")
    public void setTheAliasAliasAddressAddressCityCityZipZipPhonePhone(String alias, String address, String city, String zip, String phone) throws InterruptedException {
        driver.findElement(By.className("account")).click();
        driver.findElement(By.id("address-link")).click();
        driver.findElement(By.name("alias")).sendKeys(alias);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("postcode")).sendKeys(zip);
        WebElement selectElement2 = driver.findElement(By.name("id_country"));
        Select selectObject = new Select(selectElement2);
        selectObject.selectByVisibleText("United Kingdom");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
        Thread.sleep(1000);
        driver.findElement(By.name("submitAddress")).submit();
    }

    @And("verify the data")
    public void verifyTheData() {
        String addressDisplayed = driver.findElement(By.className("address-body")).getText();
        System.out.println(addressDisplayed);
    }
    @And("delete the data and verify")
    public void deleteTheDataAndVerify() {
        driver.findElement(By.partialLinkText("Delete")).click();
       }

    @Then("close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
