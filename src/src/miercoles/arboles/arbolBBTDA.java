package miercoles.arboles;

public interface arbolBBTDA {
    public void InicializarArbol();
    public int Raiz();
    public arbolBBTDA HijoIzquierdo();
    public arbolBBTDA hijoDerecho();
    public boolean ArbolVacio();
    public void Agregar(int x);
    public void Eliminar(int x);
}
