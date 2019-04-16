package KATA;

import java.util.function.Predicate;

/**
 * Created by Robert Burek
 */
public class solvePuzzle {


    static int[] war = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
    static int[][] tab={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};


    public solvePuzzle(tablica l) {
    }

    public static void w(int i) {
        System.out.print(i);
    }

    public static void z(char s) {
        System.out.print(s);
    }

    public static void k() {
        System.out.println("");
    }

    public static void rysuj() {
     z(' ');z('|');w(war[0]);z('|');w(war[1]);z('|');w(war[2]);z('|');w(war[3]);z('|');z(' ');k();
     z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');k();
     w(war[15]);z('|');w(tab[0][0]);z('|');w(tab[0][1]);z('|');w(tab[0][2]);z('|');w(tab[0][3]);z('|');w(war[4]);k();
     z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');k();
     w(war[14]);z('|');w(tab[1][0]);z('|');w(tab[1][1]);z('|');w(tab[1][2]);z('|');w(tab[1][3]);z('|');w(war[5]);k();
     z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');k();
     w(war[13]);z('|');w(tab[2][0]);z('|');w(tab[2][1]);z('|');w(tab[2][2]);z('|');w(tab[2][3]);z('|');w(war[6]);k();
     z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');k();
     w(war[12]);z('|');w(tab[3][0]);z('|');w(tab[3][1]);z('|');w(tab[3][2]);z('|');w(tab[3][3]);z('|');w(war[7]);k();
     z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');z('-');k();
     z(' ');z('|');w(war[11]);z('|');w(war[10]);z('|');w(war[9]);z('|');w(war[8]);z('|');z(' ');k();
    }

        public static void main (String[]args){

        rysuj();
        Linia L00 = new Linia();



            Predicate<Linia> sprawdzLinie = new Predicate<Linia>() {
                @Override
                public boolean test(Linia linia) {
                    for (int i=0;i<4;++i){
                        if (linia[i]==1) {
                            int juzJest=1;
                        }

                    }
                    return false;
                }

                @Override
                public boolean test(Linia linia,int wiersz, int kolumna, int wartosc) {
                    for (int i=0;i<4;++i){
                        if (linia[i]==wartosc) {
                            int juzJest=1;
                        }

                    }
                    return false;
                }
            };




        }
    }

