package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OnlinePaymentPage {
    private WebDriver driver;

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // --- Селекторы вкладок ---
    @FindBy(xpath = "//label[contains(.,'Услуги связи')]")
    public WebElement tabMobile;
    @FindBy(xpath = "//label[contains(.,'Домашний интернет')]")
    public WebElement tabHomeInternet;
    @FindBy(xpath = "//label[contains(.,'Рассрочка')]")
    public WebElement tabInstallment;
    @FindBy(xpath = "//label[contains(.,'Задолженность')]")
    public WebElement tabDebt;

    // --- Общие поля ввода (заполняются по ситуации) ---
    @FindBy(xpath = ".//input[@type='tel' or contains(@placeholder, 'номер')]")
    public WebElement phoneNumberInput;

    @FindBy(xpath = ".//input[@type='text' or contains(@placeholder, 'лицевой счет') or contains(@placeholder,'договор')]")
    public WebElement accountNumberInput;

    @FindBy(xpath = ".//input[@type='number' or @name='amount']")
    public WebElement amountInput;

    // --- Кнопка "Продолжить" ---
    @FindBy(xpath = ".//button[contains(text(),'Продолжить')]")
    public WebElement continueButton;

    // --- Плейсхолдеры/надписи у полей (отображаются когда не заполнено) ---
    public String getPlaceholder(WebElement el) {
        try { return el.getAttribute("placeholder"); } catch(Exception ex) { return ""; }
    }

    // --- Модальное окно после "Продолжить" ---
    @FindBy(xpath = "//div[contains(@class,'modal')]")
    public WebElement modalDialog;

    @FindBy(xpath = "//div[contains(@class,'modal')]//span[contains(@class,'phone-number')]")
    public WebElement modalPhoneNumber;

    @FindBy(xpath = "//div[contains(@class,'modal')]//span[contains(@class,'amount')]")
    public WebElement modalAmount;

    @FindBy(xpath = "//div[contains(@class,'modal')]//input[contains(@name,'card')]")
    public List<WebElement> modalCardInputs;

    @FindBy(xpath = "//div[contains(@class,'modal')]//img[contains(@alt, 'Visa') or contains(@alt,'Mastercard') or contains(@alt,'Белкарт')]")
    public List<WebElement> modalPaymentSystemIcons;

    // --- Методы выбора вида услуги ---
    public void selectTab(String name) {
        switch (name) {
            case "Услуги связи": tabMobile.click(); break;
            case "Домашний интернет": tabHomeInternet.click(); break;
            case "Рассрочка": tabInstallment.click(); break;
            case "Задолженность": tabDebt.click(); break;
            default: throw new IllegalArgumentException("Нет вкладки "+name);
        }
    }

}

