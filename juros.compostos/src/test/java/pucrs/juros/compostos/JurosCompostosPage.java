package pucrs.juros.compostos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class JurosCompostosPage {

	@FindBy(name = "p1")
	@CacheLookup
	WebElement value_field;
	

	@FindBy(name = "i1")
	@CacheLookup
	WebElement interest_field;

	@FindBy(name = "n1")
	@CacheLookup
	WebElement period_field;
	

	@FindBy(id = "out01")
	@CacheLookup
	WebElement out_field;
	
	void fillValue(String value) {
		value = value.replace(".", ",");
		value_field.clear();
		value_field.sendKeys(value);
	}
	
	void fillInterest(String interest) {
		interest = interest.replace(".", ",");
		interest_field.clear();
		interest_field.sendKeys(interest);
	}
	
	void fillPeriod(String period) {
		period = period.replace(".", ",");
		period_field.clear();
		period_field.sendKeys(period);
	}
	
	String getActual() {
		return out_field.getText().split(" ")[1].replace(".", "").replace("Á", "A");
	}
}
