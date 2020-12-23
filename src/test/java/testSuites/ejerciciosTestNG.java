package testSuites;

import org.testng.annotations.*;

public class ejerciciosTestNG {
    @BeforeMethod
    public void metodo1(){
        System.out.println("Inicio de Test");
    }
    @BeforeSuite
    public void metodo2(){
        System.out.println("Inicio de Suite");
    }
    @Test(priority = 1)
    public void metodo3(){
        System.out.println("Test 1");
    }
    @Test(priority = 2)
    public void metodo4(){
        System.out.println("Test 2");
    }
    @AfterMethod
    public void metodo5(){
        System.out.println("Termino Test");
    }

}
