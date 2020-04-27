import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {

	@Test
	public void deveInteragirComAlertSimples() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		alert.accept();
		Assert.assertEquals("Alert Simples", texto);
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}

	@Test
	public void deveAceitarAlertDoTipoConfirm() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		driver.quit();

	}

	@Test
	public void deveRejeitarAlertDoTipoConfirm() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
		driver.quit();
	}

//juntei os dois testes acima em um só
	@Test
	public void deveInteragirComAlertDoTipoConfirm() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();

		driver.findElement(By.id("confirm")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();

		driver.quit();

	}

	@Test
	public void deveInteragirComAlertDoTipoPrompt() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("2020");
		alerta.accept();
		Assert.assertEquals("Era 2020?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();
		driver.quit();

	}

}
