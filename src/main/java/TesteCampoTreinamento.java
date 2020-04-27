import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	@Test
	public void testeTextField() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste Escrito");
		Assert.assertEquals("Teste Escrito", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}

	@Test
	public void deveInteragirComTextArea() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste1\nTeste 2 ");
		Assert.assertEquals("Teste1\nTeste 2 ",
				driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}

	@Test
	public void deveInteragirComRadioButton() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}

	@Test
	public void deveInteragirComCheckBox() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		driver.quit();
	}

	@Test
	public void deveInteragirComComboBox() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select cb = new Select(element);
		cb.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", cb.getFirstSelectedOption().getText());

	}

	@Test
	public void deveVerificarOpcoesComboBox() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select cb = new Select(element);
		List<WebElement> elementos = cb.getOptions();
		Assert.assertEquals(8, elementos.size());

		boolean encontrou = false;
		for (WebElement webElement : elementos) {
			if (webElement.getText().equals("Superior")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);

	}

	@Test
	public void deveVerificarOpcoesComboBoxMultiplo() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select cb = new Select(element);
		cb.selectByVisibleText("Natacao");
		cb.selectByVisibleText("Futebol");
		cb.selectByVisibleText("Corrida");

		List<WebElement> elementos = cb.getAllSelectedOptions();
		Assert.assertEquals(3, elementos.size());

		boolean encontrou = false;
		int auxiliar = 0;
		for (WebElement webElement : elementos) {
			if (webElement.getText().equals("Natacao")) {
				auxiliar++;
			}
			if (webElement.getText().equals("Futebol")) {
				auxiliar++;
			}
			if (webElement.getText().equals("Corrida")) {
				auxiliar++;
			}
			if (auxiliar == 3) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
		driver.quit();

	}

	@Test
	public void deveClicarNoBotaoVerificarAlteracaoValue() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		String nomeBotao = driver.findElement(By.id("buttonSimple")).getAttribute("value");
		driver.findElement(By.id("buttonSimple")).click();
		String nomeBotaoClicado = driver.findElement(By.id("buttonSimple")).getAttribute("value");
		Assert.assertFalse(nomeBotao == nomeBotaoClicado);
		// Uma das duas verificações já estaria bom!
		Assert.assertTrue(driver.getPageSource().contains("Obrigado!"));
		Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("value"));
		driver.quit();
	}

	@Test
	public void deveInteragirComLinks() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		driver.quit();
	}

	@Test
	public void deveEncontrarTextosNaTela() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				driver.findElement(By.className("facilAchar")).getText());
		driver.quit();
	}

}
