package projeto.campo.minado;

import projeto.campo.minado.modelos.Tabuleiro;

public class Aplicativo {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
        System.out.println(tabuleiro);
    }
}
