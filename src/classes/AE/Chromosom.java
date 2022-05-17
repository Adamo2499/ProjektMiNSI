package classes.AE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import classes.Miasta;

public class Chromosom {
    double przystosowanie;
    int[] geny;
    public static ArrayList<Chromosom> populacja = new ArrayList<Chromosom>();

    Chromosom(int iloscgenow){
        this.geny = new int[iloscgenow];
        populacja.add(geny);
    }
}
