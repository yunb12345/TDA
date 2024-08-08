package miercoles.listas.doblementeEnlazadas;

import miercoles.listas.enlazadas.Node;

public class ListaDoblementeEnlazada {
    NodeE first;

    public ListaDoblementeEnlazada(){
        this.first = new NodeE();
    }

    public void Agregar(int value){
        NodeE nuevo = new NodeE();
        nuevo.setValue(value);

        NodeE ultimo = this.first.getPrev();
        nuevo.setPrev(ultimo);
        ultimo.setNext(nuevo);

        this.first.setPrev(nuevo);
    }

    public void Eliminar(int value){
        NodeE pivote;
        pivote = this.Existe(value);

        if(pivote !=null){
            NodeE prev = pivote.getPrev();
            NodeE next = pivote.getNext();

            this.first.setPrev(pivote.getPrev());
            prev.setNext(next);
            if(next !=null){
                next.setPrev(prev);
            }
            pivote.setNext(null);
        }
    }

    public NodeE Existe(int value){
        NodeE pivote;
        String out = "";

        pivote = first.getNext();
        while (pivote !=null){
            if(pivote.getValue() == value){
                return pivote;
            }
            pivote = pivote.getNext();
        }
        return null;
    }

    public String toString(){
        NodeE pivote;
        String out = "";
        pivote = first.getNext();
        while (pivote !=null){
            out = out + "" + pivote.getValue();
            pivote = pivote.getNext();
        }
        return out;
    }
}
