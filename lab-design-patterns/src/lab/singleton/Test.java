package lab.singleton;

public class Test {

    public static void main(String[] args) {

        // Singleton deve devolver a mesma instância do objeto independente de quantas vezes for criado

        SingletonLazy lazy1 = SingletonLazy.getInstance();
        SingletonLazy lazy2 = SingletonLazy.getInstance();
        SingletonLazy lazy3 = SingletonLazy.getInstance();
        System.out.println(lazy1 == lazy2 && lazy2 == lazy3);

        SingletonEager eager1 = SingletonEager.getInstance();
        SingletonEager eager2 = SingletonEager.getInstance();
        SingletonEager eager3 = SingletonEager.getInstance();
        System.out.println(eager1 == eager2 && eager2 == eager3);

        SingletonLazyHolder holder1 = SingletonLazyHolder.getInstance();
        SingletonLazyHolder holder2 = SingletonLazyHolder.getInstance();
        SingletonLazyHolder holder3 = SingletonLazyHolder.getInstance();
        System.out.println(holder1 == holder2 && holder2 == holder3);
    }
}
