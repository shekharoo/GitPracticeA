package com.scorpion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class DockerDemo_Chrome{

   @Test
    public void launchChromeBrowserDocker() throws MalformedURLException {
        ChromeOptions options= new ChromeOptions();
        URL url = new URL("http://localhost:4444/wd/hub");
        options.addArguments("--start-maximized");
        options.setCapability("se:name", "RegisterTest_ValidRegisterClick");
        Map<String, Object> map = options.asMap();
        System.out.println("All values of chrome options: "+map);
        WebDriver driver = new RemoteWebDriver(url,options);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.linkText("Register")).click();
        driver.quit();

    }
}
