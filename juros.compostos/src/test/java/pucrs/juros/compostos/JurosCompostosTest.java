package pucrs.juros.compostos;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class JurosCompostosTest {

	static private WebDriver driver;

	@BeforeClass
	public static void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		String initialPage = "http://fazaconta.com/juros-simples-compostos.htm";
		driver.get(initialPage);
	}

	@AfterClass
	public static void teardown() {
		if (driver != null)
			driver.close();
	}


	@Test
	@FileParameters("dados.csv")
	public void testeParametrizacaoJUnit(String valor, String juros, String periodo, String saida) {
		WebElement value_field = driver.findElement(By.name("p1"));
		value_field.clear();
		value_field.sendKeys(valor);

		WebElement interest_field = driver.findElement(By.name("i1"));
		interest_field.clear();
		interest_field.sendKeys("6,70");

		WebElement period_field = driver.findElement(By.name("n1"));
		period_field.clear();
		period_field.sendKeys("10");

		WebElement out_field = driver.findElement(By.id("out01"));
		System.out.println(out_field.getText());
	}
}
