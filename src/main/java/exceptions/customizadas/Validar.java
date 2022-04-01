package exceptions.customizadas;

public class Validar {
	// Impedindo a instanciação da classe
	private Validar() {
	}

	// Permitindo o uso do método somente pela classe
	// (Método estático0)
	public static void pessoa(Pessoa pessoa) {
		if (pessoa == null) {
			throw new IllegalArgumentException("Pessoa sem dados.");
		}
		if (pessoa.nome == null || pessoa.nome.trim().isEmpty()) {
			throw new StringVaziaException("nome");
		}

		if (pessoa.idade < 0 || pessoa.idade > 150) {
			throw new NumeroNegativoException("idade");
		}
	}
}
