package com.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import com.prueba.userInterfaces.Locators;

public class Navegar implements Task {
    private final String seccion;

    public Navegar(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target MENU_ITEM = Target.the("menú item " + seccion)
                .located(Locators.MENU_ITEM(seccion));

        actor.attemptsTo(
                Click.on(MENU_ITEM)
        );
    }

    public static Navegar seccion(String seccion) {
        return instrumented(Navegar.class, seccion);
    }
}
