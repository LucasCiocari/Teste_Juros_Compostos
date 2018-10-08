package pucrs.juros.compostos;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class JurosCompostosTest {

	static private WebDriver driver;
	static JurosCompostosPage page;


	@BeforeClass
	public static void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		String initialPage = "http://fazaconta.com/juros-simples-compostos.htm";
		driver.get(initialPage);
		
		page = PageFactory.initElements(driver, JurosCompostosPage.class);
	}

	@AfterClass
	public static void teardown() {
		if (driver != null)
			driver.close();
	}


	@Test
	@FileParameters("dados.csv")
	public void testeParametrizacaoJUnit(String value, String interest, String period, String expected) {

		page.fillValue(value);
		page.fillInterest(interest);
		page.fillPeriod(period);
		expected = expected.replace(".", ",");
		assertEquals(expected, page.getActual());
		
	}
}
