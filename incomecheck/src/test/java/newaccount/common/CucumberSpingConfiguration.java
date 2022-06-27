package newaccount.common;

import io.cucumber.spring.CucumberContextConfiguration;
import newaccount.IncomecheckApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { IncomecheckApplication.class })
public class CucumberSpingConfiguration {}
