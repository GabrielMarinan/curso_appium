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

public class CompraIndividualPage {
    private AppiumDriver driver;
    public CompraIndividualPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */
    @AndroidFindBy(id = "com.rodrigo.registro:id/cp_cantidad")
    private MobileElement cantidad;
    @AndroidFindBy(id = "com.rodrigo.registro:id/ci_add")
    private MobileElement btnAgregar;
    /**
     * Metodos
     */
    public void seleccionarCantidad(){
        if (esperarObjeto(cantidad,5)){
            cantidad.sendKeys("3");
            addStep("Elegir cantidad",true, Status.PASSED,false);
        } else addStep("Elegir cantidad",true, Status.FAILED,false);

        if (esperarObjeto(btnAgregar,5)){
            btnAgregar.click();
            addStep("Click en agregar",true, Status.PASSED,false);
        } else addStep("Elegir cantidad",true, Status.FAILED,false);
    }
}
