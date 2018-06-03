package Model;

public class Registro {
    private int ano;
    private String estado;
    private String municipio;
    private String esfera;
    private String etapa;
    private int qtdAlunos;

    public Registro(int ano, String estado,String municipio, String esfera, String etapa,int qtdAlunos) {
        this.ano = ano;
        this.estado = estado;
        this.municipio = municipio;
        this.esfera = esfera;
        this.etapa = etapa;
        this.qtdAlunos = qtdAlunos;
    }

    public int getAno() {
        return ano;
    }

    public String getEstado() {
        return estado;
    }

    public String getEsfera() {
        return esfera;
    }

    public String getEtapa() {
        return etapa;
    }

    public int  getQtdAlunos() {
        return qtdAlunos;
    }

    public String getMunicipio() {
        return municipio;
    }
}
