package com.prueba.stepDefinition;

import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import com.prueba.tasks.*;
import com.prueba.questions.*;
import com.prueba.models.Credenciales;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class stepDefinition {

    @Managed(driver = "chrome")
    private WebDriver navegador;
    private Actor reclutador = Actor.named("Reclutador");

    @Dado("que el usuario ha iniciado sesion en OrangeHRM")
    public void queElUsuarioHaIniciadoSesionEnOrangeHRM() {
        reclutador.can(BrowseTheWeb.with(navegador));
        reclutador.wasAbleTo(Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
        Credenciales credenciales = new Credenciales("Admin", "admin123");
        reclutador.attemptsTo(IniciarSesion.conCredenciales(credenciales));
    }

    @Cuando("el usuario navega a la seccion de {string}")
    public void elUsuarioNavegaALaSeccciónDe(String seccion) {
        reclutador.attemptsTo(Navegar.seccion(seccion));
    }

    @Y("hace clic en el botón {string}")
    public void haceClicEnElBotón(String nombreBoton) {
        reclutador.attemptsTo(PulsarBoton.conNombre(nombreBoton));
    }

    @Y("completa el formulario de información del candidato con la vacante {string}")
    public void completaElFormularioDeInformaciónDelCandidatoConLaVacante(String vacante) {
        reclutador.attemptsTo(CompletarFormulario.conVacancy(vacante));
    }

    @Y("guarda la información del candidato")
    public void guardaLaInformaciónDelCandidato() {
        reclutador.attemptsTo(GuardarInformacion.delCandidato());
    }

    @Entonces("el sistema debe mostrar el candidato en la lista de contrataciones")
    public void elSistemaDebeMostrarElCandidatoEnLaListaDeContrataciones() {
        reclutador.should(seeThat(CandidatoVisible.enLaLista()));
    }

    @Y("el estado del candidato debe ser {string}")
    public void elEstadoDelCandidatoDebeSer(String estado) {
        reclutador.should(seeThat(EstadoCandidato.es(estado)));
    }

    @Y("los datos del candidato deben corresponder a los ingresados en el formulario")
    public void losDatosDelCandidatoDebenCorresponderALosIngresadosEnElFormulario() {
        reclutador.should(seeThat(DatosCandidato.sonCorrectos()));
    }
}