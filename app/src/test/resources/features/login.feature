@login
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

