package model;

import java.util.Random;

public class Jogador {
    private Coisa escolha;
    private String nome;

    public Jogador(String nome) {
        this.nome = nome;
    }
    public Jogador(){
        this.nome = "Jogador virtual";
        geraAleatorio();
    }
    public void setEscolha(int escolha) {
        if(escolha == 3 || escolha == 2 || escolha == 1){
            if(escolha == 3){
                this.escolha = new Papel();
            }else{
                if(escolha == 2){
                    this.escolha = new Tesoura();
                }else{
                    this.escolha = new Pedra();
                }
            }
        }
    }

    /**
     * gera uma escolha aleatoria
     */
    protected void geraAleatorio() {
        int gerado;
        Random gerador = new Random();
        gerado = gerador.nextInt(3) + 1;
        setEscolha(gerado);
    }

    public Coisa getEscolha() {
        return escolha;
    }
    public String getNomeEscolha(){
        return escolha.toString();
    }

    public String getNome() {
        return nome;
    }
    public void setNomeVirtual(int i){
        this.nome = nome + i;
    }

}
