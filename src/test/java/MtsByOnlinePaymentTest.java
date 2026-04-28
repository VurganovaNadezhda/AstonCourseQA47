import org.example.OnlinePaymentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MtsByOnlinePaymentTest {
    WebDriver driver;
    OnlinePaymentPage paymentPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by/payment/");
        paymentPage = new OnlinePaymentPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void checkPlaceholdersForAllServiceTypes() {
        String[] types = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        String[] expectedPlaceholders = {
                "Введите номер телефона",                   // для "Услуги связи"
                "Введите номер лицевого счета",             // для "Домашний интернет"
                "Введите номер договора рассрочки",         // для "Рассрочка"
                "Введите номер договора или счета"          // для "Задолженность"
        };
        for (int i = 0; i < types.length; i++) {
            paymentPage.selectTab(types[i]);
            String actual;
            if ("Услуги связи".equals(types[i])) {
                actual = paymentPage.getPlaceholder(paymentPage.phoneNumberInput);
            } else {
                actual = paymentPage.getPlaceholder(paymentPage.accountNumberInput);
            }
            Assert.assertEquals(actual, expectedPlaceholders[i],
                    "Плейсхолдер для " + types[i] + " не совпадает");
        }
    }

    @Test
    public void testMobileServicePaymentSuccessWindow() throws InterruptedException {
        paymentPage.selectTab("Услуги связи");
        paymentPage.phoneNumberInput.clear();
        paymentPage.phoneNumberInput.sendKeys("297777777");
        paymentPage.amountInput.clear();
        paymentPage.amountInput.sendKeys("10");

        Assert.assertTrue(paymentPage.continueButton.isEnabled(), "Кнопка 'Продолжить' неактивна");
        paymentPage.continueButton.click();
        // Проверка модального окна
        Assert.assertTrue(paymentPage.modalDialog.isDisplayed(), "Модальное окно не появилось");
        Assert.assertTrue(paymentPage.modalPhoneNumber.getText().contains("297777777"),
                "Номер телефона в модальном окне не совпадает");
        Assert.assertTrue(paymentPage.modalAmount.getText().contains("10"),
                "Сумма в модальном окне неверна");
        Assert.assertTrue(paymentPage.continueButton.getText().contains("10"),
                "Сумма на кнопке не совпадает");
        // Проверка плейсхолдеров у реквизитов карты
        for (WebElement input : paymentPage.modalCardInputs) {
            Assert.assertTrue(paymentPage.getPlaceholder(input).length() > 0, "Нет плейсхолдера у поля карты");
        }
        // Проверка наличия логотипов платёжных систем
        Assert.assertTrue(paymentPage.modalPaymentSystemIcons.size() >= 2, "Нет иконок платежных систем");
    }
}
