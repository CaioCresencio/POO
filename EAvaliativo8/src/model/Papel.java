package model;

public class Papel extends Coisa{
    public Papel() {
        coisa = 3;
        nome = "Papel";
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(nome);
        return sb.toString();
    }
}
