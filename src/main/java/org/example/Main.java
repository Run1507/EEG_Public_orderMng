package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;


import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException, IOException, TesseractException {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions chrome = new ChromeOptions();
        chrome.addArguments("--start-maximized", "--remote-allow-origins=*", "--incognito");
        WebDriver driver = new ChromeDriver(chrome);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        // Open EEG DataHub form
        driver.get("https://staging.eegdatahub.com/patient-form/f3c331b5-c216-4a11-8ada-6fe7665cb1e1");

        // Fill out the form
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_Name")));

        driver.findElement(By.id("first_Name")).sendKeys("Marcus ");
        driver.findElement(By.id("last_Name")).sendKeys("victor");

        WebElement date = driver.findElement(By.xpath("//input[@placeholder='Select date']"));
        date.click();
        date.sendKeys("07-22-2000" + Keys.ENTER);

        driver.findElement(By.xpath("//input[@id='birth']")).click();
        driver.findElement(By.xpath("//div[@title='Male']")).click();

        WebElement dropdown = driver.findElement(By.xpath("//input[@id='birthIdentity']"));
        dropdown.click();
        Thread.sleep(2000);

        // Select from dropdown using Robot class
        Robot robot1 = new Robot();
        robot1.keyPress(KeyEvent.VK_DOWN);
        robot1.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(By.id("email")).sendKeys("arunpandian.a@kosoft.co");
        driver.findElement(By.xpath("//input[@id='contactphone']")).sendKeys("9597224187");

        driver.findElement(By.xpath("//input[@id='handedness']")).click();
        driver.findElement(By.xpath("//*[text()='Right Hand']")).click();

        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);

        // Checkboxes
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[1]/div[4]/table/tbody/tr[1]/td[2]/label/span/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[1]/div[4]/table/tbody/tr[2]/td[2]/label/span/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[1]/div[4]/table/tbody/tr[3]/td[2]/label/span/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[1]/div[4]/table/tbody/tr[4]/td[2]/label/span/input")).click();

        Thread.sleep(1000);
        JavascriptExecutor k = (JavascriptExecutor)driver;
        k.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[1]/div[4]/table/tbody/tr[5]/td[2]/label/span/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[1]/div[4]/table/tbody/tr[6]/td[2]/label/span/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[1]/div[4]/table/tbody/tr[7]/td[2]/label/span/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[1]/div[4]/table/tbody/tr[8]/td[2]/label/span/input")).click();

        WebElement drop=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/form/div[1]/div[6]/div/div[2]/div[1]/div"));
        drop.click();
        driver.findElement(By.xpath("(//input[@type='search'])[6]")).sendKeys("JANUMET (Oral Pill)");
        Thread.sleep(4000);

        Actions action=new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[6]/div[1]/div[2]/div[2]/div[1]")).click();
        Actions action1=new Actions(driver);
        action1.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

          // ✅ CAPTCHA Processing
        System.out.println("🔄 Capturing CAPTCHA...");
        WebElement captchaElement = driver.findElement(By.id("canv"));
        js.executeScript("arguments[0].scrollIntoView(true);", captchaElement);
        Thread.sleep(2000);

        // Take a screenshot of the CAPTCHA element directly
        File captchaScreenshot = captchaElement.getScreenshotAs(OutputType.FILE);
        BufferedImage captchaImage = ImageIO.read(captchaScreenshot);

        // Save the CAPTCHA image
        File captchaFile = new File("captcha.png");
        ImageIO.write(captchaImage, "png", captchaFile);
        System.out.println("✅ CAPTCHA image saved successfully!");

        // Extract text from CAPTCHA using OCR
        String captchaText = solveCaptchaWithOCR("captcha.png");
        System.out.println("Extracted CAPTCHA: " + captchaText);

        WebElement Reuse = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[2]/div[2]/div/input")); // Use your actual CAPTCHA input ID
        Reuse.click();
        Thread.sleep(3000); // wait after clicking

        // ✅ Step 4: Paste the extracted CAPTCHA text
        Reuse.sendKeys(captchaText);
        Thread.sleep(3000); // wait after filling

        System.out.println("✅ CAPTCHA text pasted into input field.");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Submit button after need scroll to click 'agree'


        System.out.println("✅ Submit button clicked.");

        // ✅ Scroll to click "I Agree"
        try {
            WebElement scrollableDiv = driver.findElement(By.cssSelector("h6.termcontent.scrollable-term-container"));
            JavascriptExecutor js2 = (JavascriptExecutor) driver;

            long lastHeight = ((Number) js2.executeScript("return arguments[0].scrollHeight;", scrollableDiv)).longValue();
            long clientHeight = ((Number) js2.executeScript("return arguments[0].clientHeight;", scrollableDiv)).longValue();
            long currentHeight = 0;

            while (currentHeight + clientHeight < lastHeight) {
                js2.executeScript("arguments[0].scrollTop += 90;", scrollableDiv);
                Thread.sleep(100);
                currentHeight = ((Number) js2.executeScript("return arguments[0].scrollTop;", scrollableDiv)).longValue();
            }

            Thread.sleep(2000);
            WebElement agreeButton = driver.findElement(By.xpath("//*[text()='I Agree']"));
            agreeButton.click();
            System.out.println("✅ 'I Agree' button clicked.");
        } catch (Exception e) {
            System.out.println("❌ Error while scrolling or clicking 'I Agree': " + e.getMessage());
        }


    }

    // 🔹 OCR Function to Solve CAPTCHA
    public static String solveCaptchaWithOCR(String imagePath) {
        try {
            ITesseract instance = new Tesseract();
            instance.setDatapath("D:\\Automatio Testing\\Tesseract-OCR\\tessdata"); // Set the correct Tesseract path
            instance.setLanguage("eng"); // Ensure English is used
            instance.setTessVariable("user_defined_dpi", "300"); // Fix "Invalid resolution 0 dpi" warning

            instance.setTessVariable("tessedit_char_whitelist", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");

            return instance.doOCR(new File(imagePath)).trim();
        } catch (TesseractException e) {
            System.out.println("❌ Error solving CAPTCHA: " + e.getMessage());
            return "";
        }
    }
}
