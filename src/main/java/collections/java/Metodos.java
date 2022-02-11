package collections.java;

public class Metodos {
    
    /*
    Passagem de parâmetro por valor (cópia):
    int i = 10;
    
    //método que receberá a passagem de parâmetro por cópia
    public void fazerAlgo(int i){
        //note que no parâmetro eu criei uma cópia da variável i
        //indicada pelo int. Por isso eu não modifico o valor
        //do i original, apenas a da cópia dentro do escopo/corpo do método.
        //fora dele não houve alteração alguma em i.
        i = i+10;
        System.out.println("O valor de i é "+i); //imprimirá 20
    }
    System.out.println("O valor de i é "+i);//imprimirá 10;
    */
    
    public static void main(String[] args) {
        System.out.println(f(9,3));
        
        
    }
    
    public static int f(int x, int y){
        if(y==0){
            return x;
        } else {
            return f(y, x%y);
        }
    }
}
