package KATA;

import java.util.Arrays;

/**
 * Created by Robert Burek
 */
public class Tablica {
    int[][] tablica = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    //tablica = new {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};

    public Tablica(int[][] tablica) {
        this.tablica = tablica;
    }

    public Tablica() {
    }

    public int[] getTablica(int wiersz, int kolumna) {
        int[] dwieLinie = {0, 0, 0, 0, 0, 0};
        int z = 0;
        for (int i = 0; i < 4; ++i) {
            if (i != wiersz) {
                dwieLinie[z] = tablica[wiersz][i];
                ++z;
            }
        }
        for (int i = 0; i < 4; ++i) {
            if (i != kolumna) {
                dwieLinie[z] = tablica[i][kolumna];
                ++z;
            }
        }
        return dwieLinie;
    }

    public boolean sprCzyJest(int wartosc, int wiersz, int kolumna) {
        boolean jestJuz = false;

        int[] dwieLinie = {0, 0, 0, 0, 0, 0};
        int z = 0;
        for (int i = 0; i < 4; ++i) {
            if (i != wiersz) {
                dwieLinie[z] = tablica[wiersz][i];
                ++z;
            }
        }
        for (int i = 0; i < 4; ++i) {
            if (i != kolumna) {
                dwieLinie[z] = tablica[i][kolumna];
                ++z;
            }
        }
        for (int i=0 ; i<6 ; ++i){
            if (dwieLinie[i]==wartosc) jestJuz=true;
        }
        return jestJuz;
    }

    @Override
    public String toString() {
        return "|" + tablica[0][0] + "|" + tablica[0][1] + "|" + tablica[0][2] + "|" + tablica[0][3] + "|\n"+
                "|" + tablica[1][0] + "|" + tablica[1][1] + "|" + tablica[1][2] + "|" + tablica[1][3] + "|\n"+
                "|" + tablica[2][0] + "|" + tablica[2][1] + "|" + tablica[2][2] + "|" + tablica[2][3] + "|\n"+
                "|" + tablica[3][0] + "|" + tablica[3][1] + "|" + tablica[3][2] + "|" + tablica[3][3] + "|\n";
    }
}
