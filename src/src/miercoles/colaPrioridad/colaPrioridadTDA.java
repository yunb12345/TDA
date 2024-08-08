package miercoles.colaPrioridad;

public interface colaPrioridadTDA {
    public void InicializarColaPrioridad();
    public void AcolarPrioridad(int x, int priority);
    public boolean ColaPrioridadVacia();
    public void DesacolarPrioridad();
    public int Primero();
    public int Prioridad();
}
