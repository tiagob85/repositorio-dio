package projeto.fila;

public class Main {

    public static void main(String[] args) {

        Fila<String> objFila = new Fila<>();

        objFila.enqueue("Primeiro");
        objFila.enqueue("Segundo");
        objFila.enqueue("Terceiro");
        objFila.enqueue("Quarto");
        objFila.enqueue("Quinto");

        System.out.println(objFila);

        System.out.println(objFila.dequeue());

        System.out.println(objFila);

      /*  objFila.enqueue("Ultimo");

        System.out.println(objFila);

        System.out.println(objFila.dequeue());

        System.out.println(objFila.first());*/
    }
}
