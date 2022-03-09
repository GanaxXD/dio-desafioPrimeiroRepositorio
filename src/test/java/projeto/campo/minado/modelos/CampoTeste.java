package projeto.campo.minado.modelos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projeto.campo.minado.excecoes.ExplosaoException;

import static org.junit.jupiter.api.Assertions.*;

public class CampoTeste {
    private Campo campo = new Campo(3,3);
    
    @Test
    @DisplayName("Verifica se o vizinho foi inserido com sucesso")
    void testeVizinhoRealDistancia1(){
        Campo vizinho = new Campo(3,2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
    
    @Test
    @DisplayName("Testando se o padrão do atributo 'marcado' é false")
    void testeValorPadraoAtributoMarcado(){
        assertFalse(campo.isMarcado());
    }
    
    @Test
    @DisplayName("Testando a alteração de marcação no campo")
    void testeAlternarMarcacao(){
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }
    
    @Test
    @DisplayName("Testando a alteração de marcação pela 2 vez")
    void testeAlternarMarcacaoSegundaChamada(){
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }
    
    @Test
    @DisplayName("Testando abertura de campo não marcado e não minado")
    void testeAbrirCampoNãoMarcadoNãoMinado(){
        assertTrue(campo.abrir());
    }
    
    @Test
    @DisplayName("Testando abertura de campo marcado e não minado")
    void testeAbrirCampoMarcadoNãoMinado(){
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }
    
    @Test
    @DisplayName("Testando abertura de campo marcado e minado")
    void testeAbrirCampoMarcadoMinado(){
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }
    
    @Test
    @DisplayName("Testando abertura de campo minado com explosão")
    void testeAbrirCampoNãoMarcadoMinado(){
        campo.minar();
        assertThrows(ExplosaoException.class, ()-> {
            campo.abrir();
        });
    }
    
    @Test
    @DisplayName("Testando abertura de vizinhos seguros de um campo")
    void testeAbrirComVizinhos(){
        Campo campo11 = new Campo (1,1);
        Campo campo22 = new Campo (2,2);
        
        campo22.adicionarVizinho(campo11);
        
        campo.abrir();
        assertTrue(campo22.isAberto() && campo11.isAberto());
    }
    
    @Test
    @DisplayName("Testando abertura de vizinhos com mina de um campo")
    void testeAbrirComVizinhosMinados(){
        Campo campo11 = new Campo (1,1);
        Campo campo12 = new Campo(1,1);
        campo12.minar();
        
        Campo campo22 = new Campo (2,2);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);
        
        campo.adicionarVizinho(campo22);
        campo.abrir();
        assertTrue(campo22.isAberto() && campo11.isFechado());
    }
    
}
