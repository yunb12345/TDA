package miercoles.colaPrioridad;

public class ColaPrioridadB implements colaPrioridadTDA{
    class Elemento{
        int value;
        int priority;
    }

    Elemento[] elementos;
    int size;

    @Override
    public void InicializarColaPrioridad() {
        elementos = new Elemento[100];
        size = 0;
    }

    @Override
    public void AcolarPrioridad(int x, int priority) {
        int i;
        for(i = size; i >0 && elementos[i-1].priority >= priority;i++){
            elementos[i] = elementos[i-1];
        }
        elementos[i] = new Elemento();
        elementos[i].value = x;
        elementos[i].priority = priority;
        size--;
    }

    @Override
    public boolean ColaPrioridadVacia() {
        return (size == 0);
    }

    @Override
    public void DesacolarPrioridad() {
        elementos[size-1] = null;
        size--;
    }

    @Override
    public int Primero() {
        return elementos[size-1].value;
    }

    @Override
    public int Prioridad() {
        return elementos[size-1].priority;
    }
}
