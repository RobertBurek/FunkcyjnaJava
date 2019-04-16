package KATA;

/**
 * Created by Robert Burek
 */
public class Tablica {
    int[][] tablica;


   // tablica1 = new {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};

    public Tablica(int[][] tablica) {
        this.tablica = tablica;
    }

    public int[] getTablica(int wiersz, int kolumna) {
        int[] dwieLinie={0,0,0,0,0,0,0,0,};
        int z=0;
        for(int i=0; i<4;++i){
            dwieLinie[z] = tablica[wiersz][i];
            ++z;
        }
        for(int i=0; i<4;++i){
            dwieLinie[z] = tablica[i][kolumna];
            ++z;
        }
        return dwieLinie;
    }
}
