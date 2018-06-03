package View;

import Model.BancoRegistro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscaQtdAlunos {
    private JPanel painel1;
    private JTextField entrada;
    private JButton buscar;
    private JLabel titulo;
    private JLabel qtdAlunos;
    private JComboBox comboBox;

    public BuscaQtdAlunos(BancoRegistro bancoRegistro){

        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(comboBox.getSelectedIndex() ==0){
                    qtdAlunos.setText("Quantidade por cidade :"+bancoRegistro.buscaQtdAlunosCidade(entrada.getText()));
                }else{
                    if(comboBox.getSelectedIndex() ==1){
                        //qtdAlunos.setText("Quantidade por estado: "+bancoRegistro.buscaQtdAlunosEstado(entrada.getText()));
                        JOptionPane.showMessageDialog(null,bancoRegistro.buscaQtdAlunosEstado(entrada.getText()));
                    }else{
                        qtdAlunos.setText("Quantidade por modalidade: "+bancoRegistro.buscaQtdAlunosModalidade(entrada.getText()));
                    }
                }
            }
        });
    }
    public JPanel getPainel(){
        return painel1;
    }

}
