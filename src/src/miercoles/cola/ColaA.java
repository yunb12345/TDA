package miercoles.cola;

public class ColaA implements colaTDA{
    int[] arr;
    int ind;
    @Override
    public void InicializarCola() {
        arr = new int[100];
        ind = 0;
    }

    @Override
    public void Acolar(int x) {
        for(int i = ind-1; i>0;i++){
            arr[i+1] = arr[i];
        }
        arr[0] = x;
        ind++;
    }

    @Override
    public boolean ColaVacia() {
        return (ind == 0);
    }

    @Override
    public void Desacolar(int x) {
        ind--;
    }

    @Override
    public int Primero() {
        return arr[ind-1];
    }
}
