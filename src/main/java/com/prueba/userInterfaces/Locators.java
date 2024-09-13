package com.prueba.userInterfaces;

import org.openqa.selenium.By;

public class Locators {

    // Locators para Navegar
    public static final By MENU_ITEM(String seccion) {
        return By.xpath("//span[contains(@class, 'oxd-main-menu-item--name') and text()='" + seccion + "']");
    }

    // Locators para PulsarBoton
    public static final By BOTON(String nombreBoton) {
        return By.xpath("//button[contains(.,'" + nombreBoton + "')]");
    }

    // Locators para CompletarFormulario
    public static final By FIRST_NAME_FIELD = By.name("firstName");
    public static final By LAST_NAME_FIELD = By.name("lastName");
    public static final By MIDDLE_NAME_FIELD = By.name("middleName");
    //Manejo del select de vacancy
    public static final By VACANCY_DROPDOWN = By.className("oxd-select-text--after");
    public static final By VACANCY_OPTION(String optionText) {
        return By.xpath("//div[@role='listbox']//span[text()='" + optionText + "']");
    }
    public static final By EMAIL_FIELD = By.xpath("//div[div/label[contains(text(), 'Email')]]//input[@class='oxd-input oxd-input--active' and @placeholder='Type here']");
    public static final By CONTACT_NUMBER_FIELD = By.xpath("//div[div/label[contains(text(), 'Contact Number')]]//input[@class='oxd-input oxd-input--active' and @placeholder='Type here']");
    public static final By KEYWORDS_FIELD = By.xpath("//input[@class='oxd-input oxd-input--active' and @placeholder='Enter comma seperated words...']");
    public static final By NOTES_FIELD = By.cssSelector(".oxd-textarea--active");

    // Locators para GuardarInformacion
    public static final By GUARDAR_BUTTON = By.xpath("//button[contains(@class, 'oxd-button--secondary')]");
}
