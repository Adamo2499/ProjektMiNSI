package classes.AE;

import java.util.ArrayList;
import java.util.Random;

import classes.Miasta;

public class AE {

    public static ArrayList utworzPopulacje( int rozmiarPopulacji ){
        ArrayList<int[]> populacja = new ArrayList<int[]>(rozmiarPopulacji);
        return populacja;
    }
    public static int[] utworzChromosom(){
        int[] chromosom = new int[30];
        Random rng = new Random();
        //dodanie tablicy uzytych indeksów w celu wtkluczze
         rng.nextInt(Miasta.MIASTA.length);
        return chromosom;
    }

    final static int MAXILOSCMIAST = 30;
    final static int wielkoscPopulacji = 20;
    static int zmiennaWielkoscPopulacji = wielkoscPopulacji;
    // populacja to największa ilość trans między miastami (na start 20, a później do zmiany)
    // chromosom[iloscmiast] -> trasa między miastami
    // na chromosom składa się liczba genów równa ilości miast
    // każdy gen musi być reprezentowany przez inną liczbę od 0 do liczbamiast
    
    // funkcja przystosowania danego chromosomu to suma drogi między wszystkimi miastami w kolejności wskazanej przez geny chromosomu
    // optymalizacja polega na znalezieniu jak najkrótszej drogi pozwalającej na przebycie wszystkich wskazanych miast
    
}
