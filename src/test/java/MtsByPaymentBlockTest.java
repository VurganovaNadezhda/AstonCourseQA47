import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class MtsByPaymentBlockTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mts.by");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        WebElement block = driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение без комиссии')]"));
        Assert.assertTrue(block.isDisplayed(), "Блок с нужным заголовком не найден/не отображается");
    }

    @Test
    public void testLogosPresence() {
        WebElement block = driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение без комиссии')]/ancestor::section"));
        List<WebElement> logos = block.findElements(By.xpath(".//img[contains(@alt, 'Visa') or contains(@alt, 'Mastercard') or contains(@alt, 'Белкарт')]"));
        Assert.assertTrue(logos.size() >= 2, "Ожидается минимум два логотипа платёжных систем");
    }
    @Test
    public void testMoreInfoLink() {
        WebElement block = driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение без комиссии')]/ancestor::section"));
        WebElement link = block.findElement(By.partialLinkText("Подробнее о сервисе"));
        String oldWindow = driver.getWindowHandle();
        link.click();

        // Переключиться на новую вкладку (если открылась)
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(oldWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().length() > 0, "Новая страница не открылась или не имеет заголовка");
        driver.close();
        driver.switchTo().window(oldWindow);
    }

    @Test
    public void testFillAndContinueButton() throws InterruptedException {
        WebElement block = driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение без комиссии')]/ancestor::section"));
        WebElement radioConnectionServices = block.findElement(By.xpath(".//label[contains(text(), 'Услуги связи')]"));
        radioConnectionServices.click();

        WebElement phoneInput = block.findElement(By.xpath(".//input[@type='tel' or @name='phone']"));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement continueBtn = block.findElement(By.xpath(".//button[contains(text(), 'Продолжить')]"));
        Assert.assertTrue(continueBtn.isEnabled(), "Кнопка 'Продолжить' неактивна");
        continueBtn.click();

        // --- Выбор услуги "Услуги связи"
        WebElement radioConnectionServices = block.findElement(By.xpath(".//label[contains(text(), 'Услуги связи')]"));
        radioConnectionServices.click();

        // --- Ввод номера телефона
        WebElement phoneInput = block.findElement(By.xpath(".//input[@type='tel' or @name='phone']"));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        // --- Ввод суммы (например, 10 BYN)
        WebElement amountInput = block.findElement(By.xpath(".//input[@type='number' or @name='amount']")); // или другой подходящий селектор
        amountInput.clear();
        amountInput.sendKeys("10");


        // Пример проверки: страница оплаты открылась
        WebElement paymentForm = driver.findElement(By.xpath("//*[contains(text(), 'Оплата')]")); // уточнить селектор
        Assert.assertTrue(paymentForm.isDisplayed(), "Страница оплаты не открылась");
    }
   }

