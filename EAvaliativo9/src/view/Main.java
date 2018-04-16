package view;

import model.BancoEmprestimos;
import model.BancoUsuarios;
import model.Biblioteca;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca();
        BancoUsuarios bancoU = new BancoUsuarios();
        BancoEmprestimos BE = new BancoEmprestimos(bib);
        bib.cadastraConjunto("arnalteste","teste","subteste","subdosubteste","4545",5);
        bib.cadastraConjunto("josefaldo","oli","jupiranga","nublada","12341",2);

        bancoU.cadastraUsuario(1,"Ednelçu",1710088,"pythonMelhorQueJava");
        bancoU.cadastraUsuario(2,"Loizinho",1710052,"xablau");



        System.out.println(BE.toString());
        int i = 1;
        do {
            int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n" +
                    "1-Cadastro de usuario\n2-Cadastro de livro\n3-Emprestimo\n4-Relatorio\n5-Devolucao\n6-Sair"));
            switch (escolha) {
                case 1:
                    int tipo = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo de usuario:\n" +
                            "1-Professor\n2-Aluno\n3-funcionario"));
                    String nome = JOptionPane.showInputDialog("Informe o nome do usuario: ");
                    int prontuario = Integer.parseInt(JOptionPane.showInputDialog("Informe o prontuario do usuario: "));
                    String senha = JOptionPane.showInputDialog("Informe a senha: ");
                    JOptionPane.showMessageDialog(null, bancoU.cadastraUsuario(tipo, nome, prontuario, senha)
                            ? "Cadastrado com sucesso" : "Falhou");
                    break;
                case 2:
                    String titulo = JOptionPane.showInputDialog("Informe o titulo do livro: ");
                    String subTitulo = JOptionPane.showInputDialog("Informe o subtitulo do livro: ");
                    String nomeA = JOptionPane.showInputDialog("Informe o nome do autor: ");
                    String editora = JOptionPane.showInputDialog("Informe o nome da editora: ");
                    String isbn = JOptionPane.showInputDialog("Informe o isbn do livro: ");
                    int exemplares = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de exemplares"));
                    bib.cadastraConjunto(nomeA, titulo, subTitulo, editora, isbn, exemplares);
                    break;
                case 3:
                    int exemplar = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero do exemplar: "));
                    String livro = JOptionPane.showInputDialog("Informe o nome do livro: ");
                    String nomeU = JOptionPane.showInputDialog("Informe o nome do usuario: ");
                    String senhaU = JOptionPane.showInputDialog("Informe a senha do usuario: ");
                    JOptionPane.showMessageDialog(null, BE.addEmprestimo(
                            bib.getLivro(livro, exemplar), bancoU.getUser(nomeU, senhaU)) ? "Emprestimo realizado" : "Falhou");
                    break;
                case 4:
                    int relatorio = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo de relatorio:" +
                            "\n1-Livros na biblioteca\n2-Usuarios\n3-Emprestimos"));
                    if (relatorio == 1) {
                        System.out.println(bib.toString());
                    } else {
                        if (relatorio == 2) {
                            System.out.println(bancoU.toString());
                        } else {
                            if (relatorio == 3) {
                                System.out.println(BE.toString());
                            }
                        }
                    }
                    break;
                case 5:
                    String livroD = JOptionPane.showInputDialog("Informe o nome do livro: ");
                    int exemplarD = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero do exemplar: "));
                    JOptionPane.showMessageDialog(null, BE.devolveLivro(bib.getLivro(livroD, exemplarD)) ?
                            "Devolução concluida" : "Falhou miseravelmente");
                    break;
                case 6:
                    i = 2;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção invalida");
            }
        }while( i==1);



    }

}
