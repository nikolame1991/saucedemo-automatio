package saucedemo;

import org.testng.annotations.DataProvider;

/**
 * Provides test data for user-related fields used in SauceDemo checkout tests.
 * 
 * Includes:
 * - Valid first name, last name, and postal code examples as class variables.
 * - A TestNG DataProvider supplying multiple sets of user data
 *   for parameterized tests covering various input scenarios.
 */
public class TestDataSauceDemo {
    // Sample valid user data fields
    public String correctFirstName = "Nikola";
    public String correctLastName = "Medan";
    public String correctPostCard = "21000";

    /**
     * DataProvider named "userData" supplying multiple user data sets:
     * Each array contains: {firstName, lastName, postalCode}
     * 
     * Can be used to run parameterized tests for checkout or form validations.
     */
    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][] {
            { "Nikola", "Medan", "21000" },
            { "Petar", "Petrović", "11000" },
            { "Jovana", "Jović", "31000" }
        };
    }
}
