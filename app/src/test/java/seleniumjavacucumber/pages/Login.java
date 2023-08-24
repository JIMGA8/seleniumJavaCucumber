package seleniumjavacucumber.pages;

public class Login extends BasePage {

    private String campoUsername = "//input[@id='user-name']";
    private String campoPassword = "//input[@name='password']";
    private String btnLogin = "//input[@id='login-button']";
    private String tagSwagLabs = "//div[@class='app_logo']";
    private String btnMenu = "//button[@id='react-burger-menu-btn']";
    private String btnLogout = "//a[@id='logout_sidebar_link']";
    private String mensajeError = "//h3[@data-test='error']";

    public Login() {
        super(driver);
    }

    public void login(String usuario, String password) {
        write(campoUsername, usuario);
        write(campoPassword, password);
        clickElement(btnLogin);
    }

    public String validarLogin() {
        return textFromElement(tagSwagLabs);
    }

    public void logout() {
        clickElement(btnMenu);
        clickElement(btnLogout);
    }

    public boolean validarLogout() {
        return elementIsDisplayed(btnLogin);
    }

    public String getTextMensajeError() {
        return textFromElement(mensajeError);
    }
}
