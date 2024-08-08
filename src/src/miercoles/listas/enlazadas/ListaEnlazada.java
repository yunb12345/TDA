package miercoles.listas.enlazadas;

import miercoles.arboles.ArbolBB;

public class ListaEnlazada {
    Node first;
    Node2 first2; //para profundidad

    public ListaEnlazada(){
        this.first = new Node();
    }

    public void Agregar(int value){
        Node nuevo = new Node();
        nuevo.setValue(value);

        Node pivote = new Node();
        pivote = this.first;

        while(pivote.getNext() !=null){
            pivote = pivote.getNext();
        }
        pivote.setNext(nuevo);
    }

    //Para lo de profundidad, añadir valor+profundidad
    public void Agregarv2(ArbolBB value, int prof){
        Node2 nuevo = new Node2();
        nuevo.setValue(value,prof);

        Node2 pivote = new Node2();
        pivote = this.first2;

        while(pivote.getNext() !=null){
            pivote = pivote.getNext();
        }
        pivote.setNext(nuevo);
    }

    public void Eliminar(int value){
        Node prev;
        Node pivote;
        prev = this.first;

        pivote = prev.getNext();
        while (pivote != null && pivote.getValue() != value){
            prev = pivote;
            pivote = prev.getNext();
        }
    }

    public Node Existe(int value){
        Node pivote;
        pivote = first.getNext();

        while (pivote !=null){
            if (pivote.getValue() == value){
                return pivote;
            }
            pivote = pivote.getNext();
        }
        return null;
    }

    public String toString(){
        Node pivote;
        String out = "";
        pivote = first.getNext();
        while (pivote !=null){
            out = out + "" + pivote.getValue();
            pivote = pivote.getNext();
        }
        return out;
    }
}
