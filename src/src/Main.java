import miercoles.arboles.ArbolBB;

public class Main {
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();
        arbol.Agregar(6);
        arbol.Agregar(2);
        arbol.Agregar(8);
        arbol.Agregar(1);
        arbol.Agregar(5);
        arbol.Agregar(9);

        System.out.println(arbol);
        System.out.println("------------------------");

        arbol.Agregar(7);
        System.out.println(arbol);
        System.out.println("------------------------");

        arbol.Agregar(2);
        System.out.println(arbol);
        System.out.println("------------------------");

        arbol.Agregar(6);
        System.out.println(arbol);
        System.out.println("------------------------");
        arbol.preOrder(arbol);
        System.out.println("------------------------");
        arbol.inOrder(arbol);
        System.out.println("------------------------");
        arbol.postOrder(arbol);
    }
}