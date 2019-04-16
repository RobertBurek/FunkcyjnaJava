package KATA;

import java.util.Arrays;

/**
 * Created by Robert Burek
 */
public class Tablica {
    int[][] tablica;

    //tablica = new {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};

    public Tablica(int[][] tablica) {
        this.tablica = tablica;
    }

    public int[] getTablica(int wiersz, int kolumna) {
        int[] dwieLinie={0,0,0,0,0,0};
        int z=0;
        for(int i=0; i<4;++i){
            if(i!=wiersz){
            dwieLinie[z] = tablica[wiersz][i];
            ++z;}
        }
        for(int i=0; i<4;++i){
            if(i!=kolumna){
            dwieLinie[z] = tablica[i][kolumna];
            ++z;}
        }
        return dwieLinie;
    }

}
