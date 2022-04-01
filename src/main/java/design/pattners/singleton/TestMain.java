package design.pattners.singleton;

public class TestMain {
	public static void main(String[] args) {
		// Ocorre erro porque eu não posso instanciar
		// SingletonLazy lazy = new SingletonLazy();

		// Neste teste, o objeto retornado deve ser sempre o mesmo,
		// Isto é, seu endereço de memória deve ser o mesmo, até
		// se eu atribuir uma nova instancia para o Singleton
		// Ex:
		SingletonLazy lazy = SingletonLazy.getInstancia(); // recebendo a instancia da classe diretamente
		System.out.println(lazy); // endereço de memória;
		// tentando atribuindo "nova instancia"
		lazy = SingletonLazy.getInstancia();
		System.out.println(lazy); // endereço de memória;
		// Os endereços de memória devem ser iguais.
	}
}
