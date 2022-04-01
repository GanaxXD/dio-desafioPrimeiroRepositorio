package classes.generics;

import java.util.Objects;

public class GenericComChaveValor<C, V> {
	private C chave;
	private V valor;

	public GenericComChaveValor() {
	}

	public GenericComChaveValor(final C chave, final V valor) {
		this.chave = chave;
		this.valor = valor;
	}

	public C getChave() {
		return this.chave;
	}

	public void setChave(final C chave) {
		this.chave = chave;
	}

	public V getValor() {
		return this.valor;
	}

	public void setValor(final V valor) {
		this.valor = valor;
	}

	// Para comparação, neste exemplo, usaremos apenas a chave

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof GenericComChaveValor))
			return false;
		final GenericComChaveValor<?, ?> that = (GenericComChaveValor<?, ?>) o;
		return Objects.equals(this.getChave(), that.getChave());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getChave());
	}
}
