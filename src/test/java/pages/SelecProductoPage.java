package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.support.PageFactory;

import static reports.Reports.addStep;
import static utils.MetodosGenericos.esperaExplicita;
import static utils.MetodosGenericos.esperarObjeto;

public class SelecProductoPage {
    private AppiumDriver driver;
    public SelecProductoPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */
    @AndroidFindBy(id = "android:id/text1")
    private MobileElement primerProducto;
    /**
     * Metodos
     */
    public void selecPrimerProducto(){
        if (esperarObjeto(primerProducto,5)){
            primerProducto.click();
            esperaExplicita(1/2);
            addStep("Click en primer producto",false, Status.PASSED,false);
        } else addStep("Click en primer producto",false, Status.FAILED,false);
    }
}
