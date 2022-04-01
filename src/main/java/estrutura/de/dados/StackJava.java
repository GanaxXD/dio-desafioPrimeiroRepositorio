package estrutura.de.dados;

import java.util.Objects;

public class StackJava {
	// Pilha

	String marca;

	public StackJava(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	// Verifica se o objeto testado é igual a este.
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Carro that = (Carro) o;
		return Objects.equals(marca, that.marca);
	}

	// Facilita a organização dos dados nas estruturas de dados
	@Override
	public int hashCode() {
		return Objects.hash(marca);
	}

	@Override
	public String toString() {
		return "StackJava{" + "marca='" + marca + '\'' + '}';
	}
}
