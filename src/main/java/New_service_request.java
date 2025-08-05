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

public class New_service_request {
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chrome = new ChromeOptions();
        chrome.addArguments("--start-maximized");
        chrome.addArguments("--remote-allow-origins=*");
        chrome.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chrome);

        driver.get("https://staging.eegdatahub.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("username")).sendKeys("deviga.v@kosoft.co");
        driver.findElement(By.id("password")).sendKeys("Arun@1507");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='Order Management']")).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);

//Public form toggle off
       // driver.findElement(By.xpath("//div[contains(@class,'row right-side ps-0 mx-0')]//div[1]//button[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/button[2]/span")).click();
        //driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/button[2]")).click();

        driver.findElement(By.id("firstName")).sendKeys("Peter");
        driver.findElement(By.id("lastName")).sendKeys("Ben");

        // driver.findElement(By.id("gender")).sendKeys("Male");
        driver.findElement(By.xpath("//input[@id='gender']")).click();
        driver.findElement(By.xpath("//div[@title='Male']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='genderIdentity']")).click();
       driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div[1]")).click();

        
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement date = driver.findElement(By.xpath("//input[@placeholder='Select date']"));
        date.click();
        date.sendKeys("05-16-2000" + Keys.ENTER);

        driver.findElement(By.id("contactPhone")).sendKeys("9597224187");

        driver.findElement(By.id("email")).sendKeys("subash1@gmail.com");

        driver.findElement(By.xpath("//input[@id='handedness']")).click();
        driver.findElement(By.xpath("//*[text()='Right Hand']")).click();

        WebElement too =driver.findElement(By.id("state"));
        too.sendKeys("Washington"+ Keys.ENTER);

        Thread.sleep(1000);

        // Session quessionnarie

        driver.findElement(By.id("clinician")).sendKeys("Sara");


        driver.findElement(By.xpath("//input[@id='amplifierUsed']")).click();

        Robot robot1 = new Robot();
        robot1.keyPress(KeyEvent.VK_DOWN);  // Press Down Arrow (Adjust if necessary)
        robot1.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(By.id("diagnosis")).sendKeys("hyper");

        driver.findElement(By.id("symptoms")).sendKeys("Fainting");
        driver.findElement(By.id("medicationResponse")).sendKeys("Yes");

            //Meds taken (True = Yes , False = No) change the value text
        driver.findElement(By.xpath("//input[@type='radio' and @value='False']")).click();
        //Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[7]/div[3]/div[1]/div/div[2]/div/div/div/label[2]/span[1]")).click();

        driver.findElement(By.id("briefHistory")).sendKeys("Automation testing");

        Thread.sleep(1000);

        JavascriptExecutor req = (JavascriptExecutor) driver;
        req.executeScript("window.scrollBy(0,500)");

        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[2]/table/tbody/tr[1]/td[3]/label")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[2]/table/tbody/tr[2]/td[3]/label")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[2]/table/tbody/tr[3]/td[3]/label")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[2]/table/tbody/tr[4]/td[3]/label/span")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[2]/table/tbody/tr[5]/td[3]/label")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[2]/table/tbody/tr[6]/td[3]/label")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[2]/table/tbody/tr[7]/td[3]/label")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[9]/div[2]/table/tbody/tr[8]/td[3]/label")).click();



        //Medication code (its like search dropdown )
        //click the dropdown
       driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[9]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
       Thread.sleep(3000);
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


        

        // Reuse the Robot instance
        Robot robot = new Robot();

// First File Upload - ECcondition.edf
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[11]/div[1]/div/div[2]/div/div/span/div[1]/span/div/p[3]")).click();
        Thread.sleep(1000);

        StringSelection file1 = new StringSelection("D:\\work\\Automation Testing\\EDF file\\ECcondition.edf");
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

        StringSelection file2 = new StringSelection("D:\\work\\Automation\\conditionEO.edf");
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










        //Patient comsent form enabled option
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/form/div[13]/label/span[1]/input")).click();
        System.out.println("Patient consent form sent successfully");

      //driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        System.out.println("Confirmation page loading.......");

Thread.sleep(3000);

       // driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/main/div/div/div[1]/div/div/div[2]/div/div/div/div/div[4]/button")).click();
        driver.findElement(By.xpath("//button[@type='button' and span[text()='Submit']]")).click();

        System.out.println("Request submit successfully");




//Thread.sleep(2000);

        //driver.quit();


//driver.close();

    }
}
