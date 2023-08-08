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

    @When("^ingreso el usuario (.+) y la contrasena (.+)$")
    public void login(String usuario, String contrasena) {
        login.login(usuario, contrasena);
    }

    @Then("^valido el login$")
    public void validarLogin() {
        Assert.assertEquals("el texto no es igual", "Swag Labs", login.validarLogin());
    }

}
