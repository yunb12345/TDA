package miercoles.diccionarios.multiple;

import miercoles.conjunto.conjuntoTDA;

public interface diccionarioMultipleTDA {
    public void inicializarDiccionario();
    public void Agregar(int key, int value);
    public void Eliminar(int key);
    public void EliminarValor(int key, int value);
    public conjuntoTDA RecuperarValor(int key);
    public conjuntoTDA keys();
}
