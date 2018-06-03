package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BancoRegistro {
    private List<Registro> banco;

    public BancoRegistro(){
        /**
         *  só trocar o tipo de List que pretende usar
         */
        this.banco = new ArrayList<>();
        carregaBanco();
    }

    /**
     * carrega os arquivos do csv para a memoria
     */
    private void carregaBanco(){
        String csvArquivo = "registro.csv";
        BufferedReader conteudo = null;
        String linha ="";
        String campoSeparador =";";

        try{
            conteudo = new BufferedReader(new FileReader(csvArquivo));
            boolean ignoraPrimeiraLinha = false;

            while((linha = conteudo.readLine()) != null){
                if(ignoraPrimeiraLinha) {
                    String[] dados = linha.replaceAll("\"", "").split(campoSeparador);
                    Registro r;
                    int campo1 = Integer.parseInt(dados[0]);
                    String campo2 = dados[1];
                    String campo3 = dados[2];
                    String campo4 = dados[3];
                    String campo5 = dados[4];
                    int campo6 = Integer.parseInt(dados[5]);
                    r = new Registro(campo1,campo2,campo3,campo4,campo5,campo6);
                    this.addRegistro(r);
                 }else{
                    ignoraPrimeiraLinha = true;
                }

            }
        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado"+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * adiciona um registro
     * @param r
     * @return true caso de certo e false caso não.
     */
    public boolean addRegistro(Registro r){
        return banco.add(r);
    }

    /**
     * pega a quantidade de registro no banco.
     * @return
     */
    public int getQtdBanco(){
        return banco.size();
    }
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<banco.size();i++){
            sb.append(banco.get(i).getMunicipio());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * busca a quantidade de alunos por cidade
     * @param dado
     * @return
     */
    public int buscaQtdAlunosCidade(String dado){
        int qtd = 0;
        for (Registro r: banco ) {
            if(r.getMunicipio().equals(dado)){
                qtd+=r.getQtdAlunos();
            }
        }
        return qtd;
    }

    /**
     * bisca a quantidade de alunos por  estado.
     * @param dado
     * @return
     */
    public String buscaQtdAlunosEstado(String dado){
        int creche =0, pre=0,ensinoF =0,ensinoM=0,eja=0,aee =0,indigena=0;
        StringBuilder sb = new StringBuilder();
        sb.append("Resultado:\n");
        for(Registro r: banco){
            if(r.getEstado().equals(dado)){
                switch(r.getEtapa()){
                    case "CRECHE":
                        creche+=r.getQtdAlunos();
                        break;
                    case "PRÉ-ESCOLA":
                        pre+=r.getQtdAlunos();
                        break;
                    case "ENSINO FUNDAMENTAL":
                        ensinoF+=r.getQtdAlunos();
                        break;
                    case "ENSINO MÉDIO":
                        ensinoM+=r.getQtdAlunos();
                        break;
                    case "EDUCAÇÃO DE JOVENS E ADULTOS (EJA)":
                        eja+=r.getQtdAlunos();
                        break;
                    case "ATENDIMENTO EDUCACIONAL ESPECIALIZADO (AEE)":
                        aee+=r.getQtdAlunos();
                        break;
                    case "INDÍGENA":
                        indigena+=r.getQtdAlunos();
                        break;
                }

            }
        }
        sb.append("Creche: ");
        sb.append(creche);
        sb.append("\n");
        sb.append("Pré-Escola: ");
        sb.append(pre);
        sb.append("\n");
        sb.append("Ensino Fundamental: ");
        sb.append(ensinoF);
        sb.append("\n");
        sb.append("Ensino Médio: ");
        sb.append(ensinoM);
        sb.append("\n");
        sb.append("EJA: ");
        sb.append(eja);
        sb.append("\n");
        sb.append("AEE: ");
        sb.append(aee);
        sb.append("\n");
        sb.append("Indígena: ");
        sb.append(indigena);
        sb.append("\n");
        return sb.toString();
    }

    /**
     * busca a quantidade de alunos por modalidade.
     * @param dado
     * @return
     */
    public int buscaQtdAlunosModalidade(String dado){
        int qtd =0;
        for(Registro r: banco){
            if(r.getEtapa().equals(dado)){
                qtd += r.getQtdAlunos();
            }
        }
        return qtd;
    }
}
