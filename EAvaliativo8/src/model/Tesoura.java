package model;

public class Tesoura extends Coisa {
    public Tesoura(){
        coisa = 2;
        nome = "Tesoura";
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(nome);
        return sb.toString();
    }

}

