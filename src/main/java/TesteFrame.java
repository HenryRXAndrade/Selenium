import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFrame {

	@Test
	public void deveIntegarirComFrame() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		alert.accept();

		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);

		Assert.assertEquals("Frame OK!", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();

	}

	@Test
	public void deveInteragirComPopup() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("que merda!");
		driver.close();

		driver.switchTo().window("");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Agora Foi");
		driver.quit();
	}

	@Test
	public void deveInteragirComPopupSemTitulo() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(850, 1000));
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Agora deu Certo");

		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("HAHAHA");
		driver.quit();
	}

}
