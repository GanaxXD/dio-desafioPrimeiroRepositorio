package design.pattners.singleton;

//Neste exemplo eu criarei um singleton "preguisoço",
// que não  fornece suas funcionalidades para o usuário
public class SingletonLazy {

    private static SingletonLazy instancia;
    
    //Para garantir que ninguem vai instanciar essa
    //classe, construtor private
    private SingletonLazy(){
        super();
    }
    
    //Liberando acesso às classes da instância desse singleton:
    //método público, porém, static, isto é, só a classe pode chamá-lo
    public static SingletonLazy getInstancia(){
        //Só instancio se não houver nenhuma instancia dele
        if(instancia == null){
            instancia = new SingletonLazy();
        }
        return instancia;
    }
}
