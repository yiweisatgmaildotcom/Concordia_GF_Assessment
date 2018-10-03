package OttawaU.iMetaLab;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/OttawaU/iMetaLab/steps.feature", 
plugin="pretty")

public class AppTest {
	
}
