package model;

public class JogoHVM extends Jogo {
    private Jogador j1;
    private Jogador j2;
    private int pontosJ1,pontosJ2,empates,rodadas;
    public JogoHVM(int rodadas, String nome) {
        super(rodadas);
        this.j1 = new Jogador(nome);
        this.j2 = new Jogador();
        pontosJ1 = 0;
        pontosJ2 = 0;
        empates = 0;
        this.rodadas = rodadas;

    }

    /**
     *  faz a jogada
     * @param escolhaJ1 escolha do jogador
     * @return resultado
     */
    public int jogar(int escolhaJ1){
        int resultado = -1;
        if((escolhaJ1 > 0 && escolhaJ1 <4) && rodadas>0){
            j1.setEscolha(escolhaJ1);
            j2.geraAleatorio();
            resultado = confere(j1.getEscolha(),j2.getEscolha());
            if(resultado == 1){
                pontosJ1++;
            }else{
                if(resultado == 2){
                    pontosJ2++;
                }else{
                    empates++;
                }
            }
            rodadas--;
        }
        return resultado;
    }

    /**
     * confere o resultado da melhor de 3
     * @return resultado.
     */
    public int confereResultado(){
        int result = -1;
        if(pontosJ1 == 2){
            result = J1VENCEU;
        }else{
            if(pontosJ2 == 2){
                result = J2VENCEU;
            }else{
                if(empates == 3){
                    result = EMPATE;
                }else{
                    if(empates == 2) {
                        if (pontosJ1 == 1) {
                            result = J1VENCEU;
                        } else {
                            if (pontosJ2 == 1) {
                                result = J2VENCEU;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    public String getNomeJogador1(){
        return j1.getNome();
    }
    public String getNomeJogador2(){
        return j2.getNome();
    }

}
