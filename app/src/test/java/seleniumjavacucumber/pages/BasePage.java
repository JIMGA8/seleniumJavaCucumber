package seleniumjavacucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    static {
        System.setProperty("webdriver.chrome.driver",
                "C://Users//GOIAR//Documents//seleniumJavaCucumber//driver//chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 0);
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    // Funcion para navegar a una url
    public static void navegarA(String url) {
        driver.get(url);
    }

    // funcion para realizar un refresh
    public void refresh() {
        driver.navigate().refresh();
    }

    // funcion ir atras
    public void pageBack() {
        driver.navigate().back();
    }

    // funcion para obtener el titulo de una pagina
    public void getTitle() {
        driver.getTitle();
    }

    // funcion para obtener la url
    public void getUrl() {
        driver.getCurrentUrl();
    }

    // funcion para cerrar una ventana
    public static void driverClose() {
        driver.close();
    }

    // funcion para cerrar el Driver
    public static void driverQuit() {
        driver.quit();
    }

}
