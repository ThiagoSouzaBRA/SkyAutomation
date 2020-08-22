#language: pt

Funcionalidade: Programação Sky

  Contexto:
    Dado que eu esteja na pagina inicial da Sky
    Quando acessar a aba Programacao
    Entao devera ser exibido o painel de programacao

  @PRD @ProgramacaoSky @Sucesso
  Cenario: : CT01_ValidarHorarioProgramacao_Sucesso
    Dado Que eu esteja na pagina da programacao sky
    Quando Obter o horario do programa que esta na primeira posicao sendo transmitido agora
    E Obter o titulo do programa que esta na primeira posicao sendo transmitido agora
    E Selecionar o programa
    Entao A aba devera apresentar titulo e horario iguais aos obtidos