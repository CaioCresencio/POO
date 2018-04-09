package model;

public class JogoHVH extends Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private int pontosJ1,pontosJ2,empates,rodadas;


    public JogoHVH(int rodadas, String jogador1, String jogador2) {
        super(rodadas);
        this.rodadas = rodadas;
        this.jogador1 = new Jogador(jogador1);
        this.jogador2 = new Jogador(jogador2);
        pontosJ1 = 0;
        pontosJ2 = 0;
        empates = 0;
    }

    /**
     * Faz a jogada e da o resultado do jogo
     * @param escolhaJ1 escolha do jogador 1
     * @param escolhaJ2 escolha do jogador 2
     * @return resultado do jogo em inteiro
     */
    public int jogar(int escolhaJ1, int escolhaJ2){
        int resultado = -1;
        if((escolhaJ1 > 0 && escolhaJ1 <4) && (escolhaJ2 > 0 && escolhaJ2 <4) && rodadas > 0){
            jogador1.setEscolha(escolhaJ1);
            jogador2.setEscolha(escolhaJ2);
            resultado = confere(jogador1.getEscolha(),jogador2.getEscolha());
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
     * confere resultado do jogo melhor de 3
     * @return
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
        return jogador1.getNome();
    }
    public String getNomeJogador2(){
        return jogador2.getNome();
    }



}
