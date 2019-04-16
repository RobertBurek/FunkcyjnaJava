package KATA;

import java.util.Arrays;

/**
 * Created by Robert Burek
 */
final public class Linia {

    int[] linia;

    public Linia() { }

    public Linia(int[] linia) {
        this.linia = linia;
    }


    @Override
    public String toString() {
        return "Linia{" +
                "linia=" + Arrays.toString(linia) +
                '}';
    }
}
