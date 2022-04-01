package collections.java;

import java.util.Objects;

//Entendendo o Equals e HashCode
public class EqualsEHashCode {
	public static void main(String[] args) {
		Usuario u1 = new Usuario("Pedro A", "pedro@gmail.com", "1");
		Usuario u3 = new Usuario("Pedro A", "pedro@gmail.com", "1");
		Usuario u2 = new Usuario("Anderson L", "anderson@gmail.com", "2");

		System.out.println(u1 == u3);
		// Sem implementar antes o Equals = false
		System.out.println(u1.equals(u3));

	}
}

class Usuario {
	String nome;
	String email;
	String id;

	public Usuario(final String nome, final String email, final String id) {
		this.nome = nome;
		this.email = email;
		this.id = id;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Usuario))
			return false;
		final Usuario usuario = (Usuario) o;
		return this.nome.equals(usuario.nome) && this.email.equals(usuario.email) && this.id.equals(usuario.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.nome, this.email, this.id);
	}
}
