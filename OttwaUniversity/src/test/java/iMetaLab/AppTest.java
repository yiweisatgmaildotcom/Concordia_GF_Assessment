package iMetaLab;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/iMetaLab/outline.feature", glue="outline")
public class AppTest {}
