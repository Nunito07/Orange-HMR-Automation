package com.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import com.prueba.userInterfaces.Locators;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompletarFormulario implements Task {

    private String vacante;

    public CompletarFormulario(String vacante) {
        this.vacante = vacante;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("Juan").into(Target.the("First Name").located(Locators.FIRST_NAME_FIELD)),
                Enter.theValue("Zuluaga").into(Target.the("Last Name").located(Locators.LAST_NAME_FIELD)),
                Enter.theValue("Sebastian").into(Target.the("Middle Name").located(Locators.MIDDLE_NAME_FIELD)),

                // Hacer clic en el botón para desplegar la lista
                Click.on(Target.the("Vacancy Dropdown").located(Locators.VACANCY_DROPDOWN)),

                // Seleccionar la opción de vacante usando el argumento pasado
                Click.on(Target.the("Vacancy Option").located(Locators.VACANCY_OPTION(vacante))),

                Enter.theValue("juan.zuluaga@example.com").into(Target.the("Email").located(Locators.EMAIL_FIELD)),
                Enter.theValue("123456789").into(Target.the("Contact Number").located(Locators.CONTACT_NUMBER_FIELD)),
                Enter.theValue("Analista QA, Automation, Postman, Prueba").into(Target.the("Keywords").located(Locators.KEYWORDS_FIELD)),
                Enter.theValue("Reto tecnico de automatización").into(Target.the("Notes").located(Locators.NOTES_FIELD))
        );
    }

    public static CompletarFormulario conVacancy(String vacante) {
        return instrumented(CompletarFormulario.class, vacante);
    }
}

