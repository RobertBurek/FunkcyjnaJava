package KATA;

import java.util.Arrays;

/**
 * Created by Robert Burek
 */
final public class Linia {

    int[] linia={0,0,0,0};

    public Linia() { }

    public Linia(int[] linia) {
        this.linia = linia;
    }


    public int getLinia(int i) {
        return linia[i];
    }

    @Override
    public String toString() {
        return "Linia{" +
                "linia=" + Arrays.toString(linia) +
                '}';
    }
}
