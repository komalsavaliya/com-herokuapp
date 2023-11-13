package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *  Project-3 - ProjectName : com-herokuapp
 *  BaseUrl = http://the-internet.herokuapp.com/login
 *  1. Setup Chrome browser.
 *  2. Open URL.
 *  3. Print the title of the page.
 *  4. Print the current url.
 *  5. Print the page source.
 *  6. Enter the email to email field.
 *  7. Enter the password to password field.
 *  8. Click on Login Button.
 *  9. Print the current url.
 *  10. Refresh the page.
 *  11. Close the browser.
 */

public class HeroKuApp {
    static String browser = "Chrome";
    static String Url = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        driver.get(Url);//Open Url
        driver.manage().window().maximize();//Window Maximize
        System.out.println(driver.getTitle());//Print the title of page
        System.out.println(driver.getCurrentUrl());//Print the Current Url
        System.out.println(driver.getPageSource());//Print the page source

        //Enter email to email field
        WebElement emailFields = driver.findElement(By.id("username"));
        emailFields.sendKeys("tomsmith");

        //Enter password to password field
        WebElement passwordFields = driver.findElement(By.id("password"));
        passwordFields.sendKeys("SuperSecretPassword!");

        //Click on LoginButton
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
        System.out.println("Get current url " + driver.getCurrentUrl());//Print the current url
        driver.navigate().refresh();//Refresh the page
        driver.quit();//Close the Browser
        


    }

}
