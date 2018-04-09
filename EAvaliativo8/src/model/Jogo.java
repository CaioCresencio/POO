package model;

public abstract class Jogo {
    protected int rodadas;
    public static final int EMPATE = 0;
    public static final int J1VENCEU = 1;
    public static final int J2VENCEU = 2;


    public Jogo(int rodadas){
        this.rodadas = rodadas;
    }

    /**
     * Confere qual coisa ganha de qual
     * @param e1 coisa 1
     * @param e2 coisa 2
     * @return
     */
    protected int confere(Coisa e1, Coisa e2){
        int resultado = -1;
        if(e1 instanceof Pedra) {
            if (e1 instanceof Pedra && e2 instanceof Tesoura) {
                resultado = J1VENCEU;
            } else {
                if (e1 instanceof Pedra && e2 instanceof Papel) {
                    resultado = J2VENCEU;
                } else {
                    resultado = EMPATE;
                }
            }
        }else{
            if(e1 instanceof Papel){
                if (e1 instanceof Papel && e2 instanceof Tesoura) {
                    resultado = J2VENCEU;
                } else {
                    if (e1 instanceof Papel && e2 instanceof Pedra) {
                        resultado = J1VENCEU;
                    } else {
                        resultado = EMPATE;
                    }
                }
            }else{
                if (e1 instanceof Tesoura && e2 instanceof Pedra) {
                    resultado = J2VENCEU;
                } else {
                    if (e1 instanceof Tesoura && e2 instanceof Papel) {
                        resultado = J1VENCEU;
                    } else {
                        resultado = EMPATE;
                    }
                }
            }
        }
        return resultado;
    }

}
