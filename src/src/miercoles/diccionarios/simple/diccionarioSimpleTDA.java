package miercoles.diccionarios.simple;

import miercoles.conjunto.conjuntoTDA;

public interface diccionarioSimpleTDA {
    public void InicializarDiccionario();
    public void Agregar(int key,int value);
    public void Eliminar(int key);
    public int RecuperarValor(int key);
    public conjuntoTDA keys();
}
