package com.prueba.tasks;

import com.prueba.models.Credenciales;
import com.prueba.userInterfaces.PaginaInicioSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarSesion implements Task {

    private final String usuario;
    private final String contrasena;

    public IniciarSesion(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaInicioSesion.CAMPO_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(usuario).into(PaginaInicioSesion.CAMPO_USUARIO),
                Enter.theValue(contrasena).into(PaginaInicioSesion.CAMPO_CONTRASENA),
                Click.on(PaginaInicioSesion.BOTON_INICIAR_SESION),
                WaitUntil.the(PaginaInicioSesion.ELEMENTO_CONFIRMACION, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static IniciarSesion conCredenciales(Credenciales credenciales) {
        return instrumented(IniciarSesion.class, credenciales.getUsuario(), credenciales.getContrasena());
    }

    public static IniciarSesion con(String usuario, String contrasena) {
        return instrumented(IniciarSesion.class, usuario, contrasena);
    }
}