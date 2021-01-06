package testSuites;

import conexion.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example {
    DriverContext driverContext;
    @BeforeMethod
    public void iniciarSession(){
        driverContext = new DriverContext();
        driverContext.setUP("emulator-5554","Android","C:\\Users\\Gabriel.Marinan\\Downloads\\registroDeUsuarios.apk",
                "emulator-5554",true);
    }
    @Test
    public void metodo1(){
        System.out.println("test");
    }
    @AfterMethod
    public void cerrarSession(){
        driverContext.quitDriver();
    }
}
