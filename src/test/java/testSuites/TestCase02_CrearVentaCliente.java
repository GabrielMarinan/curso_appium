package testSuites;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;

import static reports.Reports.finalAssert;

public class TestCase02_CrearVentaCliente {
    DriverContext driverContext;
    CarruselPage carruselPage;
    RegistroPage registroPage;
    SelecProductoPage selecProductoPage;
    CompraIndividualPage compraIndividualPage;
    ClientePage clientePage;
    VentaPage ventaPage;
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
        registroPage.seleccionarCliente("Pedro Aguilar2");

    }
    @Test(priority = 4,description = "Añadir venta",enabled = false)
    public void anadirVenta(){
        clientePage = new ClientePage();
        selecProductoPage = new SelecProductoPage();
        compraIndividualPage = new CompraIndividualPage();
        ventaPage = new VentaPage();
        clientePage.clickNuevaVenta();
        selecProductoPage.selecPrimerProducto();
        compraIndividualPage.seleccionarCantidad();
        ventaPage.confirmarVenta();

    }
    @Test(priority = 5,description = "Validar precio final")
    public void precioFinal(){
        clientePage = new ClientePage();
        clientePage.precioCorrecto("55555");
    }
    // 50 from factories
    @AfterSuite
    public void cerrarSession(){
        driverContext.quitDriver();
    }
}
