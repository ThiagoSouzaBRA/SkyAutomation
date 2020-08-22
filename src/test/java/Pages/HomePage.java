package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public WebDriver localDriver;
    public WebDriverWait wait;

    @FindBy(xpath = "//a[text()='SKY']")
    @CacheLookup
    WebElement checkPageLogo;

    @FindBy(xpath = "//li//a//strong[text()='Programação']")
    @CacheLookup
    WebElement labelProgramacao;

    @FindBy(xpath = "//img[@alt='Logo SKY']")
    @CacheLookup
    WebElement painelBoasVindas;

    @FindBy(xpath = "(//div[@class='modal-header borderless']//button[@type='button'])[1]")
    @CacheLookup
    WebElement btnFecharBoasVindas;

    public HomePage(WebDriver driver)
    {
        localDriver = driver;
        PageFactory.initElements(localDriver, this);
        wait = new WebDriverWait(localDriver, 10);
    }

    public void IrPara(String url){
        localDriver.get(url);
    }

    public void clickLabelProgramacao(){
        labelProgramacao.click();
    }

    public void waitPainel_BoasVindas(){
        wait.until(ExpectedConditions.elementToBeClickable(painelBoasVindas));
    }

    public void clickFecharPainel_BoasVindas(){
        btnFecharBoasVindas.click();
    }

    public void checkPage(){waitForElement(checkPageLogo);}

    public void waitForElement(WebElement el){ wait.until(ExpectedConditions.elementToBeClickable(el));}


}
