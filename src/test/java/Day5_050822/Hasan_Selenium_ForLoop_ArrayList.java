package Day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Hasan_Selenium_ForLoop_ArrayList {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdriver manager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //setting your driver as headless(running on background)
        //options.addArguments("headless");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver();
        //maximize the driver
        //driver.manage().window().maximize();


        //capture search number and print for following cities using arraylist and for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Bronx");
        for (int i = 0; i < cities.size(); i++) {

            //go to google home page
            driver.navigate().to("https://www.google.com");
            Thread.sleep(3000);
            //maximize the driver
            driver.manage().window().maximize();
            //locate element for search field and type keyword 'cars'
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities.get(i));
            //submit on Google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            Thread.sleep(2000);
            //capture the Google search and print it
            String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //System.out.println("result is " + searchResult);
            //extract out the number and print the search number only
            String[] arrayResult = searchResult.split(" ");
            String replaceParanth = arrayResult[3].replace("(", "").replace(")", "");
            System.out.println("My search num for city " + cities.get(i) + " is " + arrayResult[1]);



        }// end of loop

        // close window
            Thread.sleep(2000);
            driver.quit();

    }//end of main
}//end of class