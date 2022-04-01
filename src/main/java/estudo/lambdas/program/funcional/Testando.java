package estudo.lambdas.program.funcional;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

//Testando os estudos de lambdas expressions
public class Testando {

	public static void main(String[] args) {
		Produto p = new Produto("Notebook", 4259.96, 0.15);

		// 1. calcule o preço total
		BinaryOperator<Double> precoTotal = (preco, desconto) -> preco * (1 - desconto);
		// 2. Imposto Municipal: >= 2500 (8,5%) | < 2500 (isento)
		UnaryOperator<Double> imposto = preco -> preco >= 2500.00 ? preco * (1 - 0.085) : preco;
		// 3. Frete: >= 3000 (100) | <3000 (50)
		UnaryOperator<Double> frete = preco -> preco >= 3000.00 ? preco + 100.0 : preco + 50.0;
		// 4. Arredondar: Deixar com 2 casas decimais
		UnaryOperator<Double> arredondar = preco -> Math.round(preco * 100.0) / 100.0;
		// 5. Formatar: R$1234,56

		System.out.println("R$" + precoTotal.andThen(imposto).andThen(frete).andThen(arredondar).apply(4259.96, 0.15)
				.toString().replace(".", ","));

	}

}
