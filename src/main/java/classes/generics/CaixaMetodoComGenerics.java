package classes.generics;

import java.util.List;

public class CaixaMetodoComGenerics {
    /*
    ** Generics nos métodos.
    * Posso criar métodos estáticos (apenas acessados pela própria classe)
    * contendo funções que eu julgue importantes e recorrentes.
    * Neste exemplo, podemos perceber que o Generics
    * pode ser usado nos métodos.
    * Nesse primeiro exemplo, especifiquei que o método
    * retorna o tipo object
    * Mas no segundo, eu posso inserir o tipo generico, definido
    * apenas na chamada da função, podendo assumir qualquer
    * tipo, ou tipo com restrições, como visto na classe
    * CaixaHerancaComRestricao.
     */
    public static Object getUltimo1(List<?> lista){
        return lista.get(lista.size() -1);
    }
    //Jogando a responsabilidade de definição do tipo
    //de retorno e de parâmetros para a chamada da função
    public static <T> T getUltimo2(List<T> lista){
        return lista.get(lista.size() -1);
    }
    
    public static <T extends Number> T getUltimo3(List<T> lista){
        return lista.get(lista.size() -1);
    }
}
