package View;

import Model.BancoRegistro;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BancoRegistro banco = new BancoRegistro();
        JanelaPrincipal janela = new JanelaPrincipal("CSV",banco);

    }
}
