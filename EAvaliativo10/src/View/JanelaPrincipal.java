package View;

import Model.BancoRegistro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class JanelaPrincipal extends JFrame implements ActionListener {

    private JMenuBar bar;
    private JMenu menuArquivo;
    private JMenuItem itemBusca1;
    private JMenuItem sair;
    private JDesktopPane desktop;
    private JTabbedPane pane;
    private BancoRegistro b;




    public JanelaPrincipal(String titulo, BancoRegistro bancoRegistro) {
        super(titulo);
        b = bancoRegistro;
        criarComponentes();
        ajustarPropriedadesJanela();

    }

    private void criarComponentes() {
        desktop = new JDesktopPane();
        pane = new JTabbedPane();
        add(pane);
        bar = new JMenuBar();
        menuArquivo = new JMenu("Opções");
        itemBusca1= new JMenuItem("Busca de quantidade");
        itemBusca1.addActionListener(this);

        sair = new JMenuItem("Sair");
        sair.addActionListener(this);

        menuArquivo.add(itemBusca1);

        menuArquivo.addSeparator();
        menuArquivo.add(sair);


        bar.add(menuArquivo);
        setJMenuBar(bar);
        add(desktop);

    }

    private void ajustarPropriedadesJanela() {
        setVisible(true);
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addDesktop(JPanel janela){
        desktop.add(janela);
        desktop.moveToFront(janela);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == itemBusca1 ){

            JFrame buscaQtdAlunos = new JFrame("Retirar Senha");
            buscaQtdAlunos.setContentPane(new BuscaQtdAlunos(b).getPainel());
            buscaQtdAlunos.setLocationRelativeTo(null);
            buscaQtdAlunos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            buscaQtdAlunos.setSize(400,300);
            buscaQtdAlunos.setVisible(true);
        }else{
            dispose();
        }
    }
}
