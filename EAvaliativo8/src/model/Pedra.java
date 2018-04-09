package model;

public class Pedra extends Coisa{
    public Pedra(){
        coisa = 1;
        nome = "Pedra";

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(nome);
        return sb.toString();
    }

}
