package model;

public class Servidores extends Usuario {

    public Servidores(String nome, int prontuario, String senha) {
        super(nome, prontuario, senha);
        this.qtdEmprestimo = 4;
    }

    /**
     * pega a quantidade de emprestimos
     * @return
     */
    public int getQtdExemplares() {
        return qtdEmprestimo;
    }
}
