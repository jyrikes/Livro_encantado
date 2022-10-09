package historia;

import java.util.HashMap;

public class Escolhas {

  ConteudoEscolhas conteudo = new ConteudoEscolhas();


  private String escolha = conteudo.getEscolha();
  private Capitulo capituloEscolhido;
  private Capitulo capituloAtual;
  private String nomeCapituloAtual = conteudo.getNomeCapituloAtual();
  private String nomeCapituloEscolhido = conteudo.getNomeCapituloEscolhido();
  private String idEcolha = conteudo.getIdEcolha();



  /**
   * 
   * Resposável por construir a escolhas na sua forma base 
   * @param escolhas
   * @param capituloAtual
   * @param capituloEscolhido
   * @param idEscolhas
   */
  public Escolhas(String escolhas, Capitulo capituloAtual, 
                  Capitulo capituloEscolhido, String idEscolhas) {

    conteudo.setEscolha(escolhas);
    conteudo.setIdEcolha(idEscolhas);
    this.capituloEscolhido = capituloEscolhido;
    conteudo.setNomeCapituloEscolhido(capituloEscolhido.getHistoria().getNome());
    this.capituloAtual = capituloAtual;
    conteudo.setNomeCapituloAtual(capituloAtual.getHistoria().getNome());

  }

  /**
   * Esse método é reposável por construir as escolhas já adicionando os capítulos as suas escolhas
   * Constroe partindo do HashMap de capitulos
   * @param conteudoEscolhas
   * @param capitulos
   */
  public Escolhas(ConteudoEscolhas con, HashMap<String, Capitulo> capitulos) {

    conteudo.setEscolha(con.getEscolha());
    conteudo.setNomeCapituloAtual(con.getNomeCapituloAtual());
    conteudo.setNomeCapituloEscolhido(con.getNomeCapituloEscolhido());
    capituloAtual = capitulos.get(this.getNomeCapituloAtual());
    capituloEscolhido = capitulos.get(this.getNomeCapituloEscolhido());

  }
  
  public String getIdEcolha() {
    return idEcolha;
  }

  public void setIdEcolha(String idEcolha) {
    this.idEcolha = idEcolha;
  }

  public ConteudoEscolhas getConteudo() {
    return conteudo;
  }

  public void setConteudo(ConteudoEscolhas conteudo) {
    this.conteudo = conteudo;
  }

  public String getEscolha() {
    return escolha;
  }

  public Capitulo getCapituloEscolhido() {
    return capituloEscolhido;
  }

  public String getNomeCapituloAtual() {
    return nomeCapituloAtual;
  }

  public void setNomeCapituloAtual(String nomeCapituloAtual) {
    this.nomeCapituloAtual = nomeCapituloAtual;
  }
  public String getNomeCapituloEscolhido() {
    return nomeCapituloEscolhido;
  }

  public void setNomeCapituloEscolhido(String nomeCapituloEscolhido) {
    this.nomeCapituloEscolhido = nomeCapituloEscolhido;
  }

}
