package estudo.streams;


import java.util.Arrays;
import java.util.List;

import estudo.lambdas.program.funcional.Produto;

public class DesafioFilter {

	public static void main(String[] args) {
		Produto p1 = new Produto("Caneta", 2.50, 0);
		Produto p2 = new Produto("Caderno", 22.50, 0.015);
		Produto p3 = new Produto("Lancheira", 12.50, 0.2);
		Produto p4 = new Produto("Livro de Português", 42.50, 0.25);
		Produto p5 = new Produto("Livro de MAtemática", 62.50, 0.15);
		
		List<Produto> produtos = Arrays.asList(p1,p2,p3,p4,p5);
		
		//Pegar apenas produtos em promoção com valor de desconto acima de 10%
		produtos.stream()
			.filter(p-> p.getDesconto() > 0.1)
			.forEach(System.out::println);

	}

}
