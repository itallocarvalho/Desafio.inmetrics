package PhpTravelsTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpTravelsTest {

	private FirefoxDriver driver;

	@Before
	public void inicializa() {
		this.driver = new FirefoxDriver();
		this.driver.get("https://www.phptravels.net/admin");
	}

	@Test
	public void testarCadastroUsuarioComSucesso() {

		UsuariosPage usuarioPage = new UsuariosPage(this.driver);

		usuarioPage.Login("admin@phptravels.com", "demoadmin");
		usuarioPage.novo();

		UsuarioDto usuarioDto = new UsuarioDto();

		usuarioDto.setEmail("jessila123@jessila.com");
		usuarioDto.setNome("Jessila");
		usuarioDto.setUltimoNome("Souza");
		usuarioDto.setSenha("TESTE123");

		NovoUsuarioPage novoUsuario = new NovoUsuarioPage(this.driver);
		novoUsuario.cadastro(usuarioDto);


		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("xcrud-list")));

		Assert.assertTrue(usuarioPage.existeNaListagem(usuarioDto.getNome(), usuarioDto.getUltimoNome()));

	}


	@After
	public void encerra() {
	//	this.driver.close();
	}

}
