package model;

public abstract class Usuario {
    private String nome;
    private int prontuario;
    private String senha;
    protected int qtdEmprestimo;

    public Usuario(String nome, int prontuario, String senha) {
        this.nome = nome;
        this.prontuario = prontuario;
        this.senha = md5(senha);
    }

    /**
     * pega a quantidade de mprestimos
     * @return
     */
    public int getQtdEmprestimo() {
        return qtdEmprestimo;
    }

    /**
     * confere se o usuario pode emprestar um livro.
     * @return true caso possa e false caso nao.
     */
    public boolean podeEmprestar() {
        boolean retorno = false;
        if(qtdEmprestimo > 0){
            retorno = true;
        }
        return retorno;
    }

    /**
     * converte senha em md5
     * @param input senha
     * @return senha convertida
     */
    private String md5 (String input){
        String md5 = "";
        java.security.MessageDigest md;
        try{
            md =java.security.MessageDigest.getInstance("MD5");
            java.math.BigInteger hash = new java.math.BigInteger(1,md.digest(input.getBytes("utf-8")));
            md5 = hash.toString(16);
            while(md5.length()<32){
                md5 = '0' + md5;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return md5;
    }

    /**
     * pega o nome do usuario
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * pega o prontario do usuario
     * @return
     */
    public int getProntuario() {
        return prontuario;
    }

    /**
     * pega a senha do usuario
     * @return
     */
    public String getSenha() {
        return senha;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ");
        sb.append(this.nome);
        sb.append("\nProntuario: ");
        sb.append(this.prontuario);
        sb.append("\n-------------------------\n");
        return sb.toString();
    }
}
