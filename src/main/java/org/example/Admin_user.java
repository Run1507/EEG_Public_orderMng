package org.example;

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
import java.util.concurrent.TimeUnit;

public class Admin_user {
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chrome = new ChromeOptions();
        chrome.addArguments("--start-maximized");
        chrome.addArguments("--remote-allow-origins=*");
        chrome.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chrome);


        driver.get("https://staging.eegdatahub.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("username")).sendKeys("QaUser");
        driver.findElement(By.id("password")).sendKeys("Welcome@25");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("(//*[text()='New Request'])[1]")).click();
        //Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='Add']")).click();

        //Profile
        driver.findElement(By.id("firstName")).sendKeys("Wick");
        driver.findElement(By.id("lastName")).sendKeys("Reed");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='gender']")).click();
        driver.findElement(By.xpath("//div[@title='Male']")).click();

        driver.findElement(By.xpath("//input[@id='genderIdentity']")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div[1]")).click();

        WebElement date = driver.findElement(By.xpath("//input[@placeholder='Select date']"));
        date.click();
        date.sendKeys("05-16-2000" + Keys.ENTER);

        driver.findElement(By.id("contactPhone")).sendKeys("9597224187");
        driver.findElement(By.id("email")).sendKeys("subash1@gmail.com");

        driver.findElement(By.xpath("//input[@id='handedness']")).click();
        driver.findElement(By.xpath("//*[text()='Right Hand']")).click();

        //Thread.sleep(1000);

        WebElement Accs=driver.findElement(By.id("account"));
        Accs.sendKeys("Med Corp"+Keys.ENTER);

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

        driver.findElement(By.id("diagnosis")).sendKeys("hyper");
        driver.findElement(By.id("symptoms")).sendKeys("Fainting");

        driver.findElement(By.id("medicationResponse")).sendKeys("Yes");

        driver.findElement(By.xpath("//input[@type='radio' and @value='False']")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[7]/div[3]/div[1]/div/div[2]/div/div/div/label[2]/span[1]")).click();
        driver.findElement(By.id("briefHistory")).sendKeys("Automation testing");

//        Thread.sleep(1000);
//      JavascriptExecutor j = (JavascriptExecutor) driver;
//      j.executeScript("window.scrollBy(0,-500)");
//      Thread.sleep(1000);


        for (int i = 1; i <= 8; i++) {
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[2]/table/tbody/tr[" + i + "]/td[3]/label")).click();
        }


//        Thread.sleep(1000);
//        JavascriptExecutor j = (JavascriptExecutor) driver;
//        j.executeScript("window.scrollBy(0,500)");
//        Thread.sleep(1000);


        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[4]/div/div[2]/div[1]/div[1]/div/div[1]/span/span[2]")).click();

       //drop.click();
        driver.findElement(By.id("rc_select_10")).sendKeys("HALCION (Oral Pill)");

        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[4]/div/div[2]/div[1]/div[2]/div/div[1]/span/span[2]")).click();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        Robot robot = new Robot();

// First File Upload - ECcondition.edf
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[11]/div[1]/div/div[2]/div/div/span/div[1]/span/div/p[3]")).click();
        Thread.sleep(1000);
        StringSelection file1 = new StringSelection("D:\\Work\\Automation\\quick_file_EC.edf");
        // StringSelection file1 = new StringSelection("D:\\work\\Automation\\EDF Files\\quick_file_EC.edf");
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
        StringSelection file2 = new StringSelection("D:\\Work\\Automation\\quick_file_EO.edf");
        // StringSelection file2 = new StringSelection("D:\\work\\Automation\\quick_file_EO.edf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file2, null);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[13]/label/span[1]/input")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']")));
//    driver.findElement(By.xpath("//button[@type='button']")).click();
    //driver.close();







//        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[6]/div[1]/div[2]/div[2]/div[1]")).click();
//        Actions action1 = new Actions(driver);
//        action1.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(2000);
    }

}
