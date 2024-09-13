package com.prueba.tasks;

import com.prueba.userInterfaces.Locators;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GuardarInformacion implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target BOTON_GUARDAR = Target.the("botón Guardar")
                .located(Locators.GUARDAR_BUTTON);

        actor.attemptsTo(
                Click.on(BOTON_GUARDAR)
        );
    }

    public static GuardarInformacion delCandidato() {
        return instrumented(GuardarInformacion.class);
    }
}
