package model;

public class Emprestimo {
    private Usuario user;
    private Livro livro;

    public Emprestimo(Usuario user, Livro livro) {
       this.livro = livro;
       this.user = user;
    }

    /**retorna o usuario
     *
     * @return
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * retorna o livro
     * @return
     */
    public Livro getLivro() {
        return livro;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Livro: ");
        sb.append(this.livro.getTitulo());
        sb.append("\nExemplar: ");
        sb.append(livro.getExemplar());
        sb.append("\nUsuario: ");
        sb.append(this.user.getNome());
        sb.append("\n---------------------\n");
        return sb.toString();
    }
}
