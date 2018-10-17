package pucrs.juros.compostos;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;



@RunWith(JUnitParamsRunner.class)
public class JurosCompostosTest {

	static private WebDriver driver;
	static JurosCompostosPage page;
	static ExtentTest test;
	static ExtentReports report;	

	@BeforeClass
	public static void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		report = new ExtentReports("ExtentReportResults.html");
		driver.manage().window().maximize();
		String initialPage = "http://fazaconta.com/juros-simples-compostos.htm";
		driver.get(initialPage);
		
		page = PageFactory.initElements(driver, JurosCompostosPage.class);
		test = report.startTest("testeParametrizacaoJUnit");
	}

	@AfterClass
	public static void teardown() {
		if (driver != null)
			driver.close();
		report.endTest(test);
		report.flush();		
	}


	@Test
	@FileParameters("dados.csv")
	public void testeParametrizacaoJUnit(String value, String interest, String period, String expected) {

		page.fillValue(value);
		page.fillInterest(interest);
		page.fillPeriod(period);
		expected = expected.replace(".", ",");
		if(expected.contentEquals(page.getActual())) 
			test.log(LogStatus.PASS, "Valor está correto.");
		else
			test.log(LogStatus.FAIL, "Valor está incorreto.");
	
		assertEquals(expected, page.getActual());
	}
}
