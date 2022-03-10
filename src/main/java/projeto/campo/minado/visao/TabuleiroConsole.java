package projeto.campo.minado.visao;

import projeto.campo.minado.excecoes.ExplosaoException;
import projeto.campo.minado.excecoes.SairException;
import projeto.campo.minado.modelos.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TabuleiroConsole {
    Scanner entrada = new Scanner(System.in);
    private Tabuleiro tabuleiro;
    public TabuleiroConsole(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        executarJogo();
    }
    
    private void executarJogo() {
        boolean continuar = true;
        try{
            
            while(continuar){
                
                cicloDoJogo();
                
                System.out.println("Deseja Jogar Outra Partida? (S/n): ");
                String resposta = entrada.nextLine();
                
                if("n".equalsIgnoreCase(resposta)){
                    continuar = false;
                } else {
                    tabuleiro.reiniciar();
                }
                
            }
            
        } catch (SairException e){
            System.out.println("Tchau!");
        } finally {
            entrada.close();
        }
    }
    
    private void cicloDoJogo() {
        try {
            while(!tabuleiro.objetivoAlcancado()){
                System.out.println(tabuleiro);
                
                String digitado = capturarValorDigitado("Diginte as coordenadas do campo que você quer abrir (x, y): ");
                
                Iterator<Integer> xy = Arrays.stream(digitado.split(","))
                        .map(s -> Integer.parseInt(s.trim()))
                        .iterator();
                
                digitado = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar: ");
                
                if("1".equals(digitado)){
                    tabuleiro.abrir(xy.next(), xy.next());
                } else if ("2".equals(digitado)){
                    tabuleiro.alterarMarcacao(xy.next(), xy.next());
                }
            }
            System.out.println(tabuleiro);
            System.out.println("Parabéns! Você venceu!!!");
        } catch (ExplosaoException e){
            System.out.println(tabuleiro);
            System.out.println("BOOM!!! \nVocê Pisou na Mina!");
        }
    }
    
    private String capturarValorDigitado(String texto){
        System.out.println(texto);
        String digitado = entrada.nextLine();
        
        if("sair".equalsIgnoreCase(digitado)){
            throw new SairException();
        }
        return digitado;
    }
    
}
