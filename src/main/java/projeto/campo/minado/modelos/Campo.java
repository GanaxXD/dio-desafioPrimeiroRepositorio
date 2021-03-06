package projeto.campo.minado.modelos;

import projeto.campo.minado.excecoes.ExplosaoException;

import java.util.ArrayList;
import java.util.List;

//Corresponde ao quadrado do jogo que pode ou não ter mina
public class Campo {
	// Posição do campo no tabuleiro (coordenadas)
	private final int linha;
	private final int coluna;

	// atributos que indicam o estado do campo
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado; // por padrão o boolean já é falso

	// indicando os campos vizinhos
	// A list é do tipo campo (auto relacionamento) do tipo 1:N
	private List<Campo> vizinhos = new ArrayList<>();

	// Quando não ponho nenhum modificador de acesso,
	// o método fica visível a nível de pacote.
	Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	// Função que indica se o campo foi ou não adicionado na lista de
	// vizinhos. Neste caso a distancia de um campo para outro quem
	// determina se ele poderá ser ou não vizinho.
	// Da mesma forma que o constructor, só poderá ser acessado de dentro do
	// pacote
	boolean adicionarVizinho(Campo vizinho) {

		// PASSO 1: verifica se o campo está na diagonal || mesma linha || mesma coluna
		// O campo candidato a vizinho pode estar na mesma linha,
		// na mesma coluna, ou na diagonal do campo alvo.
		// Ele sempre estará na diagonal se a linha e coluna forem
		// diferentes da linha e coluna do campo alvo.
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;

		// PASSO 2: verifico a distancia entre o vizinho e o campo:
		// somando (coluna - vizinho.coluna) + (linha - vizinho.linha).
		// O resultado do número ABSOLUTO:
		// Na mesma linha ou coluna: 1
		// Na diagonal: 2
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha; // distancia do campo com o vizinho

		if (deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else if (deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		}
		return false;
	}

	// Função para alternar se o campo está marcado ou não.
	// Não posso marcar campos abertos.
	void alternarMarcacao() {
		if (!aberto) {
			marcado = !marcado;
		}
	}

	// Função abrir campo.
	// Ao abrir, o campo poderá estar minado ou não.
	// Só posso abrir campos não abertos e não marcados
	boolean abrir() {
		if (!aberto && !marcado) {
			aberto = true;

			if (minado) {
				// Jogo acabou.
				throw new ExplosaoException();
			}

			if (vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}

			return true;
		} else {
			return false;
		}
	}

	// Função de expandir
	// Expansão de vizinhança segura
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}

	// Função que verifica se o campo foi marcado
	public boolean isMarcado() {
		return marcado;
	}

	// Por mina no campo
	void minar() {
		minado = true;
	}

	boolean objetivoAlcansado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}

	long minasNaVizinhanca() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}

	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
	}

	public boolean isAberto() {
		return aberto;
	}

	public boolean isMinado() {
		return minado;
	}

	void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public boolean isFechado() {
		return !isAberto();
	}

	public int getLinha() {
		return this.linha;
	}

	public int getColuna() {
		return this.coluna;
	}

	@Override
	public String toString() {
		if (marcado) {
			return "X";
		} else if (aberto && minado) {
			return "*"; // bomba
		} else if (aberto && minasNaVizinhanca() > 0) {
			return Long.toString(minasNaVizinhanca());
		} else if (aberto) {
			return " ";
		} else {
			return "?";
		}
	}
}
