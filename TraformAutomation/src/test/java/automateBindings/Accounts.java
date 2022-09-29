package automateBindings;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;


public class Accounts {
    WebDriver chrome;
    String[] login;
    int counter = 1000;
        @Given("^User is on Traform login screen$")
        public void user_is_on_Traform_login_screen() throws Throwable {
            System.setProperty("webdriver.chrome.driver", "/Users/nikhildhomse/Programming Projects/chromedriver");

        }

        @Given("^Access to (\\d+) Traform accounts is acquired$")
        public void access_to_Traform_accounts_is_acquired(int arg1) throws Throwable {
            login = new String[1000];
            BufferedReader users = new BufferedReader(new FileReader("/Users/nikhildhomse/Programming Projects/Traform/TraformAutomation/Data/userdata.txt"));
            for(int i=0;i<1000;i++) {
                String line = users.readLine();
                login[i] = line;
            }

        }

        @When("^Accounts are logged in$")
        public void accounts_are_logged_in() throws Throwable {
            String text = "HOME";
            for(int i=501;i<502;i++) {
                chrome = new ChromeDriver();
                chrome.get("https://bioconuat.cluster1.traform.io/ ");
                chrome.findElement(By.id("userId")).sendKeys(login[i]);
                chrome.findElement(By.cssSelector("input[id=password]")).sendKeys("Traform#cuat");
                chrome.findElement(By.cssSelector("input[id=domain]")).sendKeys("biocon");
                WebDriverWait wait = new WebDriverWait(chrome, 8);
                chrome.findElement(By.xpath("//a[@href='javascript:;']")).click();
                List<WebElement> list = chrome.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
                Assert.assertTrue("Text not found!", list.size() > 0);
                if(list.size()>0)
                    System.out.println("Text was found");
                chrome.findElement(By.xpath("//a[@href='UserDashBoard.do?method=showUserDashBoardTrips']")).click();
                chrome.findElement(By.id("dom-trip")).click();
              //  chrome.quit();
                chrome.findElement(By.xpath("//a[@id='TRIP-from_city-0']")).sendKeys("Bangalore");
     //           trip.selectByVisibleText("Short Term Assignment");
            }
        }

        @Then("^No errors are reported$")
        public void no_errors_are_reported() throws Throwable {
//              String text = "HOME";

           // if(counter<996)
//                accounts_are_logged_in();
        }


}
