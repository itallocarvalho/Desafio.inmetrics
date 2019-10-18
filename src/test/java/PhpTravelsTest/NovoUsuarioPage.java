package PhpTravelsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoUsuarioPage {

	private final WebDriver driver;

	public NovoUsuarioPage(WebDriver driver) {
		this.driver = driver;
	}

	public void cadastro(UsuarioDto usuario) {

		WebElement botaoADD = this.driver.findElement(By.cssSelector("#content > div > form > button"));
		botaoADD.click();

		WebElement campoNome =  this.driver.findElement(By.name("fname"));
		WebElement campoSUltimoNOme =  this.driver.findElement(By.name("lname"));
		WebElement campoEmail =  this.driver.findElement(By.name("email"));
		WebElement campoSenha =  this.driver.findElement(By.name("password"));

		campoNome.sendKeys(usuario.getNome());
		campoSUltimoNOme.sendKeys(usuario.getUltimoNome());
		campoEmail.sendKeys(usuario.getEmail());
		campoSenha.sendKeys(usuario.getSenha());

		WebElement campoNacionalidade = this.driver.findElement(By.id("s2id_autogen1"));
		campoNacionalidade.click();
		campoNacionalidade = this.driver.findElement(By.cssSelector("#select2-drop > ul > li:nth-child(20)"));
		campoNacionalidade.click();
		campoNome.submit();
	}

	public boolean existeNaListagem(String nome, String ultimoNome) {
		return this.driver.getPageSource().contains(nome);
	}
}
