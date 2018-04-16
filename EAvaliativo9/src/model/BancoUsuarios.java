package model;

public class BancoUsuarios {
    private Usuario usuarios[];
    private static final int LIMITE_PESSOAS = 10;
    private static final int PROFESSOR = 1;
    private static final int ALUNO = 2;
    private static final int SERVIDOR = 3;
    private int qtdUsuarios;


    public BancoUsuarios() {
        this.usuarios = new Usuario[LIMITE_PESSOAS];
        this.qtdUsuarios = 0;
    }

    /**
     * cadastra um usuario no sistema
     * @param escolha o tipo de usuario
     * @param nome o nome do usuario
     * @param prontuario prontario
     * @param senha senha do usuario
     * @return true caso de certo e false caso ocorra um erro
     */
    public boolean cadastraUsuario(int escolha,String nome, int prontuario, String senha){
        boolean deuCerto = false;
        if(qtdUsuarios <= LIMITE_PESSOAS){
            if(escolha == PROFESSOR){
                usuarios[qtdUsuarios] = new Professor(nome,prontuario,senha);
                deuCerto = true;
                qtdUsuarios++;
            }else{
                if(escolha == ALUNO){
                    usuarios[qtdUsuarios] = new Aluno(nome,prontuario,senha);
                    deuCerto = true;
                    qtdUsuarios++;
                }else{
                    if(escolha == SERVIDOR){
                        usuarios[qtdUsuarios] = new Servidores(nome,prontuario,senha);
                        deuCerto = true;
                        qtdUsuarios++;
                    }
                }
            }
        }
        return deuCerto;
    }

    /**
     * procura um usuario no sistema
     * @param nome
     * @param senha
     * @return retorna nulo caso ocorra um erro e um usuario caso de certo.
     */
    public Usuario getUser(String nome, String senha){
        Usuario user = null;
        boolean deuCerto = false;
        int i = 0;
        while(i<qtdUsuarios && !deuCerto){
            if(usuarios[i].getNome().equals(nome) && usuarios[i].getSenha().equals(md5(senha))){
                deuCerto = true;
                user = usuarios[i];
            }
            i++;
        }
        return user;
    }

    /**
     * converte senha em md5
     * @param input senha
     * @return senha convertida
     */
    public String md5 (String input){
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================================\n");
        sb.append("Usuarios cadastrados.\n");
        for(int i=0; i<qtdUsuarios;i++){
            sb.append(usuarios[i].toString());
        }
        sb.append("==================================\n");
        return sb.toString();
    }
}
