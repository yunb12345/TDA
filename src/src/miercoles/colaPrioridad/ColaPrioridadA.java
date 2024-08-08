package miercoles.colaPrioridad;

public class ColaPrioridadA implements colaPrioridadTDA{
    int[]values;
    int[]priorities;
    int size;
    @Override
    public void InicializarColaPrioridad() {
        values = new int[100];
        priorities = new int[100];
        size = 0;
    }

    @Override
    public void AcolarPrioridad(int x, int priority) {

    }

    @Override
    public boolean ColaPrioridadVacia() {
        return (size == 0);
    }

    @Override
    public void DesacolarPrioridad() {
        size--;
    }

    @Override
    public int Primero() {
        return values[size-1];
    }

    @Override
    public int Prioridad() {
        return priorities[size-1];
    }
}
