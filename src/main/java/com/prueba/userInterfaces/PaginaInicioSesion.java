package com.prueba.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicioSesion {
  public static final Target CAMPO_USUARIO = Target.the("campo de usuario")
          .located(By.name("username"));

  public static final Target CAMPO_CONTRASENA = Target.the("campo de contraseña")
          .located(By.name("password"));

  public static final Target BOTON_INICIAR_SESION = Target.the("botón de inicio de sesión")
          .located(By.xpath("//button[@type='submit']"));

  public static final Target ELEMENTO_CONFIRMACION = Target.the("elemento de confirmación de inicio de sesión")
          .located(By.xpath("//h6[contains(@class, 'oxd-text') and contains(@class, 'oxd-topbar-header-breadcrumb-module')]"));
}