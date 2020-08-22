package Steps;

import Pages.HomePage;
import Pages.ProgramacaoPage;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class ProgramacaoSteps {
    public  WebDriver driver;
    public  HomePage hpage;
    public ProgramacaoPage progpage;

    @Dado("que eu esteja na pagina inicial da Sky")
    public void que_eu_esteja_na_pagina_inicial_da_sky() {

        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        //Instancias das Páginas
        hpage = new HomePage(driver);
        progpage = new ProgramacaoPage(driver);

        hpage.IrPara("https://www.sky.com.br/");

        hpage.waitPainel_BoasVindas();

        hpage.clickFecharPainel_BoasVindas();

        hpage.checkPage();

    }

    @Quando("acessar a aba Programacao")
    public void acessar_a_aba_Programacao() {
        hpage.clickLabelProgramacao();
    }

    @Entao("devera ser exibido o painel de programacao")
    public void devera_ser_exibido_o_painel_de_programacao() {
        progpage.checkPage();
    }

    @Dado("Que eu esteja na pagina da programacao sky")
    public void que_eu_esteja_na_pagina_da_programacao_sky() {
        progpage.checkPage();
    }

    @Quando("Obter o horario do programa que esta na primeira posicao sendo transmitido agora")
    public void obter_o_horario_do_programa_que_esta_na_primeira_posicao_sendo_transmitido_agora() {
        progpage.visualizarPainelProgramacao();
    }

    @Quando("Obter o titulo do programa que esta na primeira posicao sendo transmitido agora")
    public void obter_o_titulo_do_programa_que_esta_na_primeira_posicao_sendo_transmitido_agora() {
        progpage.obterTituloEHorariPrimeiroCanalProgramacao();
    }

    @Quando("Selecionar o programa")
    public void selecionar_o_programa() {
        progpage.clickPrimeiroCanalProgramacaoAtual();
    }

    @Entao("A aba devera apresentar titulo e horario iguais aos obtidos")
    public void a_aba_devera_apresentar_titulo_e_horario_iguais_aos_obtidos() {

        Assert.assertTrue(progpage.validarTitulo());
        Assert.assertTrue(progpage.validarHorario());

        driver.close();
    }
}
