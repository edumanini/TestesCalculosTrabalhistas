import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CalculoFeriasPage {
	public WebDriver driver;
	
	public CalculoFeriasPage(WebDriver d){
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
	
	public void setNumeroDependentes(String valor){
		WebElement numeroDependentes = mapElements("numeroDependentes"); 
		
		numeroDependentes.clear();
		numeroDependentes.sendKeys(valor);
	}
	
	public void setDiasFerias(String valor){
		WebElement diasFerias = mapElements("diasFerias"); 
		
		diasFerias.clear();
		diasFerias.sendKeys(valor);
	}
	
	public void setOpcaoVenderFerias(boolean opcao){
		WebElement opcaoVenderFerias;
		
		if(opcao){
			opcaoVenderFerias = mapElements("comAbonoPecuniario");
		}
		else{
			opcaoVenderFerias = mapElements("semAbonoPecuniario");			
		}
		
		opcaoVenderFerias.click();
	}
	
	public void calcular(){
		driver.findElement(By.id("calcularBtn")).click();
	}
	
	public String getValorCalculado(){
		return(driver.findElement(By.id("valor")).getText());
	}
}
