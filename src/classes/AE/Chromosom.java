package classes.AE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import classes.Miasta;

public class Chromosom {

    public static ArrayList<double[]> utworzPopulacje(){
        ArrayList<double[]> populacja = new ArrayList<double[]>();
        double[] chromosom = new double[30];
        Random rng = new Random();
        int miasto1,miasto2;
        int[] wykorzystaneMiasta1 = new int[30];
        int[] wykorzystaneMiasta2 = new int[30];
        //dodanie tablicy uzytych indeksów w celu wykluczenia powtórzeń
        for(int i=0;i<chromosom.length;i++){
            do {
                miasto1 = rng.nextInt(30);
                miasto2 = rng.nextInt(30);
            } 
            while (Arrays.asList(wykorzystaneMiasta1).contains(miasto1) || Arrays.asList(wykorzystaneMiasta2).contains(miasto2) || miasto1 == miasto2);
            chromosom[i] = Miasta.ODLEGLOSCI[miasto1][miasto2];
            wykorzystaneMiasta1[i] = miasto1;
            wykorzystaneMiasta2[i] = miasto2;
        }
        rng.nextInt(Miasta.MIASTA.length); //dodanie tablicy uzytych indeksów w celu wykluczenia powtórzeń
        return populacja;
    }

    public static double wyznaczWartoscFunkcjiPrzystosowania(double[] chromosom){
        double wartoscFunkcjiPrzystosowania = 0.0;
        for (int i = 0; i < chromosom.length; i++) {
            wartoscFunkcjiPrzystosowania += chromosom[i];
        }
        return wartoscFunkcjiPrzystosowania;
    }

    public static double wyznaczOptimumPopulacji(ArrayList<double[]> populacja){
        double optimumPopulacji = Double.MAX_VALUE, wartoscFP=0.0;
        double[] obecnyChromosom;
        for (int i = 0; i < populacja.size(); i++) {
            obecnyChromosom = (double[]) populacja.get(i);
            wartoscFP = wyznaczWartoscFunkcjiPrzystosowania(obecnyChromosom);
            if(wartoscFP < optimumPopulacji){
                optimumPopulacji = wartoscFP;
            }
        }
        return optimumPopulacji;
    }

    public static void wypiszInfoOPopulacji(ArrayList<double[]> populacja){
        System.out.println("Wielkość populacji: "+populacja.size());
        System.out.println("Nr osobnika i wartość funkcji przystosowania:");
        for (int i = 0; i < populacja.size(); i++) {
            double[] chromosom = (double[]) populacja.get(i);
            System.out.println( (i+1)+" "+String.format("%.5f", wyznaczWartoscFunkcjiPrzystosowania(chromosom))+"\r\n");
        }
        System.out.println("Optimum funkcji: "+wyznaczOptimumPopulacji(populacja));
    }
     
}
