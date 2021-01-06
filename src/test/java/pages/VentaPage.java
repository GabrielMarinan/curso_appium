package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static utils.MetodosGenericos.*;
import static reports.Reports.*;

public class VentaPage {
    private AppiumDriver driver;
    public VentaPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */
    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmarydinero")
    private MobileElement btnVender;
    @AndroidFindBy(id = "com.rodrigo.registro:id/buttonDefaultPositive")
    private MobileElement btnConfirmar;

    /**
     * Metodos
     */
    public void confirmarVenta(){
        if (esperarObjeto(btnVender,5)){
            btnVender.click();
            esperarObjeto(btnConfirmar,5);
            btnConfirmar.click();
            esperaExplicita(1/2);
            addStep("Venta confirmada",true, Status.PASSED,false);
        } else addStep("Venta confirmada",true, Status.FAILED,false);
    }
}
