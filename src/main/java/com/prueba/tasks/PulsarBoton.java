package com.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import com.prueba.userInterfaces.Locators;

public class PulsarBoton implements Task {
    private final String nombreBoton;

    public PulsarBoton(String nombreBoton) {
        this.nombreBoton = nombreBoton;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target BOTON = Target.the("boton " + nombreBoton)
                .located(Locators.BOTON(nombreBoton));

        System.out.println("Trying to click on button: " + nombreBoton);

        actor.attemptsTo(
                Ensure.that(BOTON).isDisplayed(),
                Ensure.that(BOTON).isEnabled(),
                Click.on(BOTON)
        );

        System.out.println("Button clicked: " + nombreBoton);
    }

    public static PulsarBoton conNombre(String nombreBoton) {
        return instrumented(PulsarBoton.class, nombreBoton);
    }
}
