package classes.generics;
/*
** O Generics serve para você criar uma classe que receberá
* parâmetros de um tipo específico, entretanto, de forma generalizada
* em uma classe.
* Isto significa que a classe poderá ter vários objetos
* com parâmetros de tipos distintos entre eles (os objetos da mesma classe),
* mas que internamente, receberam apenas valores do mesmo tipo instanciado.
* Por padrão, definimos o generic da classe com apenas
* uma letra maiúscula.
 */
public class Caixa<T> {
    
    //Neste caso, o tipo dos parâmetros
    //coisa devem ser definidos na instanciação,
    //caso contrário, todos serão do tipo OBJECT,
    //que pode trazer problemas de conversão no futuro
    //quando você precisar manipular esses dados
    private T coisa1;
    private T coisa2;
    
    //métodos de obter e guardar as coisas
    public void guardarCoisa1(T coisa){
        this.coisa1 = coisa;
    }
    public void guardarCoisa2(T coisa){
        this.coisa2 = coisa;
    }
    
    public void pegarCoisa1(T coisa){
        this.coisa1 = coisa;
    }
    public void pegarCoisa2(T coisa){
        this.coisa2 = coisa;
    }
    
    @Override
    public String toString() {
        return "Caixa{" +
                "coisa1=" + coisa1 +
                ", coisa2=" + coisa2 +
                '}';
    }
}
