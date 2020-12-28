package testSuites;

import conexion.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import conexion.DriverContext;
public class ExampleDriver {
    DriverContext driverContext = new DriverContext();
    @BeforeMethod
    public void iniciarSession(){
        driverContext.setUP("emulator-5554","Android","C:\\Users\\Gabriel.Marinan\\Downloads\\registroDeUsuarios.apk",
                "emulator-5554",true);
    }
    @Test
    public void metodo1(){
        System.out.println("test");
    }
}
