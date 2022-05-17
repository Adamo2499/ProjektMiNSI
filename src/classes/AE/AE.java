package classes.AE;

import java.util.ArrayList;
import java.util.Random;

import classes.Miasta;
import classes.Pliki;
import classes.AE.Chromosom;

public class AE {

    final static int MAXILOSCMIAST = 30;
    final static int wielkoscPopulacji = 20;
    static int zmiennaWielkoscPopulacji = wielkoscPopulacji;

    public static ArrayList<double[]> utworzPopulacje(){
        



        Random rng = new Random();
        int miasto1,miasto2;
        int[] wykorzystaneMiasta1 = new int[30];
        int[] wykorzystaneMiasta2 = new int[30];
        //dodanie tablicy uzytych indeksów w celu wykluczenia powtórzeń
        Chromosom chromosom = new Chromosom();
        for(int i=0;i<chromosom.length;i++){
            do {
                miasto1 = rng.nextInt(29);
                miasto2 = rng.nextInt(29);
            } 
            while (Arrays.asList(wykorzystaneMiasta1).contains(miasto1) || Arrays.asList(wykorzystaneMiasta2).contains(miasto2) || miasto1 == miasto2);
            chromosom[i] = Miasta.ODLEGLOSCI[miasto1][miasto2];
            wykorzystaneMiasta1[i] = miasto1;
            wykorzystaneMiasta2[i] = miasto2;
            populacja.add(chromosom);
        }
        rng.nextInt(Miasta.MIASTA.length); //dodanie tablicy uzytych indeksów w celu wykluczenia powtórzeń
        return populacja;
    }

    public static void wypiszChromosom(double[] chromosom){
        for (int i = 0; i < chromosom.length; i++) {
            System.out.println(chromosom[i]);
        }
    }

    public static double WyznaczWartoscFunkcjiPrzystosowania(double[] chromosom){
        double wartoscFunkcjiPrzystosowania = 0.0;
        wypiszChromosom(chromosom);
        for (int i = 0; i < chromosom.length; i++) {
            wartoscFunkcjiPrzystosowania += chromosom[i];
        }
        return wartoscFunkcjiPrzystosowania;
    }

    public static double WyznaczOptimumPopulacji(ArrayList<double[]> populacja){
        double optimumPopulacji = Double.MAX_VALUE, wartoscFP=0.0;
        double[] obecnyChromosom;
        for (int i = 0; i < populacja.size(); i++) {
            obecnyChromosom = (double[]) populacja.get(i);
            wartoscFP = WyznaczWartoscFunkcjiPrzystosowania(obecnyChromosom);
            if(wartoscFP < optimumPopulacji){
                optimumPopulacji = wartoscFP;
            }
        }
        return optimumPopulacji;
    }

    public static void WypiszInfoOPopulacji(ArrayList<double[]> populacja){
        System.out.println("Wielkość populacji: "+populacja.size());
        System.out.println("Nr osobnika i wartość funkcji przystosowania:");
        for (int i = 0; i < populacja.size(); i++) {
            double[] chromosom = (double[]) populacja.get(i);
            System.out.println( (i+1)+" "+String.format("%.5f", WyznaczWartoscFunkcjiPrzystosowania(chromosom))+"\r\n");
        }
        System.out.println("Optimum funkcji: "+WyznaczOptimumPopulacji(populacja));
    }
    

    // populacja to największa ilość trans między miastami (na start 20, a później do zmiany)
    // chromosom[iloscmiast] -> trasa między miastami
    // na chromosom składa się liczba genów równa ilości miast
    // każdy gen musi być reprezentowany przez inną liczbę od 0 do liczbamiast
    
    // funkcja przystosowania danego chromosomu to suma drogi między wszystkimi miastami w kolejności wskazanej przez geny chromosomu
    // optymalizacja polega na znalezieniu jak najkrótszej drogi pozwalającej na przebycie wszystkich wskazanych miast
    
}
