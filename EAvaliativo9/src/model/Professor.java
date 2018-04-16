package model;

public class Professor extends Usuario {

    public Professor(String nome, int prontuario, String senha) {
        super(nome, prontuario, senha);
        qtdEmprestimo = 30;
    }

    /**pega a quantidade de emprestimos
     *
     * @return
     */
    public int getQtdEprestimo() {

        return qtdEmprestimo;
    }
}
