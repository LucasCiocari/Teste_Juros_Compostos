package pucrs.juros.compostos;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JurosCompostosTest {

	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@Before
	public void setupTest() {
		driver = new ChromeDriver();

		String initialPage = "http://fazaconta.com/juros-simples-compostos.htm";
		driver.get(initialPage);
	}

	@After
	public void teardown() {
		if (driver != null)
			driver.close();
	}

	@Test
	public void GivenPositiveValuesInFieldThenAnswerHasToBeValid() {

		WebElement valor = driver.findElement(By.name("p1"));
		valor.clear();
		valor.sendKeys("5500,43");
		
		WebElement juros = driver.findElement(By.name("i1"));
		juros.clear();
		juros.sendKeys("6,70");
		
		WebElement periodo = driver.findElement(By.name("n1"));
		periodo.clear();
		periodo.sendKeys("10");
		
		WebElement saida = driver.findElement(By.id("out01"));
		System.out.println(saida.getText());
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
