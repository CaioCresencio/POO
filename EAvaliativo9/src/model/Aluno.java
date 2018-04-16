package model;

public class Aluno extends Usuario {


    public Aluno(String nome, int prontuario, String senha) {
        super(nome, prontuario, senha);
        qtdEmprestimo = 7;
    }

    /**
     * pega a quantidade de emprestimos
     * @return
     */
    public int getQtdEprestimo(){
        return qtdEmprestimo;
    }


}
