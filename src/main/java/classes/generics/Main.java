package classes.generics;

public class Main {
    public static void main(String[] args) {
        //Se eu não definir o tipo aqui, elas serão do tipo Object
        Caixa c1 = new Caixa();
        c1.guardarCoisa1(10);
        c1.guardarCoisa2("Ali");
        System.out.println(c1);
        
        //Mas eu posso criar outros Objetos definindo o tipo
        //que é o ideal para evitar problemas futuros de conversão de tipos de dados
        Caixa<String> c2 = new Caixa();
        //c2.guardarCoisa1(10); //aqui ocorre erro porque eu defini que os dados deveriam ser do tipo String
        c2.guardarCoisa2("Deu certo pra mim!");
        System.out.println(c2);
    
        Caixa<Integer> c3 = new Caixa<>();
        c3.guardarCoisa1(10);
        //c3.guardarCoisa2("Ali"); //aqui ocorre a mesma coisa que em c2.guardarCoisa
        System.out.println(c3);
    }
}
