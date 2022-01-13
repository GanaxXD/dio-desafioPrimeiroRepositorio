package estrutura.de.dados;

import java.util.Objects;

public class Carro implements Comparable<Carro>{

    String marca;

    public Carro(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //Método assinado pela interface Comparable
    @Override
    public int compareTo(Carro o) {
        //Você quem implementa a comparação.
        //comparação 1: tamanho em letras:

        if(this.marca.length() < o.marca.length()){
            return -1;
        } else if (this.marca.length() > o.marca.length()){
            return 1;
        }
        //Se forem iguais 9tem o mesmo número de letras)
        return 0;
    }

    //Verifica se o objeto testado é igual a este.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro that = (Carro) o;
        return Objects.equals(marca, that.marca);
    }

    //Facilita a organização dos dados nas estruturas de dados
    @Override
    public int hashCode() {
        return Objects.hash(marca);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                '}';
    }
}
