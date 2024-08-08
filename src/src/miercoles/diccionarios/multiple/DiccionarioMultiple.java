package miercoles.diccionarios.multiple;

import miercoles.conjunto.Conjunto;
import miercoles.conjunto.conjuntoTDA;
import miercoles.diccionarios.simple.diccionarioMultipleTDA;

public class DiccionarioMultiple implements diccionarioMultipleTDA {
   class Elemento{
       int key;
       int[]values;
       int cantValues;
   }

   private Elemento[] elementos;
   private int cantKeys;

    @Override
    public void inicializarDiccionario() {
        elementos = new Elemento[100];
        cantKeys = 0;
    }

    private int Clave2Indice(int key){
        int i = cantKeys-1;
        while (1>=0 && elementos[i].key !=key){
            i--;
        }
        return i;
    }

    private int Valor2Indice(Elemento e, int value){
        int i = e.cantValues-1;
        while (i>=0 && e.values[i] !=value){
            i--;
        }
        return i;
    }

    @Override
    public void Agregar(int key, int value) {
        int posC = Clave2Indice(key);
        if(posC== -1){
            posC = cantKeys;
            elementos[posC] = new Elemento();
            elementos[posC].key = key;
            elementos[posC].cantValues =0;
            elementos[posC].values = new int[100];
            cantKeys++;
        }
        Elemento e = elementos[posC];
        int posV = Valor2Indice(e,value);
        if(posV== -1){
            e.values[e.cantValues] =value;
            e.cantValues++;
        }
    }

    @Override
    public void Eliminar(int key) {
        int posC = Clave2Indice(key);
        if(posC !=-1){
            elementos[posC]= elementos[cantKeys -1];
            cantKeys--;
        }
    }

    @Override
    public void EliminarValor(int key, int value) {
        int posC = Clave2Indice(key);
        if(posC !=1){
            Elemento e = elementos[posC];
            int posV = Valor2Indice(e,value);
            if(posV != -1){
                e.values[posV]= e.values[e.cantValues-1];
                e.cantValues--;
            }
            if(e.cantValues ==0){
                Eliminar(key);
            }
        }
    }

    @Override
    public conjuntoTDA RecuperarValor(int key) {
        Conjunto c = new Conjunto();
        c.InicializarConjunto();
        int posC = Clave2Indice(key);
        if(posC !=1){
            Elemento e = elementos[posC];
            for(int i=0; i<e.cantValues; i++){
                c.AgregarConjunto(e.values[i]);
            }
        }
        return c;
    }

    @Override
    public conjuntoTDA keys() {
        Conjunto c = new Conjunto();
        c.InicializarConjunto();
        for(int i=0; i<cantKeys; i++){
            c.AgregarConjunto(elementos[i].key);
        }
        return c;
    }
}
