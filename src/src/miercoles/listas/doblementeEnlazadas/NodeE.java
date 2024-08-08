package miercoles.listas.doblementeEnlazadas;

public class NodeE {
    private int value;
    private NodeE next;
    private NodeE prev;

    public NodeE(){
        this.next = null;
    }

    public int getValue(){
        return value;
    }

    public NodeE getNext(){
        return this.next = next;
    }

    public NodeE getPrev(){
        return this.prev = prev;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(NodeE next) {
        this.next = next;
    }

    public void setPrev(NodeE prev){
        this.prev = prev;
    }
}
