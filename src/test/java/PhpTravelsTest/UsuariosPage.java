package PhpTravelsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsuariosPage {

	private WebDriver driver;

	public UsuariosPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Login(String Login, String senha) {

		WebElement campoLogin =  this.driver.findElement(By.name("email"));
		WebElement campoSenha =  this.driver.findElement(By.name("password"));

		campoLogin.sendKeys(Login);
		campoSenha.sendKeys(senha);

		campoSenha.submit();

	}

	public NovoUsuarioPage novo() {
		this.driver.get("https://www.phptravels.net/admin/accounts/customers/");
		return new NovoUsuarioPage(this.driver);
	}

	public boolean existeNaListagem(String nome, String ultimoNome) {
		return this.driver.getPageSource().contains(nome)&&
				this.driver.getPageSource().contains(ultimoNome);
	}

}
