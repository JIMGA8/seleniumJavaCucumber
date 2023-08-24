@validarlogin
Feature: login

    @login
    Scenario Outline: realizar el login con usuario y contrasena valida
        Given que navego a la pagina saucedemo
        When ingreso el usuario <usuario> y la contrasena <contrasena>
        Then valido el login
        And cierro sesion
        Then validar el cierre de sesion

        Examples:
            | usuario                 | contrasena   |
            | jim                     | jsjsjsj      |
            | standard_user           | secret_sauce |
            | locked_out_user         | secret_sauce |
            | problem_user            | secret_sauce |
            | performance_glitch_user | secret_sauce |

    @usuarioRequerido
    Scenario: validar el mensaje de usuario requerido
        Given que navego a la pagina saucedemo
        When ingreso el usuario <usuario> y la contrasena <contrasena>
        Then valido el mensaje de Epic sadface: Username is required

        Examples:
            | usuario | contrasena |
            |         | jsjsjsj    |

    @contrasenaRequerido
    Scenario: validar el mensaje de contrasena requerida
        Given que navego a la pagina saucedemo
        When ingreso el usuario <usuario> y la contrasena <contrasena>
        Then valido el mensaje de Epic sadface: Password is required

        Examples:
            | usuario | contrasena |
            | prueba  |            |

    @credencialesInvalidas
    Scenario: validar el mensaje de credenciales invalidas
        Given que navego a la pagina saucedemo
        When ingreso el usuario <usuario> y la contrasena <contrasena>
        Then valido el mensaje de Epic sadface: Username and password do not match any user in this service

        Examples:
            | usuario | contrasena |
            | prueba  | ssssdsd    |
