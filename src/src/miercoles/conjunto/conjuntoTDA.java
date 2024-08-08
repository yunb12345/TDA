package miercoles.conjunto;

public interface conjuntoTDA {
    public void InicializarConjunto();
    public void AgregarConjunto(int x);
    public boolean ConjuntoVacio();
    public void SacarConjunto(int x);
    public int Elegir();
    public boolean Pertenece(int x);
}
