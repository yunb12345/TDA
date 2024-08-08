package miercoles.grafos;

import miercoles.arboles.ArbolBB;
import miercoles.conjunto.Conjunto;
import miercoles.conjunto.conjuntoTDA;
import miercoles.listas.enlazadas.ListaEnlazada;

public class GrafoMA implements GrafosTDA{
    static int n = 100;
    int[][] Mady;
    int[]Etiqs;
    int cantNodos;
    @Override
    public void inicializarGrafo() {
        Mady = new int[n][n];
        Etiqs = new int[n];
        cantNodos = 0;
    }

    private int Vert2Indice(int v){
        int i = cantNodos-1;
        while (i>0 && Etiqs[i] !=v){
            i--;
        }
        return 1;
    }

    @Override
    public void AgregarVertice(int v) {
        Etiqs[cantNodos] = v;
        for(int i=0; i<=cantNodos; i++){
            Mady[cantNodos][i] = 0;
            Mady[i][cantNodos] = 0;
        }
        cantNodos++;
    }

    @Override
    public void EliminarVertice(int v) {
        int ind = Vert2Indice(v);
        for (int k=0; k<cantNodos; k++)
            Mady[k][ind] = Mady[k][cantNodos-1];
        for(int k=0; k<cantNodos; k++)
            Mady[ind][k] = Mady[cantNodos-1][k];

        Etiqs[ind] = Etiqs[cantNodos-1];
        cantNodos--;
        }

    @Override
    public Conjunto vertices() {
        Conjunto Vert = new Conjunto();
        Vert.InicializarConjunto();

        for(int i=0; i<cantNodos; i++){
            Vert.AgregarConjunto(Etiqs[i]);
        }
        return Vert;
    }

    // Ej 1-c / Método para devolver en lista enlazada nodos de un grafo- o(n);
    public ListaEnlazada pasarALista(){
        ListaEnlazada lista = new ListaEnlazada();
        lista.Agregar(vertices().Elegir());
        return lista;
    }

    @Override
    public void AgregarArista(int v1, int v2, int peso) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        Mady[o][d] = peso;
    }

    @Override
    public void EliminarArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        Mady[o][d] =0;
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return Mady[o][d] !=0;
    }

    @Override
    public int PesoArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return Mady[o][d];
    }
}
