import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"stepdefs"},
        tags = {"~@Ignore", "@TestShoppingCart"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty/TestShoppingCart-1",
                "json:target/cucumber-reports/json-reports/TestShoppingCart-1.json",
                "rerun:target/cucumber-reports/rerun-reports/TestShoppingCart-1.txt"
        })

public class ShoppingCartTestRunner {

		private TestNGCucumberRunner testNGCucumberRunner;

		@BeforeClass(alwaysRun = true)
		public void setUpClass() {
			testNGCucumberRunner = new TestNGCucumberRunner(getClass());
		}

		@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
		public void feature(CucumberFeatureWrapper cucumberFeature) {
			testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		}

		@DataProvider
		public Object[][] features() {
			return testNGCucumberRunner.provideFeatures();
		}

		@AfterClass(alwaysRun = true)
		public void tearDownClass() {
			testNGCucumberRunner.finish();
		}
	}
//}
