package design.pattners.singleton;

//Singleton "apressado": ele instancia ele mesmo sem
//verificar se já existe uma instancia criada.
public class SingletonEager {
    private static SingletonEager instancia = new SingletonEager();
    
    //construtor privado para impedir instanciação fora dessa classe
    private SingletonEager(){
        super();
    }
    
    //Liberando a instancia dele mesmo para o público
    public static SingletonEager getInstancia(){
        return instancia;
    }
}
