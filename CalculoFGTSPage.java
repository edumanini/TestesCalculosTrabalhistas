import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CalculoFGTSPage {
public WebDriver driver;
	
	public CalculoFGTSPage(WebDriver d){
		driver = d;
	}
	
	public WebElement mapElements(String id) {
		WebElement element = driver.findElement(By.id(id));
		
		return(element);
	}
	
	public void setSalario(String valor){
		WebElement salario = mapElements("salario"); 
		
		salario.clear();
		salario.sendKeys(valor);
	}
	
	public void setMesesTrabalhados(String valor){
		WebElement salario = mapElements("mesesTrabalhados"); 
		
		salario.clear();
		salario.sendKeys(valor);
	}
	
	public void calcular(){
		driver.findElement(By.id("calcularBtn")).click();
	}
	
	public String getValorCalculado(){
		return(driver.findElement(By.id("valor")).getText());
	}
	
	public String getRecolhimentoMensal(){
		return(driver.findElement(By.id("descontoSalario")).getText());
	}
}
