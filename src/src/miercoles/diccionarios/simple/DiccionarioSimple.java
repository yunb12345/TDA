package miercoles.diccionarios.simple;

import miercoles.conjunto.Conjunto;
import miercoles.conjunto.conjuntoTDA;
import miercoles.diccionarios.Elemento;
import miercoles.diccionarios.multiple.diccionarioSimpleTDA;

public class DiccionarioSimple implements diccionarioSimpleTDA {

    private Elemento[] elementos;
    private int cant;

    @Override
    public void InicializarDiccionario() {
        elementos = new Elemento[100];
        cant = 0;
    }

    private int Clave2Ind(int key){
        int i = cant-1;
        while (i>0 && elementos[i].key != key){
            i--;
        }
        return i;
    }

    @Override
    public void Agregar(int key, int value) {
        int pos = Clave2Ind(key);
        if(pos==-1){
            pos=cant;
            elementos[pos]= new Elemento();
            elementos[pos].key = key;
            cant++;
        }
        elementos[pos].value = value;
    }

    @Override
    public void Eliminar(int key) {
        int pos = Clave2Ind(key);
        if(pos !=1){
            elementos[pos] = elementos[cant-1];
            cant--;
        }
    }

    @Override
    public int RecuperarValor(int key) {
        int pos = Clave2Ind(key);
        return elementos[pos].value;
    }

    @Override
    public conjuntoTDA keys() {
       Conjunto c = new Conjunto();
       c.InicializarConjunto();
       for(int i=0; i<cant;i++){
           c.AgregarConjunto(elementos[i].key);
       }
       return c;
    }
}
