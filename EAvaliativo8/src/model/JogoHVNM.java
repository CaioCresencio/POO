package model;



public class JogoHVNM extends Jogo {
    private int qtdjogadores;
    private Jogador jogadoresV[];
    private Jogador jogador;
    private int rodadas;
    private int vitorias[];
    private int qtdVitorias;

    public JogoHVNM(int rodadas,String nome, int qtdjogadores){
        super(rodadas);
        this.qtdjogadores = qtdjogadores;
        this.jogador = new Jogador(nome);
        this.rodadas = rodadas;
        this.vitorias = new int[3];
        setJogadoresV();

    }
    public void setJogadoresV(){
        this.jogadoresV = new Jogador[qtdjogadores];
        for (int i = 0; i < qtdjogadores; i++) {
            this.jogadoresV[i] = new Jogador();
            this.jogadoresV[i].setNomeVirtual(i+1);
        }
    }
    public void geralEscolhe(){
        for(int i = 0; i<qtdjogadores;i++){
            jogadoresV[i].geraAleatorio();
        }
    }

    /**
     * confere o resultado do jogo
     * @return resultado.
     */
    private String resultado(){
        int flag = 0;
        int pedra =0, papel =0, tesoura=0;
        String ganhador = "Empate";

        for(int i =0; i< qtdjogadores; i++){
            if(jogadoresV[i].getEscolha() instanceof Pedra){
                pedra = 1;
            }else{
                if(jogadoresV[i].getEscolha() instanceof Papel){
                    papel =1;
                }else{
                    tesoura =1;
                }
            }
        }
        if(jogador.getEscolha() instanceof Pedra){
            pedra++;
        }else{
            if(jogador.getEscolha() instanceof Papel){
                papel++;
            }else{
                tesoura++;
            }
        }
        if(pedra >=1 && tesoura >= 1 && papel >= 1){
           ganhador = "Empate";
        }else{
            if(pedra == 1 && papel == 0 && tesoura >= 1){
                for(int i =0; i<qtdjogadores; i++){
                    if(jogadoresV[i].getEscolha() instanceof Pedra) {
                        ganhador = jogadoresV[i].getNome();
                        vitorias[qtdjogadores] = i;
                        qtdVitorias++;

                    }
                }
                if(jogador.getEscolha() instanceof  Pedra){
                    ganhador = jogador.getNome();
                    vitorias[qtdVitorias] = -1;
                    qtdVitorias++;

                }
            }else{
                if(tesoura == 1 && pedra == 0 && papel >= 1){
                    for(int i =0; i<qtdjogadores; i++){
                        if(jogadoresV[i].getEscolha() instanceof Tesoura) {
                           ganhador = jogadoresV[i].getNome();
                            vitorias[qtdVitorias] = i;
                            qtdVitorias++;

                        }
                    }
                    if(jogador.getEscolha() instanceof  Tesoura) {
                        ganhador = jogador.getNome();
                        vitorias[qtdVitorias] = -1;
                        qtdVitorias++;

                    }
                }else{
                    if(papel==1 && tesoura == 0 && pedra >= 1){
                        for(int i =0; i<qtdjogadores; i++){
                            if(jogadoresV[i].getEscolha() instanceof Papel) {
                                ganhador = jogadoresV[i].getNome();
                                vitorias[qtdVitorias] = i;
                                qtdVitorias++;

                            }
                        }
                        if(jogador.getEscolha() instanceof  Papel){
                            ganhador = jogador.getNome();
                            vitorias[qtdVitorias] = -1;
                            qtdVitorias++;

                        }
                    }
                }
            }

        }

        return ganhador;

    }

    /**
     * confere o resultado na melhor de 3
     * @return
     */
    public String confereVitoria(){
        String j = "Empate";
        if(qtdVitorias == 3){
            if(vitorias[0]  == vitorias[1] || vitorias[0] == vitorias[2]){
                if(vitorias[0] > 0){
                    j = jogadoresV[vitorias[0]].getNome();
                }else{
                    j = jogador.getNome();
                }
            }else{
                if(vitorias[1] == vitorias[2]){
                    if(vitorias[1] > 0){
                        j = jogadoresV[vitorias[1]].getNome();
                    }else{
                        j = jogador.getNome();
                    }

                }
            }
        }
        return j;
    }

    /**
     * faz a jogada
     * @param escolha escolha do jogador
     * @return resultado
     */
    public String jogar(int escolha){
        String retorno ="Erro";
        int resultado = -1;
        if(escolha >0 && escolha <4 && rodadas>0){
            jogador.setEscolha(escolha);
            geralEscolhe();
            retorno = resultado();
            rodadas--;
        }
        return retorno;

    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<qtdjogadores) {
            sb.append(jogadoresV[i].getNome());
            i++;
        }
        return sb.toString();
    }
}
