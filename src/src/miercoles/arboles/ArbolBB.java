package miercoles.arboles;

import miercoles.listas.enlazadas.ListaEnlazada;

public class ArbolBB implements arbolBBTDA{
   NodeABB raiz;
    @Override
    public void InicializarArbol() {
        this.raiz = null;
    }

    @Override
    public int Raiz() {
        return this.raiz.getInfo();
    }

    @Override
    public arbolBBTDA HijoIzquierdo() {
        return (this.raiz.getIzquierdo());
    }

    @Override
    public arbolBBTDA hijoDerecho() {
        return (this.raiz.getDerecho());
    }

    @Override
    public boolean ArbolVacio() {
        return (this.raiz == null);
    }

    @Override
    public void Agregar(int x) {
        if(this.ArbolVacio()){
            this.raiz = new NodeABB(x);
        } else{
            if(x < this.Raiz()){
                this.raiz.getIzquierdo().Agregar(x);
            } else{
                this.raiz.getDerecho().Agregar(x);
            }
        }
    }

    @Override
    public void Eliminar(int x) {
        //sie s vacio retorna
        if(this.ArbolVacio()){
            return;
        }
        //si la raiz es el x a elim, y no hay subarbol der
        if(this.Raiz() == x && this.hijoDerecho().ArbolVacio()){
            //se guarda el valor mayor de los izq, es decir de los menores
            //se le pasa al raiz ese valor
            //y se elim ese valor mayor del izq
            int valorMayor = this.mayor(this.HijoIzquierdo());
            this.raiz.setInfo(valorMayor);
            this.HijoIzquierdo().Eliminar(valorMayor);
        }
        //sino, si la raiz es el x, se toma el valor menor del subarbol derecho,
        // setendoselo al raiz, luego borrandolo
        if(this.Raiz() == x){
            int valorMenor = this.menor(this.hijoDerecho());
            this.raiz.setInfo(valorMenor);
            this.hijoDerecho().Eliminar(valorMenor);
        }
        if (this.Raiz() > x){
            this.HijoIzquierdo().Eliminar(x);
        } else{
            this.hijoDerecho().Eliminar(x);
        }
    }

    //Método para buscar si es >
    //si el hijo der es vacio el mayor sera el raiz
    //sino, el mayor sera el hijo der
    private int mayor(arbolBBTDA arbol){
        if(arbol.hijoDerecho().ArbolVacio()){
            return arbol.Raiz();
        } else{
            return mayor(arbol.hijoDerecho());
        }
    }

    //Método para buscar si es <, si no hay hijo izq < sera el raiz
    ////si hay hijo izq, ese sera el menor
    private int menor(arbolBBTDA arbol){
        if(arbol.HijoIzquierdo().ArbolVacio()){
            return arbol.Raiz();
        } else{
            return menor(arbol.HijoIzquierdo());
        }
    }

    private String espacios(int n){
        String salida = "";
        for (int i= 0; i< n*2; i++){
            salida = salida + "";
        }
        return salida;
    }

    //Recorridos

    //raiz-izq-der
    public void preOrder(arbolBBTDA arbol){
        if(!arbol.ArbolVacio()){
            System.out.println(arbol.Raiz());
            preOrder(arbol.HijoIzquierdo());
            preOrder(arbol.hijoDerecho());
        }
    }

    //izq-raiz-der
    public void inOrder(arbolBBTDA arbol){
        if(!arbol.ArbolVacio()){
            inOrder(arbol.HijoIzquierdo());
            System.out.println(arbol.Raiz());
            inOrder(arbol.hijoDerecho());
        }
    }

    //izq-der-raiz
    public void postOrder(arbolBBTDA arbol){
        if(!arbol.ArbolVacio()){
            postOrder(arbol.HijoIzquierdo());
            postOrder(arbol.hijoDerecho());
            System.out.println(arbol.Raiz());
        }
    }

    //Adcionales - recursividad

    //Cant nodos Arbol
    public int Contar(arbolBBTDA arbol){
        if(arbol.ArbolVacio()){
            return 0;
        } else{
            return(1+ Contar(arbol.HijoIzquierdo()) + Contar(arbol.hijoDerecho()));
        }
    }

    //Profundidad de nodo
    public int Profundidad(arbolBBTDA arbol,int x){
        if(arbol.ArbolVacio()){
            return 0;
        } else if(arbol.Raiz() == x){
            return 0;
        } else if(arbol.Raiz() > x){
            return(1 + this.Profundidad(arbol.HijoIzquierdo(),x));
        }else{
            return(1 + this.Profundidad(arbol.hijoDerecho(), x));
        }
    }

    //Buscar si existe un valor
    public boolean Existe(arbolBBTDA arbol, int x){
        if(arbol.ArbolVacio()){
            return false;
        } else if(arbol.Raiz() ==  x){
            return true;
        } else if(arbol.Raiz() > x){
            return this.Existe(arbol.HijoIzquierdo(), x);
        } else{
            return this.Existe(arbol.hijoDerecho(), x);
        }
    }

    //Ver si es Hoja
    public boolean EsHoja(int n, arbolBBTDA arbol){
        if (arbol.ArbolVacio()){
            return false;
        } else if(arbol.Raiz() == n && arbol.hijoDerecho().ArbolVacio() && arbol.HijoIzquierdo().ArbolVacio()){
            return true;
        } else if(arbol.Raiz() >n){
            return EsHoja(n,arbol.HijoIzquierdo());
        } else{
            return EsHoja(n,arbol.hijoDerecho());
        }
    }

    //Ej - 4 - agregar hojas de una rbol a una lista enlazada
    public ListaEnlazada calculoHojaLista(ArbolBB arbol, int n){ //log(n) + o(n) = o(n)
        ListaEnlazada lista = new ListaEnlazada();
        if(arbol.EsHoja(n,arbol)){
            lista.Agregar(n);
            return lista;
        }
        return lista;
    }

    //Ej - 5 - agregar valor del arbol + altura de se nodo a una lista enlazada
    //tuve q crear un nuevo Nodo con modificac, para q acepte 2 parametros el agregado a la lista
    //crear un nuevo nodo en ListaEnlazada, y codear un Agregado2
    public ListaEnlazada calcularAlturaLista(ArbolBB arbol){
        ListaEnlazada lista = new ListaEnlazada();
        lista.Agregarv2(arbol,arbol.Altura(arbol));
        return lista;
    }

    //Cant nodos
    public static int Elementos(arbolBBTDA arbol){
        if(arbol.ArbolVacio()){
            return 0;
        } else{
            return (1+Elementos(arbol.HijoIzquierdo())+Elementos(arbol.hijoDerecho()));
        }
    }

    //Sumar elementos
    public static int Suma(arbolBBTDA arbol){
        if(arbol.ArbolVacio()) {
            return 0;
        } else{
            return(arbol.Raiz()+Suma(arbol.HijoIzquierdo())+Suma(arbol.hijoDerecho()));
        }
    }

    //Contar cant hojas
    public static int Hojas(arbolBBTDA arbol){
        if(arbol.ArbolVacio()) {
            return 0;
        } else if(arbol.HijoIzquierdo().ArbolVacio() && arbol.hijoDerecho().ArbolVacio()){
            return 1;
        } else{
            return(Hojas(arbol.HijoIzquierdo())+Hojas(arbol.hijoDerecho()));
        }
    }

    //Altura arbol- > profundidades
    public int Altura(arbolBBTDA arbol){
        if(arbol.ArbolVacio()) {
            return 0;
        } else if(Altura(arbol.hijoDerecho())>Altura(arbol.HijoIzquierdo())){
            return Altura(arbol.hijoDerecho())+1;
        } else{
            return Altura(arbol.HijoIzquierdo())+1;
        }
    }
}
