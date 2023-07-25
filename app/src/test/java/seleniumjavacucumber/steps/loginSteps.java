package seleniumjavacucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {

    @Given("^que navego a la pagina saucedemo$")
    public void navegarASaucedemo() {

    }

    @When("^ingreso el usuario (.+) y la contrasena (.+)$")
    public void login(String usuario, String contrasena) {

    }

    @Then("^valido el login$")
    public void nada() {

    }

}
