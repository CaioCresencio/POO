package model;

public class Livro {
    private String nomeAutor;
    private String titulo;
    private String subTitulo;
    private String editora;
    private int exemplar;
    private String isbn;


    public Livro(String nomeAutor, String titulo, String subTitulo, String editora,String isbn,int exemplar) {
        this.nomeAutor = nomeAutor;
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.editora = editora;
        this.exemplar = exemplar;
        setIsbn(exemplar,isbn);

    }

    /**
     * confere se o numero de exemplares passado é valido, caso não for seta os array com 1
     * @param
     */
    /**
     * adiciona o contador no isbn
     * @param exemplar o exemplar
     * @param isbn  numero do isbn
     */
    private void setIsbn(int exemplar,String isbn){
        this.isbn =  isbn +"-"+isbn;
    }


    /**
     * pega o nome do autor do livro
     * @return
     */
    public String getNomeAutor() {
        return nomeAutor;
    }

    /**
     * pega o titulo do livro
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * pega o subtitulo do livro
     * @return
     */
    public String getSubTitulo() {
        return subTitulo;
    }

    /**
     * pega a editora do livro
     * @return
     */
    public String getEditora() {
        return editora;
    }

    /**
     * pega o exemplar do livro
     * @return
     */
    public int getExemplar(){
        return exemplar;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Titulo do livro:");
        sb.append(getTitulo());
        sb.append("\nSubtitulo: ");
        sb.append(getSubTitulo());
        sb.append("\nAutor: ");
        sb.append(getNomeAutor());
        sb.append("\nEditora: ");
        sb.append(getEditora());
        sb.append("\nExemplar: ");
        sb.append(getExemplar());
        return sb.toString();
    }


}
