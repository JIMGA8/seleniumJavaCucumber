@login
Feature: login

    Scenario: realizar el login con usuario y contrasena valida
        Given que navego a la pagina saucedemo
        When ingreso el usuario standard_user y la contrasena secret_sauce
        Then valido el login
