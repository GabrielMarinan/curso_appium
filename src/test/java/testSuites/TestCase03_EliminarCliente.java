package testSuites;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.CarruselPage;
import pages.ClientePage;
import pages.RegistroPage;

import static reports.Reports.finalAssert;

public class TestCase03_EliminarCliente {
    DriverContext driverContext;
    CarruselPage carruselPage;
    RegistroPage registroPage;
    ClientePage clientePage;
    @BeforeSuite
    public void iniciarSession(){
        driverContext = new DriverContext();
        driverContext.setUP("emulator-5554","Android","C:\\Users\\Gabriel.Marinan\\Downloads\\registroDeUsuarios.apk",
                "emulator-5554",true);
        System.out.println("Applicacion desplegada");
    }
    @Test(priority = 1,description = "Validación carrusel")
    public void validarDespliegue(){
        carruselPage = new CarruselPage();
        carruselPage.validarVistaDesplegada();
        finalAssert();

    }
    @Test(priority = 2,description = "Recorrer carrusel")
    public void carrusel(){
        carruselPage.recorrerCarrusel();
        registroPage = new RegistroPage();
        // Validar que se recorre correctamente el carrusel hasta llegar a la siguiente page
        Assert.assertTrue(registroPage.validarRegistroPage());
        finalAssert();
    }
    @Test(priority = 3,description = "Seleccionar cliente")
    public void seleccionarCliente(){
        registroPage.seleccionarCliente("Pedro Aguilar");

    }
    @Test(priority = 4,description = "Eliminar cliente desde la page cliente")
    public void eliminarCliente(){
        clientePage = new ClientePage();
        clientePage.borrarCliente();
        /**
         *Cliente aunque esté eliminado sigue apareciendo pero "invisible", desinstalé la app y aún así seguía apareciendo
         */
        Assert.assertFalse(registroPage.findClientByName("Pedro Aguilar"));
    }
    @AfterSuite
    public void cerrarSession(){
        driverContext.quitDriver();
    }
}
