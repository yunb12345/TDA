package miercoles.listas.enlazadas;

import miercoles.arboles.ArbolBB;

public class Node2 {
    private int value;
    private int prof;//para la profundidad
    private Node2 next;

    public Node2() {
        this.next = null;
    }

    public int getValue(){
        return value;
    }

    public Node2 getNext(){
        return next;
    }

    public int setValue(ArbolBB value, int prof){
        return this.value = this.value;
    }

    public Node2 setNext(Node2 nuevo){
        return this.next = next;
    }
}
