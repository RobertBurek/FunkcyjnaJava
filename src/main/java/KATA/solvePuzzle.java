package KATA;

import java.util.function.Predicate;

/**
 * Created by Robert Burek
 */
public class solvePuzzle {


    static int[] war = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
    static int[][] tab={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};


    public solvePuzzle(Tablica l) {
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

        Tablica tab1 = new Tablica(new int[][]{{4, 4, 4, 4}, {1, 2, 3, 4}, {5, 5, 5, 5}, {1, 2, 3, 4}});
        for(int i=0;i<tab1.getTablica(1,1).length;++i){
                System.out.print(tab1.getTablica(1, 1)[i]+" ");
            }
            System.out.println("");
        tab=(new int[][]{{4, 4, 4, 4}, {1, 2, 3, 4}, {5, 5, 5, 5}, {1, 2, 3, 4}});
        war = new int[]{0,1,2,3,0,1,2,3,3,2,1,0,3,2,1,0};
        rysuj();
        Linia L00 = new Linia();

        Tablica inna = new Tablica();
            System.out.println(inna.toString());
            System.out.println(tab1.toString());

            Predicate<Linia> sprawdzLinie = new Predicate<Linia>() {
                @Override
                public boolean test(Linia l) {
                    for (int i = 0; i < 3; ++i) {
                        if (l.linia[i] == 1) {
                            int juzJest = 1;
                        }
                    }
                    return false;
                }
            };




        }
    }

