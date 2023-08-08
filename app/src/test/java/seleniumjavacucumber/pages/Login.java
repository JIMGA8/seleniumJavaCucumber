package seleniumjavacucumber.pages;

public class Login extends BasePage {

    private String campoUsername = "//input[@id='user-name']";
    private String campoPassword = "//input[@name='password']";
    private String btnLogin = "//input[@id='login-button']";
    private String tagSwagLabs = "//div[@class='app_logo']";

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

}
