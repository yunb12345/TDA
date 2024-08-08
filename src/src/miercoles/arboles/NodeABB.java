package miercoles.arboles;

public class NodeABB {
    private int info;
    private ArbolBB izquierdo;
    private ArbolBB derecho;

    public NodeABB(int info){
        this.info = info;
        this.izquierdo = new ArbolBB();
        this.derecho = new ArbolBB();
    }

    public int getInfo(){
        return info;
    }

    public void setInfo(int info){
        this.info = info;
    }

    public ArbolBB getIzquierdo(){
        return izquierdo;
    }

    public void setIzquierdo(ArbolBB izquierdo){
        this.izquierdo = izquierdo;
    }

    public  ArbolBB getDerecho(){
        return derecho;
    }

    public void setDerecho(ArbolBB derecho){
        this.derecho = derecho;
    }
}
