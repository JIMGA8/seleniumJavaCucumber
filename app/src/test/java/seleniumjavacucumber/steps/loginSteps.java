package seleniumjavacucumber.steps;

import io.cucumber.java.en.*;
import seleniumjavacucumber.pages.BasePage;

public class loginSteps {

    @Given("^que navego a la pagina saucedemo$")
    public void navegarASaucedemo() {
        BasePage.navegarA("https://www.saucedemo.com/");

    }

    @When("^ingreso el usuario (.+) y la contrasena (.+)$")
    public void login(String usuario, String contrasena) {

    }

    @Then("^valido el login$")
    public void nada() {

    }

}
