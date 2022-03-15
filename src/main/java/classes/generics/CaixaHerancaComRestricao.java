package classes.generics;

//Perceba que eu agora estou definindo uma restrição:
//Eu aceito um generico mas somente do tipo
//Number (Integer ou Double), como no exemplo abaixo.
//Perceba que o tipo da CaixaHerançaComRestrição é do tipo
//N, que extende apenas da classe Number, e esse tipo N foi passado
//para a classe pai Caixa, que no fim, aceitará qualquer Integer, Long, Double ou Short
public class CaixaHerancaComRestricao<N extends Number> extends Caixa<N>{
}
