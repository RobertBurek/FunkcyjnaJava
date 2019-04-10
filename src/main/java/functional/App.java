package functional;

/**
 * Created by Robert Burek
 */
public class App {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        Comparable<String> comparable = new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };

    }
}
