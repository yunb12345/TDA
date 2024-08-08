package miercoles.grafos;

public class NodeG {

    class NodeGrafo{
        int nodo;
        NodeArista arista;
        NodeGrafo sigNodo;
    }

    class NodeArista{
        int etiqueta;
        NodeGrafo nodoDestino;
        NodeArista sigArista;
    }
}
