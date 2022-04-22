package shopping.tests;

import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

public class ShoppingTest {
    public static void main(String[] args) throws NoSuchElementException, InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver",
                "src/test/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");

        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.name("email")).sendKeys("hcggctlmtnzicmznqu@bvhrk.com");
        driver.findElement(By.name("password")).sendKeys("hasło");
        Thread.sleep(1000);
        driver.findElement(By.id("submit-login")).click();

        driver.findElement(By.className("account")).click();
        driver.findElement(By.id("address-link")).click();
        driver.findElement(By.name("alias")).sendKeys("Brygida");
        driver.findElement(By.name("address1")).sendKeys("Golędzinowska");
        driver.findElement(By.name("city")).sendKeys("Warszawa");
        driver.findElement(By.name("postcode")).sendKeys("03-302");
        WebElement selectElement2 = driver.findElement(By.name("id_country"));
        Select selectObject = new Select(selectElement2);
        selectObject.selectByVisibleText("United Kingdom");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("72 260 72 18");
        Thread.sleep(1000);
        driver.findElement(By.name("submitAddress")).submit();

        driver.findElement(By.name("s")).sendKeys("Hummingbird Printed Sweater");
        driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
        driver.findElement(By.partialLinkText("Hummingbird Printed Sweater")).click();

        WebElement size = driver.findElement(By.id("group_1"));
        Select selectObjectSize = new Select(size);
        selectObjectSize.selectByVisibleText("M");
        Thread.sleep(1000);
        driver.findElement(By.name("qty")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        driver.findElement(By.name("qty")).sendKeys("5");
        driver.findElement(By.className("add")).click();

        driver.findElement(By.partialLinkText("PROCEED TO CHECKOUT")).click();
        driver.findElement(By.partialLinkText("PROCEED TO CHECKOUT")).click();
        driver.findElement(By.id("checkout-delivery-step")).click();
        Thread.sleep(500);
        driver.findElement(By.id("checkout-payment-step")).click();
        Thread.sleep(500);
        driver.findElement(By.id("payment-option-1")).click();
        Thread.sleep(500);
        String paymentLocator = "//label[contains(.,'Pay by Check')]";
        driver.findElement(By.xpath(paymentLocator)).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        driver.findElement(By.id("payment-confirmation")).click();
        Thread.sleep(500);

        long uniqueNumber = System.currentTimeMillis();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        String name = "screenShot" + uniqueNumber + ".png";
        FileUtils.copyFile(scrFile, new File("C:\\Users\\celin\\Desktop\\CodersLab_kurs\\Automatyzujący\\Portfolio\\TestowanieSklepu2022\\src\\test\\printScreen\\" + name));


//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("C:\\Users\\celin\\Desktop\\CodersLab_kurs\\Automatyzujący\\Portfolio\\TestowanieSklepu2022\\src\\test\\printScreen\\screen" +uniqueNumber = ".jpg"));

        Thread.sleep(3000);
        driver.findElement(By.className("account")).click();
        driver.findElement(By.partialLinkText("Addresses")).click();
        driver.findElement(By.partialLinkText("Delete")).click();

        driver.quit();
    }
}
