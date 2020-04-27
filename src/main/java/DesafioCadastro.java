import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioCadastro {

	@Test
	public void deveCompletarUmCadastro() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Henry");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Andrade");

		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));

		Select select = new Select(element);
		select.selectByVisibleText("Superior");

		WebElement element2 = driver.findElement(By.id("elementosForm:esportes"));
		Select select2 = new Select(element2);
		select2.selectByVisibleText("Natacao");
		select2.selectByVisibleText("Futebol");

		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Nenhuma");
		driver.findElement(By.id("elementosForm:cadastrar")).click();

		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Henry"));
		Assert.assertEquals("Sobrenome: Andrade", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Natacao Futebol", driver.findElement(By.id("descEsportes")).getText());
		Assert.assertEquals("Sugestoes: Nenhuma", driver.findElement(By.id("descSugestoes")).getText());
		driver.quit();
	}

}
