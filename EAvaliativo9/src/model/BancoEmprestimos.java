package model;


public class BancoEmprestimos {
    private Emprestimo emprestimos[];
    private static final int LIMITE_EMPRESTIMOS = 20;
    private int qtdEMprestimos;
    private Biblioteca bib;

    public BancoEmprestimos(Biblioteca bib) {
        this.qtdEMprestimos = 0;
        this.emprestimos = new Emprestimo[LIMITE_EMPRESTIMOS];
        this.bib = bib;
    }

    /**
     *  realiza um emprestimo
     * @param livro o livro que vai ser emprestado
     * @param user o usuario que vai emprestar
     * @return true se deu certo e false caso ocorra um erro.
     */
    public boolean addEmprestimo(Livro livro,Usuario user){
        boolean deuCerto = false;
        if(qtdEMprestimos < LIMITE_EMPRESTIMOS && livro!=null && user != null && confereLimite(user) && podeEmprestar(livro)){
            emprestimos[qtdEMprestimos] = new Emprestimo(user,livro);
            qtdEMprestimos++;
            deuCerto =true;
        }
        return deuCerto;
    }

    /**
     * devolve um livro
     * @param livro o livro a ser devolvido
     * @return true se deu certo e false caso ocorra um erro
     */
    public boolean devolveLivro(Livro livro){
        boolean deuCerto = false;
        int i = 0;
        while(i<qtdEMprestimos && !deuCerto){
            if(emprestimos[i].getLivro() == livro){
                deuCerto = true;
                emprestimos[i] = null;
                qtdEMprestimos--;

            }
        }
        return deuCerto;
    }

    /**
     * confere se o livro ja está emprestado
     * @param livro
     * @return true se deu certo e false caso ocorra um erro.
     */
    public boolean podeEmprestar(Livro livro){
        int i =0;
        boolean resp = true;
        while(i<qtdEMprestimos && resp){
            if(emprestimos[i].getLivro() == livro){
                resp = false;
            }
            i++;
        }
        return resp;
    }

    /** confere se o usuario pode emprestar mais livros
     *
     * @param user usuario
     * @return true se deu certo e false caso ocorra um erro.
     */
    public boolean confereLimite(Usuario user){
        boolean deuCerto = false;
        int contador = 0;
        if(user.podeEmprestar()) {
            for (int i = 0; i < qtdEMprestimos; i++) {
                if (user.getNome() == emprestimos[i].getUser().getNome()) {
                    contador++;
                }
            }
            if (contador < user.getQtdEmprestimo()) {
                deuCerto = true;
            }
        }
        return deuCerto;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Emprestimos realizados============\n");
        for(int i=0; i<qtdEMprestimos;i++){
            sb.append(emprestimos[i].toString());
        }
        sb.append("\n==================================\n");
        return sb.toString();
    }

}
