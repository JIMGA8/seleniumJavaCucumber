package seleniumjavacucumber.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    static {
        WebDriverManager.chromedriver().setup();
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
    public String getTitle() {
        return driver.getTitle();
    }

    // funcion para obtener la url
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    // funcion para cerrar una ventana
    public static void driverClose() {
        driver.close();
    }

    // funcion para cerrar el Driver
    public static void driverQuit() {
        driver.quit();
    }

    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public String textFromElement(String locator) {
        return find(locator).getText();
    }

    // funcion para abri un link que abre en otra pestañas
    public void hadlesTabs(String locator) {
        String originalWindow = driver.getWindowHandle();

        assert driver.getWindowHandles().size() == 1;

        clickElement(locator);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void cambiarVentana(int pantalla) {
        try {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(pantalla));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // funcion para ir a linktext
    public void goToLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    // Funcion para validar que un elemento es mostrado en la pagina
    public boolean elementIsDisplayed(String locator) {
        try {
            return find(locator).isDisplayed();
        } catch (org.openqa.selenium.StaleElementReferenceException j) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            return find(locator).isDisplayed();
        } catch (TimeoutException x) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // funcion para validad que un elemento esta habilitado
    public boolean elementIsEnabled(String locator) {
        return find(locator).isEnabled();
    }

    // funcion para validad que un elemento esta selecionado
    public boolean elementIsSelected(String locator) {
        return find(locator).isSelected();
    }

    // funcion que me devuelve una lista con los elementos web localizados segun su
    // xpath
    public List<WebElement> bringMeAElementsByXpath(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    // obtener una lista de string de una list de Web elements
    public List<String> convertWebElementListToStringList(List<WebElement> webElements) {
        return webElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    // funcion que seleciona un criterio de una lista
    public void selectCriteriaFromList(String locator, String criteria) {
        List<WebElement> list = bringMeAElementsByXpath(locator);
        for (WebElement element : list) {
            if (element.getText().equals(criteria)) {
                element.click();
                break;
            }
        }
    }

    public String obtenerValueElemento(String locator) {
        WebElement campoDeTexto = driver.findElement(By.xpath(locator));
        String valor = campoDeTexto.getAttribute("value");
        return valor;
    }

}
