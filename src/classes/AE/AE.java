package classes.AE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import classes.Miasta;
import classes.Pliki;
import classes.AE.Chromosom;

public class AE {

    final static int wielkoscPopulacji = 20;
    final static int iloscGenow = 30;
    static int zmiennaWielkoscPopulacji = wielkoscPopulacji;


    public static void GenerujLosowaPopulację(int wielkoscPopulacji, int iloscGenow){//funkcja tworzy nową losową populację 
        for (int i = 0; i < wielkoscPopulacji; i++) {
            new Chromosom(iloscGenow);    
        }
    }

    public static double WyznaczOptimumPopulacji(){
        double optimumPopulacji = Double.MAX_VALUE, wartoscFP=0.0;
        for (int i = 0; i < Chromosom.populacja.size(); i++) {
            wartoscFP = Chromosom.populacja.get(i).przystosowanieChromosomu;
            if(wartoscFP < optimumPopulacji){
                optimumPopulacji = wartoscFP;
            }
        }
        return optimumPopulacji;
    }

    public static void WypiszInfoOPopulacji(){//zmienioned
        System.out.println("Wielkość populacji: "+Chromosom.populacja.size());
        System.out.println("Nr osobnika i wartość funkcji przystosowania:");
        for (int i = 0; i < Chromosom.populacja.size(); i++) {
            System.out.println("Osobnik nr "+i+"    Przystosowanie: "+ String.format("%.5f", Chromosom.populacja.get(i).przystosowanieChromosomu));
        }
        System.out.println("Optimum funkcji: "+WyznaczOptimumPopulacji());
    }
    

    // populacja to największa ilość trans między miastami (na start 20, a później do zmiany)
    // chromosom[iloscmiast] -> trasa między miastami
    // na chromosom składa się liczba genów równa ilości miast
    // każdy gen musi być reprezentowany przez inną liczbę od 0 do liczbamiast
    
    // funkcja przystosowania danego chromosomu to suma drogi między wszystkimi miastami w kolejności wskazanej przez geny chromosomu
    // optymalizacja polega na znalezieniu jak najkrótszej drogi pozwalającej na przebycie wszystkich wskazanych miast
    
}
