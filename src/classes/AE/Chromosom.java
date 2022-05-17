package classes.AE;

import java.util.ArrayList;
import java.util.Random;

import classes.Miasta;

public class Chromosom {
    public static ArrayList utworzPopulacje(){
        ArrayList<int[]> populacja = new ArrayList<int[]>();
        int[] chromosom = new int[30];
        Random rng = new Random();
        rng.nextInt(Miasta.MIASTA.length); //dodanie tablicy uzytych indeksów w celu wykluczenia powtórzeń
        return populacja;
    }
}
