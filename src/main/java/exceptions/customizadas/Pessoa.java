package exceptions.customizadas;

public class Pessoa {
    public String nome;
    public int idade;
    
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getNome() {
        return this.nome;
    }
    public int getIdade(){return this.idade;}
    
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    public void setIdade(final int idade) {
        this.idade = idade;
    }
}
