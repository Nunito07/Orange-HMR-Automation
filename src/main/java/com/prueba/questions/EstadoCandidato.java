package com.prueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EstadoCandidato implements Question<Boolean> {

    private final String estadoEsperado;

    public EstadoCandidato(String estadoEsperado) {
        this.estadoEsperado = estadoEsperado;
    }

    private static final Target ESTADO_CANDIDATO = Target.the("Estado del candidato")
            .located(By.xpath("//div[contains(@class, 'oxd-table-cell') and contains(text(), 'John Doe')]/following-sibling::div[contains(@class, 'oxd-table-cell')][last()]"));

    @Override
    public Boolean answeredBy(Actor actor) {
        String estadoActual = Text.of(ESTADO_CANDIDATO).answeredBy(actor);
        return estadoActual.equalsIgnoreCase(estadoEsperado);
    }

    public static EstadoCandidato es(String estado) {
        return new EstadoCandidato(estado);
    }
}