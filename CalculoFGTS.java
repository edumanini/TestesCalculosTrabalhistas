import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculoFGTS {
  private static WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private CalculoFGTSPage page;

  @Before
  public void setUp() throws Exception {
	  driver = Driver.createDriver();
	  driver.get(Driver.baseUrl + "/carreira-sucesso/duvidas-trabalhistas/calculo-de-fgts.php");
	  page = new CalculoFGTSPage(driver);
  }

  @Test
  public void testSalarioMedio() throws Exception {
    page.setSalario("2.250,00");
    page.setMesesTrabalhados("8");
    page.calcular();
    assertEquals("R$ 1.440,00", page.getValorCalculado());
    assertEquals("R$ 180,00", page.getRecolhimentoMensal());
  }
  
  @Test
  public void testSalarioAlto() throws Exception {
    page.setSalario("18.230,00");
    page.setMesesTrabalhados("14");
    page.calcular();
    assertEquals("R$ 20.417,60", page.getValorCalculado());
    assertEquals("R$ 1.458,40", page.getRecolhimentoMensal());
  }
  
  @Test
  public void testSalarioBaixo() throws Exception {
    page.setSalario("1.100,00");
    page.setMesesTrabalhados("3");
    page.calcular();
    assertEquals("R$ 264,00", page.getValorCalculado());
    assertEquals("R$ 88,00", page.getRecolhimentoMensal());
  }

  @After
  public void tearDown() throws Exception {
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  
  @AfterClass
  public static void tearDownAfterClass(){
	  //driver.close();
	  //driver=null;
  }
}
