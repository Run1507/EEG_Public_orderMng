import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Account_user {
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chrome = new ChromeOptions();
        chrome.addArguments("--start-maximized", "--remote-allow-origins=*", "--incognito");
        WebDriver driver = new ChromeDriver(chrome);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions actions = new Actions(driver);

        driver.get("https://staging.eegdatahub.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//Invoice account Nanobot
        //driver.findElement(By.id("username")).sendKeys("deviga.v@kosoft.co");
//None billing account
        //driver.findElement(By.id("username")).sendKeys("kothainayagi.a@kosoft.co");
        driver.findElement(By.id("username")).sendKeys("krishnakumar.s@kosoft.co");

        //driver.findElement(By.id("password")).sendKeys("Arun@1507");
        driver.findElement(By.id("password")).sendKeys("Hope@1507");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Order Management']"))).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/button[2]/span")).click();

        //Thread.sleep(2000);


        //String firstName = "TestFN" + UUID.randomUUID().toString().substring(0,5);
        //String lastName = "TestLN" + UUID.randomUUID().toString().substring(0,5);

        //driver.findElement(By.id("firstName")).sendKeys(firstName);
        //driver.findElement(By.id("lastName")).sendKeys(lastName);

        driver.findElement(By.id("firstName")).sendKeys("Malan");
        driver.findElement(By.id("lastName")).sendKeys("David");


        driver.findElement(By.xpath("//input[@id='gender']")).click();
        driver.findElement(By.xpath("//div[@title='Male']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='genderIdentity']")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div[1]")).click();

        WebElement date = driver.findElement(By.xpath("//input[@placeholder='Select date']"));
        date.click();
        date.sendKeys("05-16-2000" + Keys.ENTER);

        driver.findElement(By.id("contactPhone")).sendKeys("9597224187");
        driver.findElement(By.id("email")).sendKeys("arunpandian.a@kosoft.co");

        driver.findElement(By.xpath("//input[@id='handedness']")).click();
        driver.findElement(By.xpath("//*[text()='Right Hand']")).click();

        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys("Washington" + Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.id("clinician")).sendKeys("Sara");
        driver.findElement(By.xpath("//input[@id='amplifierUsed']")).click();
        Robot robot5 = new Robot();
        robot5.keyPress(KeyEvent.VK_DOWN);
        robot5.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot5.keyPress(KeyEvent.VK_ENTER);
        robot5.keyRelease(KeyEvent.VK_ENTER);


        Thread.sleep(4000);
        driver.findElement(By.id("diagnosis")).sendKeys("Arrhythmia");
        Thread.sleep(4000);
        driver.findElement(By.id("symptoms")).sendKeys("Confusion");
        driver.findElement(By.id("medicationResponse")).sendKeys("Yes");

        driver.findElement(By.xpath("//input[@type='radio' and @value='False']")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[7]/div[3]/div[1]/div/div[2]/div/div/div/label[2]/span[1]")).click();
        driver.findElement(By.id("briefHistory")).sendKeys("Automation testing: order management via created request");

        JavascriptExecutor req = (JavascriptExecutor) driver;
        req.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);

        // Symptoms selection
        for (int i = 1; i <= 8; i++) {
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[2]/table/tbody/tr[" + i + "]/td[3]/label")).click();
        }

        // ✅ Medication Dropdown Fix
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[9]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
        Thread.sleep(4000);
        //search medicine and enter
        driver.findElement(By.cssSelector("#rc_select_9")).sendKeys("JANUMET (Oral Pill)");
        Thread.sleep(3000);


        //driver.findElement(By.xpath("((//input[@id='rc_select_9'])[1]")).sendKeys("JANUMET (Oral Pill)");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

// its dosage dropdown
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[9]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]")).click();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);

        Robot robot = new Robot();

// First File Upload - ECcondition.edf
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[11]/div[1]/div/div[2]/div/div/span/div[1]/span/div/p[3]")).click();
        Thread.sleep(1000);
        //StringSelection file1 = new StringSelection("D:\\work\\Automation Testing\\EDF file\\ECcondition.edf");
        StringSelection file1 = new StringSelection("D:\\EEG\\Feb_EDF files\\1\\EC47y_FEMALE_ZE-010-041-352_2024022122373582.edf");
        //StringSelection file1 = new StringSelection("D:\\Work\\Automation\\quick_file_EC.edf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file1, null);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000); // Wait for upload to finish

// Second File Upload - conditionEO.edf
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[11]/div[2]/div/div[2]/div/div/span/div[1]")).click();
        Thread.sleep(1000);
        //StringSelection file2 = new StringSelection("D:\\work\\Automation\\conditionEO.edf");
        StringSelection file2 = new StringSelection("D:\\EEG\\Feb_EDF files\\1\\EO47yrs.edf");
        //StringSelection file2 = new StringSelection("D:\\Work\\Automation\\quick_file_EO.edf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file2, null);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        //Thread.sleep(2000); // Wait for upload to finish


        System.out.println("Both EDF files uploaded successfully.");

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[13]/label/span[1]/input")).click();
        System.out.println("Patient consent form sent successfully");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Confirmation page loading.......");

        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']//span[text()='Submit']")));

// ✅ Now safely interact with elements on the new page
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='button']//span[text()='Submit']")).click();
        System.out.println("Request submitted successfully.");
    }
}
