package miercoles.conjunto;

public class Conjunto implements conjuntoTDA{
    int []arr;
    int size;
    @Override
    public void InicializarConjunto() {
        arr = new int[100];
        size = 0;
    }

    @Override
    public void AgregarConjunto(int x) {
        if(!this.Pertenece(x)){
            arr[size] = x;
            size++;
        }
    }

    @Override
    public boolean ConjuntoVacio() {
        return (size == 0);
    }

    @Override
    public void SacarConjunto(int x) {
        int i = 0;
        while (i< size && arr[i] !=x){
            i++;
        }
        if(i < size){
            arr[i] = arr[size-1];
            size--;
        }
    }

    @Override
    public int Elegir() {
        return arr[size-1];
    }

    @Override
    public boolean Pertenece(int x) {
        int i = 0;
        while(i < size && arr[i] != x)
            i++;
        return (i < size);
    }
}
