package ru.vtb.winappdriver;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    public static WindowsDriver notepadSession = null;

    @BeforeClass
    public static void setUpAll() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "WindowsPC");
            capabilities.setCapability("app", "c:\\Windows\\notepad.exe");
            notepadSession = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
            Thread.sleep(10000);    //Uncomment if required
            notepadSession.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            //
        }
    }

    @BeforeMethod
    public void setUp(){
        //
    }

    @Test
    public void search() {
            notepadSession.findElementByName("Справка").click();
            notepadSession.findElementByName("О программе").click();
            notepadSession.findElementByName("ОК").click();
    }

    @AfterMethod
    public void exit() {
        notepadSession.quit();
    }

}
