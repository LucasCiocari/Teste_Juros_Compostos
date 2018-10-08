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
	public void testeParametrizacaoJUnit(String value, String interest, String period, String expected) {

		value.replace(".", ",");
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(presenceOfElementLocated(By.name("p1")));
		WebElement value_field = driver.findElement(By.name("p1"));
		value_field.clear();
		value_field.sendKeys(value);

		interest.replace(".", ",");
		WebElement interest_field = driver.findElement(By.name("i1"));
		interest_field.clear();
		interest_field.sendKeys(interest);
		
		period.replace(".", ",");
		WebElement period_field = driver.findElement(By.name("n1"));
		period_field.clear();
		period_field.sendKeys(period);
		
		expected.replace(".", ",");
		WebElement out_field = driver.findElement(By.id("out01"));
		//assertEquals(expected,);
		
		System.out.println(out_field.getText().split(" ")[1]);

	}
}
