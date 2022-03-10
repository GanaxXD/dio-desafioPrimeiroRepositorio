package projeto.campo.minado;

import projeto.campo.minado.modelos.Tabuleiro;
import projeto.campo.minado.visao.TabuleiroConsole;

public class Aplicativo {
    public static void main(String[] args) {
        //Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
        new TabuleiroConsole(new Tabuleiro(6,6,6));
    }
}
