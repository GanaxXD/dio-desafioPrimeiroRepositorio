package collections.java;

import projeto.campo.minado.modelos.Campo;

//Tente exibir o valor de a sem modificar a linha de sua atribuição
public class PrimeiroTrauma {
    //Essa é uma variável da instancia, logo, para acessá-lo,
    //é necessário fazer uma instância dentro de um método static.
    //Lembre-se, um método static de uma classe só acessa métodos e dados
    //static de uma classe
    int a = 3; //NÃO PODE MEXER AQUI
    char b;
    
    //Por ser static, este método só tem acesso a métodos
    //statics. Uma outra forma é tornar o a um atributo static:
    //static int a = 3;
    //Dessa forma, não se precisa instanciar um objeto da classe
    public static void main(String[] args) {
        //Pode mexer em qualquer coisa dentro do main
        // para exibir o valor de a;
        PrimeiroTrauma p = new PrimeiroTrauma();
        System.out.println(p.a);
        //Se o a fosse static, a resposta seria apenas:
        //System.out.println(a);
    
        
    }
}
