package com.prueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosCandidato implements Question<Boolean> {

    private static final Target NOMBRE_CANDIDATO = Target.the("Nombre del candidato")
            .located(By.xpath("//div[contains(@class, 'oxd-table-cell') and contains(text(), 'John Doe')]"));

    @Override
    public Boolean answeredBy(Actor actor) {
        String nombreCompleto = Text.of(NOMBRE_CANDIDATO).answeredBy(actor);
        return nombreCompleto.equals("John Doe");
    }

    public static DatosCandidato sonCorrectos() {
        return new DatosCandidato();
    }
}