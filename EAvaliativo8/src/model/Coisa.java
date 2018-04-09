package model;

public abstract class Coisa {
    protected int coisa;
    protected String nome;

    /**
     * 1 == pedra
     * 2 == tesoura
     * 3 == papel
     */
    public Coisa() {
        this.coisa = 0;
        this.nome = "Coisa";
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(coisa);
        return sb.toString();
    }


}
