package projeto.listacircular;

public class Main {

    public static void main(String[] args) {
        ListaCircular<String> minhaLstaCircular = new ListaCircular<>();
        minhaLstaCircular.add("c0");
        System.out.println(minhaLstaCircular);

        minhaLstaCircular.remove(0);
        System.out.println(minhaLstaCircular);

        minhaLstaCircular.add("c1");
        System.out.println(minhaLstaCircular);

        minhaLstaCircular.add("c2");
        minhaLstaCircular.add("c3");
        System.out.println(minhaLstaCircular);

        System.out.println(minhaLstaCircular.get(1));
        System.out.println(minhaLstaCircular.get(2));
        System.out.println(minhaLstaCircular.get(3));
        System.out.println(minhaLstaCircular.get(4));
        System.out.println(minhaLstaCircular.get(5));

    }

}
