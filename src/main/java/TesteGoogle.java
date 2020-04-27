import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

	private WebDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "E:\\Libs/geckodriver.exe");
	}

	public TesteGoogle(WebDriver driver) {
		driver = new FirefoxDriver();
		this.driver = driver;
	}

	@Test
	public void teste() {

		driver.manage().window().setSize(new Dimension(950, 1000));
		driver.manage().window().setPosition(new Point(0, 0));

		driver.get("https://www.google.com.br");
		System.out.println(driver.getTitle());
		assertEquals("Google", driver.getTitle());

	}

	@After
	public void finaliza() {
		driver.quit();
	}

}
