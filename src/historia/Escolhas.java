package historia;

import java.util.HashMap;

public class Escolhas {

  ConteudoEscolhas conteudo = new ConteudoEscolhas();

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

  private String escolha = conteudo.getEscolha();
  private Capitulo capituloEscolhido;
  private Capitulo capituloAtual;
  private String nomeCapituloAtual = conteudo.getNomeCapituloAtual();
  private String nomeCapituloEscolhido = conteudo.getNomeCapituloEscolhido();
  private String idEcolha = conteudo.getIdEcolha();

  public String getNomeCapituloEscolhido() {
    return nomeCapituloEscolhido;
  }

  public void setNomeCapituloEscolhido(String nomeCapituloEscolhido) {
    this.nomeCapituloEscolhido = nomeCapituloEscolhido;
  }

  public Escolhas(String escolhas, Capitulo capituloAtual, Capitulo capituloEscolhido, String idEscolhas) {
    conteudo.setEscolha(escolhas);
    conteudo.setIdEcolha(idEscolhas);
    this.capituloEscolhido = capituloEscolhido;
    conteudo.setNomeCapituloEscolhido(capituloEscolhido.historia.getNome());
    this.capituloAtual = capituloAtual;
    conteudo.setNomeCapituloAtual(capituloAtual.historia.getNome());

  }

  public Escolhas(ConteudoEscolhas con, HashMap<String, Capitulo> capitulos) {

    conteudo.setEscolha(con.getEscolha());
    conteudo.setNomeCapituloAtual(con.getNomeCapituloAtual());
    conteudo.setNomeCapituloEscolhido(con.getNomeCapituloEscolhido());
    capituloAtual = capitulos.get(this.getNomeCapituloAtual());
    capituloEscolhido = capitulos.get(this.getNomeCapituloEscolhido());

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

}
