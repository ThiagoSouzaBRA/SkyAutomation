package Pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgramacaoPage {


    public WebDriver localDriver;
    public WebDriverWait wait;

    String titulo,horario;


    @FindBy(xpath = "//h2[text()='Destaques da Programação']")
    @CacheLookup
    WebElement checkPage;

    @FindBy(xpath = "(//div[@class='container sky-container'])[2]")
    @CacheLookup
    WebElement painelProgramacaoSky;

    @FindBy(xpath = "(//div[@class='schedule-inner schedule-live'])[1]")
    @CacheLookup
    WebElement PrimeiroCanal_ProgramacaoAovivo;

    @FindBy(xpath = "(//div[@class='schedule-inner schedule-live'])[1]//div//h2")
    @CacheLookup
    WebElement TituloPrimeiroCanal_ProgramacaoAovivo;

    @FindBy(xpath = "(//div[@class='schedule-inner schedule-live'])[1]//div[@class='program-duration']//p")
    @CacheLookup
    WebElement HorarioPrimeiroCanal_ProgramacaoAovivo;

    @FindBy(xpath = "(//div[@class='sky-modal-program-container'])[1]")
    @CacheLookup
    WebElement boxViewProgramacao_ProgramacaoAovivo;

    public ProgramacaoPage(WebDriver driver)
    {
        localDriver = driver;
        PageFactory.initElements(localDriver, this);
        wait = new WebDriverWait(localDriver, 10);
    }

    public void checkPage()
    { waitForElement(checkPage); }

    public void visualizarPainelProgramacao()
    {
        waitForElement(painelProgramacaoSky);
        scrollToElement(painelProgramacaoSky);
    }

    public void scrollToElement(WebElement elemento)
    {
        Actions actions = new Actions(localDriver);
        actions.moveToElement(elemento);
        actions.perform();
    }

    public void obterTituloEHorariPrimeiroCanalProgramacao()
    {
        waitForElement(PrimeiroCanal_ProgramacaoAovivo);
        titulo = getTituloProgramacao();
        horario = getHorarioProgramacao();
    }

    public void clickPrimeiroCanalProgramacaoAtual()
    { PrimeiroCanal_ProgramacaoAovivo.click(); }

    public boolean validarTitulo()
    {
        waitForElement(boxViewProgramacao_ProgramacaoAovivo);
        WebElement tituloProgramacaoBox = localDriver.findElement(By.xpath("//div[@class='sky-modal-program-wapper']//h2"));
        waitForElement(tituloProgramacaoBox);
        return tituloProgramacaoBox.getText().equals(titulo);
    }

    public boolean validarHorario()
    {
        waitForElement(boxViewProgramacao_ProgramacaoAovivo);
        WebElement horarioProgramacaoBox = localDriver.findElement(By.xpath("//div[@class='sky-modal-program-date-time']//span"));
        waitForElement(horarioProgramacaoBox);
        return horarioProgramacaoBox.getText().equals(horario);
    }

    public String getTituloProgramacao()
    { return TituloPrimeiroCanal_ProgramacaoAovivo.getText(); }

    public String getHorarioProgramacao()
    { return HorarioPrimeiroCanal_ProgramacaoAovivo.getText(); }

    public void waitForElement(WebElement el){ wait.until(ExpectedConditions.elementToBeClickable(el)); }

}