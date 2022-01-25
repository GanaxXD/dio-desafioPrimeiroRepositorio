package exceptions.customizadas;

//Basta criar uma classe qualquer estendendo da Exception
//O construtor quem será exibido nos erros
public class ExceptionCustomizada extends Exception{
    private String mensagem;
    
    //Como herda de Exception, existem diversos tipos de construtor.
    public ExceptionCustomizada(final String message, final String mensagem) {
        super(message);
        this.mensagem = mensagem;
    }
    
    @Override
    public String toString() {
        return "ExceptionCustomizada{" +
                "mensagem='" + mensagem + '\'' +
                '}';
    }
    
    public String getMensagem() {
        return this.mensagem;
    }
    
    public void setMensagem(final String mensagem) {
        this.mensagem = mensagem;
    }
}
