package orientacao.objetos;

//Classe abstrata:
//Não faz sentido que uma conta seja instanciada sem ser
//poupança ou corrente, evitando que uma conta
//sem tipo seja criado.
public abstract class Conta {
    //quando estático, o atributo faz referência à classe, e não
    //à instancia (objeto). Desta forma, este atributo
    //Ficará sempre aumentando, e não voltando ao valor 0
    //como seria se o atributo não fosse static.
    private static int SEQUENCIAL = 0;
    private static int AGENCIA_PADRAO = 1576;
    
    private int agencia;
    protected int numero;
    protected double saldo;
    
    public Conta(){
        this.agencia = AGENCIA_PADRAO;
        this.numero = ++SEQUENCIAL;
    }
    
    public void sacar(double valor){
        this.saldo -= valor;
    }
    public void depositar(double valor){
        this.saldo += valor;
    }
    public void transferir(double valor,Conta destinatario){
        this.sacar(valor);
        destinatario.depositar(valor);
    }
    
    //Não é prudente deixar que sejam alterados os atributos
    //da agencia e número da conta por fora da classe, por isso,
    //não criaremos os sets dos mesmos
    public int getAgencia() {
        return this.agencia;
    }
    
    public String imprimirExtrato(){
        return "Conta: \n\tAgencia: "+this.agencia+"\n" +
                "\tConta: "+this.numero+"\n" +
                "\tSaldo: "+this.saldo+"\n---------\n";
    }
}
