package saucedemo;

import org.testng.annotations.DataProvider;

public class TestDataSauceDemo {
	public String correctFirstName = "Nikola";
	public String correctLastName = "Medan";
	public String correctPostCard = "21000";

	@DataProvider(name = "userData")
	public Object[][] userData() {
		return new Object[][] { { "Nikola", "Medan", "21000" }, { "Petar", "Petrović", "11000" },
				{ "Jovana", "Jović", "31000" } };
	}
}
