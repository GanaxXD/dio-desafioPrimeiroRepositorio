package collections.java;

import java.util.LinkedList;
import java.util.Queue;

public class ExemploQueue {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        
        fila.add("Paty");
        fila.add("Roberto");
        fila.add("Anderson");
        fila.add("Flávio");
        fila.add("Jamil");
        
        System.out.println(fila);
        
        
    }
}
