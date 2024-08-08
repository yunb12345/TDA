package miercoles.pila;

public class Pila implements pilaTDA{
    int[] arr;
    int ind;
    @Override
    public void InicializarPila() {
        arr = new int[100];
        ind = 0;
    }

    @Override
    public void Apilar(int x) {
        arr[ind] = x;
        ind++;
    }

    @Override
    public boolean PilaVacia() {
        return (ind == 0);
    }

    @Override
    public void Desapilar(int x) {
        ind--;
    }

    @Override
    public int Tope() {
        return arr[ind-1];
    }
}
