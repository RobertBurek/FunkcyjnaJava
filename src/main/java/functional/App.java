package functional;

/**
 * Created by Robert Burek
 */
public class App {

    public static void main(String[] args) {

        //1
        Runnable cos1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("AAA");
            }
        };

        //2
        Runnable cos2 = () -> {
            System.out.println("AAA");
        };

        //3
        Runnable cos3 = () -> System.out.println("AAA");

        //1
        Comparable<String> comparable1 = new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };

        //2
        Comparable<String> comparable2 = (String o) -> 0;

        //3
        Comparable<String> comparable3 = o -> 0;


        //1
        Movable m1 = new Movable() {
            @Override
            public int move(String direction) {
                return 11;
            }
        };

        //2
        Movable m2 = direction -> 11;

        test("pierwsza", cos1);
        test("druga", cos2);

    }

    public static void test(String name, Runnable a) {
    }
}
