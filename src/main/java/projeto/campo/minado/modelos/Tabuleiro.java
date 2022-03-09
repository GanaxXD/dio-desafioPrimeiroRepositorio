package projeto.campo.minado.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//Conjunto de campos que formam o tabuleiro do jogo
public class Tabuleiro {
    
    private int linhas;
    private int colunas;
    private int minas;
    
    private final List<Campo> campos = new ArrayList<>();
    
    public Tabuleiro(final int linhas, final int colunas, final int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;
        
        //Iniciando o tabuleiro
        gerarCampos();
        associarOsVizinhos();
        sortearMinas();
    }
    
    public void abrir(int linha, int coluna){
        campos.parallelStream()
                .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                .findFirst()
                .ifPresent(c -> c.abrir());
    }
    
    public void alterarMarcacao(int linha, int coluna){
        campos.parallelStream()
                .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                .findFirst()
                .ifPresent(c -> c.alternarMarcacao());
    }
    
    private void gerarCampos() {
        for (int linha = 0; linha < linhas; linha++){
            for (int coluna = 0; coluna < colunas; coluna++){
                campos.add(new Campo(linha,coluna));
            }
        }
    }
    private void associarOsVizinhos() {
        for (Campo c1 : campos){
            for (Campo c2 : campos){
                c1.adicionarVizinho(c2);
            }
        }
    }
    private void sortearMinas() {
        long minasArmadas = 0;
        Predicate<Campo> minado = m -> m.isMinado();
        do{
            minasArmadas = campos.stream().filter(minado).count();
            int aleatorio = (int)(Math.random() * campos.size());
            campos.get(aleatorio).minar();
        } while(minasArmadas < minas);
    }
    
    //Verificando se o jogador venceu
    public boolean objetivoAlcancado(){
        return campos.stream().allMatch(c->c.objetivoAlcansado());
    }
    
    public void reiniciar(){
        campos.stream().forEach(c -> c.reiniciar());
        sortearMinas();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        for (int l = 0; l <linhas; l++){
            for (int c = 0; c < colunas; c++){
                sb.append(" ");
                sb.append(campos.get(i));
                sb.append(" ");
                i++;
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
