package miercoles.cola;

public class ColaB implements colaTDA{
    int[] arr;
    int ind;
    @Override
    public void InicializarCola() {
        arr = new int[100];
        ind = 0;
    }

    @Override
    public void Acolar(int x) {
        arr[ind] = x;
        ind++;
    }

    @Override
    public boolean ColaVacia() {
        return ind == 0;
    }

    @Override
    public void Desacolar(int x) {
        for(int i = 0; i < ind;i++){
            arr[i]= arr[i+1];
        }
        ind--;
    }

    @Override
    public int Primero() {
        return arr[0];
    }
}
