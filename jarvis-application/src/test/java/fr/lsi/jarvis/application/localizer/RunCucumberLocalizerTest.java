package fr.lsi.jarvis.application.localizer;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@ActiveProfiles("test")
@CucumberOptions(publish = false)
public class RunCucumberLocalizerTest {

}