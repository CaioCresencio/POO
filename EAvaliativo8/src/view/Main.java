package view;


import model.JogoHVH;
import model.JogoHVM;
import model.JogoHVNM;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int tipoJ;
        int qtdRodadas = 0;
        tipoJ = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo de jogo:\n 1- Humano Vs Humano\n" +
                " 2 - Humano Vs Máquina\n 3 - Humano Vs Varias Máquinas"));

        while (qtdRodadas != 3 && qtdRodadas != 1) {
            qtdRodadas = Integer.parseInt(JOptionPane.showInputDialog("Informe quantas rodadas: 1 ou 3"));
        }
        switch (tipoJ) {
            case 1:
                if (qtdRodadas == 1) {
                    int resultado;
                    String nomeJ1 = JOptionPane.showInputDialog("Informe o nome do jogador 1: ");
                    String nomej2 = JOptionPane.showInputDialog("Informe o nome do jogador 2: ");
                    JogoHVH j1 = new JogoHVH(1, nomeJ1, nomej2);
                    int escolhaJ1 = Integer.parseInt(JOptionPane.showInputDialog("Escolha do jogador 1:" +
                            "\n 1 - Pedra.\n2 - Tesoura.\n3 - Papel."));
                    int escolhaJ2 = Integer.parseInt(JOptionPane.showInputDialog("Escolha do jogador 2:" +
                            "\n 1 - Pedra.\n2 - Tesoura.\n3 - Papel."));
                    resultado = j1.jogar(escolhaJ1, escolhaJ2);
                    JOptionPane.showMessageDialog(null, confereHVH(resultado, j1));
                } else {
                    int i = 0;
                    int resultado;
                    String nomeJ1 = JOptionPane.showInputDialog("Informe o nome do jogador 1: ");
                    String nomej2 = JOptionPane.showInputDialog("Informe o nome do jogador 2: ");
                    JogoHVH j1 = new JogoHVH(3, nomeJ1, nomej2);
                    do {
                        int escolhaJ1 = Integer.parseInt(JOptionPane.showInputDialog("Escolha do jogador 1:" +
                                "\n 1 - Pedra.\n2 - Tesoura.\n3 - Papel."));
                        int escolhaJ2 = Integer.parseInt(JOptionPane.showInputDialog("Escolha do jogador 2:" +
                                "\n 1 - Pedra.\n2 - Tesoura.\n3 - Papel."));
                        resultado = j1.jogar(escolhaJ1, escolhaJ2);
                        JOptionPane.showMessageDialog(null, confereHVH(resultado, j1));
                        i++;
                    } while (i < 3 && j1.confereResultado() == -1);
                    JOptionPane.showMessageDialog(null, confereHVH(j1.confereResultado(), j1));
                }
            case 2:
                if (qtdRodadas == 1) {
                    int resultado;
                    String nomeJ1 = JOptionPane.showInputDialog("Informe o nome do jogador 1: ");
                    JogoHVM j1 = new JogoHVM(1, nomeJ1);
                    int escolhaJ1 = Integer.parseInt(JOptionPane.showInputDialog("Escolha do jogador 1:" +
                            "\n 1 - Pedra.\n2 - Tesoura.\n3 - Papel."));
                    resultado = j1.jogar(escolhaJ1);
                    JOptionPane.showMessageDialog(null, confereHVM(resultado, j1));
                } else {
                    int i = 0;
                    int resultado;
                    String nomeJ1 = JOptionPane.showInputDialog("Informe o nome do jogador 1: ");

                    JogoHVM j1 = new JogoHVM(3, nomeJ1);
                    do {
                        int escolhaJ1 = Integer.parseInt(JOptionPane.showInputDialog("Escolha do jogador 1:" +
                                "\n 1 - Pedra.\n2 - Tesoura.\n3 - Papel."));

                        resultado = j1.jogar(escolhaJ1);
                        JOptionPane.showMessageDialog(null, confereHVM(resultado, j1));
                        i++;
                    } while (i < 3 && j1.confereResultado() == -1);
                    JOptionPane.showMessageDialog(null, confereHVM(j1.confereResultado(), j1));
                }
                break;
            case 3:
                if (qtdRodadas == 1) {
                    String resultado;
                    String nomeJ1 = JOptionPane.showInputDialog("Informe o nome do jogador 1: ");
                    int qtdJogadores = Integer.parseInt(JOptionPane.showInputDialog("Escolha a quantidade de jogadores"));
                    JogoHVNM j1 = new JogoHVNM(1, nomeJ1,qtdJogadores);
                    int escolhaJ1 = Integer.parseInt(JOptionPane.showInputDialog("Escolha do jogador 1:" +
                            "\n 1 - Pedra.\n2 - Tesoura.\n3 - Papel."));
                    resultado = j1.jogar(escolhaJ1);
                    JOptionPane.showMessageDialog(null,resultado);
                } else {
                    int i = 0;
                    String nomeJ1 = JOptionPane.showInputDialog("Informe o nome do jogador 1: ");
                    int qtdJogadores = Integer.parseInt(JOptionPane.showInputDialog("Escolha a quantidade de jogadores"));

                    JogoHVNM j1 = new JogoHVNM(3, nomeJ1,qtdJogadores);
                    do {
                        int escolhaJ1 = Integer.parseInt(JOptionPane.showInputDialog("Escolha do jogador 1:" +
                                "\n 1 - Pedra.\n2 - Tesoura.\n3 - Papel."));

                        JOptionPane.showMessageDialog(null,j1.jogar(escolhaJ1));
                        i++;
                    } while (i < 3);
                    JOptionPane.showMessageDialog(null, j1.confereVitoria());
                }
                break;

                default:
                    System.out.println("Opcao invalida.");
        }

    }



   public static String confereHVH(int resultado, JogoHVH j){
        String manda;
        if(resultado == 1){
            manda = "Jogador: " +j.getNomeJogador1()+" venceu";

        }else{
            if(resultado == 2){
                manda = "Jogador: "+j.getNomeJogador2()+ " venceu";
            }else{
                if(resultado == 0){
                    manda = "Empate";
                }else{
                    manda = "Erro";
                }
            }
        }
        return manda;
   }
   public static String confereHVM(int resultado, JogoHVM j){
       String manda;
       if(resultado == 1){
           manda = "Jogador: " +j.getNomeJogador1()+" venceu";

       }else{
           if(resultado == 2){
               manda = "Jogador: "+j.getNomeJogador2()+ " venceu";
           }else{
               if(resultado == 0){
                   manda = "Empate";
               }else{
                   manda = "Erro";
               }
           }
       }
       return manda;
   }


}
