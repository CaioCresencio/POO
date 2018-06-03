import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        Jogo j;
        ArrayList <Jogo> jogos = new ArrayList<>();
        int escolha;
        do{
            escolha = entrada.nextInt();
            j = new Jogo();
            if(escolha>0) {
                for (int i = 0; i < escolha; i++) {
                    String nome = entrada.next();
                    int numero = entrada.nextInt();
                    j.addGrupinho(new Pirralho(nome, numero));
                }
                jogos.add(j);
            }

        }while(escolha!=0);
        while(!jogos.isEmpty()){
            System.out.println("Vencedor(a): "+jogos.remove(0).jogar().getNome());
        }
    }

}
class Pirralho {
    private String nome;
    private int ficha;

    public Pirralho(String nome, int ficha) {
        this.nome = nome;
        this.ficha = ficha;
    }

    public String getNome() {
        return nome;
    }

    public int getFicha() {
        return ficha;
    }
}
class Jogo{
    private ArrayList<Pirralho> grupinho;

    public Jogo(){
        this.grupinho = new ArrayList<>();
    }

    public boolean addGrupinho(Pirralho p){
        return grupinho.add(p);
    }

    public Pirralho removeEmOrdemGrupinho(){
        return grupinho.remove(0);
    }
    public int getSize(){
        return grupinho.size();
    }

    public Pirralho removeGrupinho(int i){
        return grupinho.remove(i);
    }

    public boolean isImpar(int i){
        return i%2!=0?true:false;
    }

    public int getProximo(Pirralho p,int posicao){
        int ficha = p.getFicha();
        int retorno =-1;
        if(isImpar(ficha)){
            for(int i=0, j= posicao;i<ficha;i++,j++){
                if(j==grupinho.size()){
                    j=0;
                }
                retorno=j;
            }
        }else{
            for(int i=0,j=posicao-1;i<ficha;i++,j--){
                if(j<=-1){
                    j=getSize()-1;
                }
                retorno=j;
            }
        }
        return retorno;
    }
    public Pirralho jogar(){
        Pirralho caminhante = grupinho.get(0);
        int posicao =0;
        int rodadas =0;
        Pirralho ganhador = null;
        while(!grupinho.isEmpty()){
            if(grupinho.size()>1){
                if(rodadas == 0){
                    if(isImpar(caminhante.getFicha())) {
                        posicao = getProximo(caminhante, 1);
                    }else{
                        posicao = getProximo(caminhante, -1);
                    }
                    caminhante = grupinho.get(posicao);
                }else {
                    removeGrupinho(posicao);
                    posicao = getProximo(caminhante, posicao);
                    caminhante = grupinho.get(posicao);
                }
            }else{
                ganhador = removeEmOrdemGrupinho();
            }
            rodadas++;
        }
        return ganhador;
    }
}
