package projeto.campo.minado.modelos;


public class CampoTeste {
    private Campo campo = new Campo(3,3);
    
    void testeVizinhoRealDistancia1(){
        Campo vizinho = new Campo(3,2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        
    }
}
