package com.prueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CandidatoVisible implements Question<Boolean> {

    private static final Target LISTA_CANDIDATOS = Target.the("Lista de candidatos")
            .located(By.xpath("//div[contains(@class, 'oxd-table-body')]//div[contains(@class, 'oxd-table-cell') and contains(text(), 'John Doe')]"));

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(LISTA_CANDIDATOS).asBoolean().answeredBy(actor);
    }

    public static CandidatoVisible enLaLista() {
        return new CandidatoVisible();
    }
}