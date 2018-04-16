package model;

public class Biblioteca {
    private int qtdLvros;

    private static final int TAMANHO_L = 50;


    private Livro colecao[];



    public Biblioteca() {
        this.qtdLvros =0;

        this.colecao = new Livro[TAMANHO_L];

    }

    /**
     * cadastra um conjunto de livros ou apenas 1 livro na biblioteca.
     * @param nomeAutor
     * @param titulo
     * @param subTitulo
     * @param editora
     * @param isbn
     * @param qtdExemplares
     * @return true se deu certo e false se ocorreu algum problema
     */
    public boolean cadastraConjunto(String nomeAutor, String titulo, String subTitulo, String editora,String isbn,int qtdExemplares){
        boolean deuCerto = false;
        if(qtdExemplares>0 && qtdExemplares <= TAMANHO_L-qtdLvros) {
            int qtdExistente = qtdLvros+qtdExemplares;
            int exemplares = this.confereExistencia(titulo,subTitulo);
            for (;qtdLvros< qtdExistente;) {
                Livro livro;
                livro = new Livro(nomeAutor, titulo, subTitulo, editora, isbn, ++exemplares);
                colecao[qtdLvros] = livro;
                qtdLvros++;
                deuCerto = true;
            }
        }
        return deuCerto;
    }

    /**
     * confere a existencia de exemplares ja cadastrados
     * @param titulo
     * @param subtitulo
     * @return true se deu certo e false caso ocorra algum erro
     */
    public int confereExistencia(String titulo,String subtitulo){
        int contador = 0;
        for(int i=0;i<qtdLvros;i++){
            if(titulo.equals(colecao[i].getTitulo()) && subtitulo.equals(colecao[i].getSubTitulo())){
                contador++;
            }
        }
        return contador;
    }

    /**
     * faz uma busca de um livro na biblioteca
     * @param titulo
     * @param exemplar
     * @return null caso não encontre e um livro caso encontre
     */
    public Livro getLivro(String titulo, int exemplar){
        Livro livro = null;
        boolean deuCerto = false;
        int i = 0;
        while(i<qtdLvros && !deuCerto){
            if(colecao[i].getTitulo().equals(titulo) && colecao[i].getExemplar() == exemplar){
                deuCerto = true;
                livro = colecao[i];
            }
            i++;
        }
        return livro;
    }



    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<qtdLvros;i++){
            sb.append("Livro----------------------\n");
            sb.append(colecao[i].toString());
            sb.append("\n---------------------------\n");
        }
        return sb.toString();

    }
}
