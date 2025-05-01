package br.com.alura.codechella.domain;

public class Endereco {
    private String Cep;
    private Integer numero;
    private String complemento;

    public Endereco(String cep, Integer numero, String complemento) {
        this.setCep(cep);
        this.numero=numero;
        this.complemento=complemento;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
