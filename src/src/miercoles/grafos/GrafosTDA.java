package miercoles.grafos;

import miercoles.conjunto.Conjunto;

public interface GrafosTDA {
    public void inicializarGrafo();
    public void AgregarVertice(int v);
    public void EliminarVertice(int v);
    Conjunto vertices();
    public void AgregarArista(int v1, int v2, int peso);
    public void EliminarArista(int v1, int v2);
    public boolean ExisteArista(int v1, int v2);
    public int PesoArista(int v1, int v2);
}
