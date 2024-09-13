package com.prueba.runners;

//Importar clases necesarias, deben estar en el build
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Ruta a los archivos .feature
        glue = "com.prueba.stepDefinition",  // Paquete donde se encuentran las clases de definición de pasos
        plugin = {
                "pretty",  // Imprime el resultado en consola en formato legible
                "html:target/cucumber-reports/html",  // Reporte HTML
                "json:target/cucumber-reports/cucumber.json",  // Reporte JSON
                "junit:target/cucumber-reports/cucumber.xml"  // Reporte JUnit XML
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE//Genera los pasos que no han sido definidos en la clase
)

public class runnerSteps {
}
