package historia;

import java.io.Serializable;

public class Historia implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nome;
    private String texto;
    private int altVida;
    private int altEnergia;
    private String nomePersonagem;

    public String getNomePersonagem() {
        return nomePersonagem;
    }
    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAltVida() {
        return altVida;
    }
    public void setAltVida(int altVida) {
        this.altVida = altVida;
    }
    public int getAltEnergia() {
        return altEnergia;
    }
    public void setAltEnergia(int altEnergia) {
        this.altEnergia = altEnergia;
    }

}
