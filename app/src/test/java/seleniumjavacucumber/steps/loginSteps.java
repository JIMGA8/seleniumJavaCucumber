package seleniumjavacucumber.steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import seleniumjavacucumber.pages.BasePage;
import seleniumjavacucumber.pages.Login;

public class loginSteps {

    Login login = new Login();

    @Given("^que navego a la pagina saucedemo$")
    public void navegarASaucedemo() {
        BasePage.navegarA("https://www.saucedemo.com/");

    }

    @When("^ingreso el usuario (.*) y la contrasena (.*)$")
    public void login(String usuario, String contrasena) {
        login.login(usuario, contrasena);
    }

    @Then("^valido el login$")
    public void validarLogin() {
        Assert.assertEquals("el texto no es igual", "Swag Labs", login.validarLogin());
    }

    @And("^cierro sesion$")
    public void logout() {
        login.logout();
    }

    @Then("^validar el cierre de sesion$")
    public void validarLogout() {
        Assert.assertTrue("no se realizo el logout", login.validarLogout());
    }

    @Then("valido el mensaje de (.+)$")
    public void validarMensajeDeError(String mensaje) {
        Assert.assertEquals("el mensaje no es igual", mensaje, login.getTextMensajeError());
    }

}
