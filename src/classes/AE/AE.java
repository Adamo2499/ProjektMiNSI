package classes.AE;

import java.util.ArrayList;
import java.util.Random;

public class AE {
    //wszystko co związane z tworzeniem i zarządzaniem chromosomami (Czyli algorytm ewolucyjny)
    public static void GenerujLosowaPopulację(int wielkoscPopulacji){//funkcja tworzy nową losową populację 
        for (int i = 0; i < wielkoscPopulacji; i++) {
            new Chromosom();         
        }
    }

    public static double WyznaczOptimumPopulacji(){//wyznacza najmniejszą wartość przystosowania w całej populacji
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

    public static void KrzyzujChromosomy(Chromosom chromosom1, Chromosom chromosom2){
        int dlugoscChromosomu=chromosom1.geny.length;
        int[] geny1=chromosom1.geny;
        int[] geny2=chromosom2.geny;
        int[] noweGeny1= new int[geny1.length];
        int[] noweGeny2= new int[geny2.length];
        ArrayList<Integer> uzyteGeny1 = new ArrayList<Integer>();
        ArrayList<Integer> uzyteGeny2 = new ArrayList<Integer>();
        //wyznaczanie indeksu pocżatkowego i końcowego
        int nieDoKońcaLosowaLiczba = (int)((Math.random()*dlugoscChromosomu/3))+5;
        int IndexPoczatekowy=(int)(Math.random()*(dlugoscChromosomu/2));
        int IndexKoncowy=nieDoKońcaLosowaLiczba+IndexPoczatekowy;//odległośc między indeksami jest mniejsza ale zawsze równa conajmniej 5;
        for (int i = 0; i < geny1.length; i++) {        //przepisywanie w miejscach wzynaczonych przez indexy
            if((i>=IndexPoczatekowy)&&(i<=IndexKoncowy)){
                noweGeny1[i]=geny2[i];
                uzyteGeny1.add(geny2[i]);
                noweGeny2[i]=geny1[i];
                uzyteGeny2.add(geny1[i]);
            }
        }
        for (int i = 0; i < geny1.length; i++) {//pierwsze przepisywanie poza miejscami wzynaczanymi przez indexy
            if((i>=IndexPoczatekowy)&&(i<=IndexKoncowy)){
            }else{   
                if(!uzyteGeny1.contains(geny1[i])){//pierwszy chromosom
                    noweGeny1[i]=geny1[i];
                    uzyteGeny1.add(geny1[i]);
                }else{//drugie przepisywanie liczb z dopasowania
                    int propozycja=geny1[i];
                    while(uzyteGeny1.contains(propozycja)){
                        propozycja=FindPMXMatch(geny1, geny2, propozycja);
                    }
                    noweGeny1[i]=propozycja;
                    uzyteGeny1.add(propozycja);
                }
                if(!uzyteGeny2.contains(geny2[i])){//zły brat bliźniak
                    noweGeny2[i]=geny2[i];
                    uzyteGeny2.add(geny2[i]);
                }else{//drugie przepisywanie liczb z dopasowania
                    int propozycja=geny2[i];
                    while(uzyteGeny2.contains(propozycja)){
                        propozycja=FindPMXMatch(geny2, geny1, propozycja);
                    }
                    noweGeny2[i]=propozycja;
                    uzyteGeny2.add(propozycja);
                }
            } 
        }
        new Chromosom(noweGeny1);// dodawanie 2 nowych chromosomów do populacji
        new Chromosom(noweGeny2);
    }
    static int FindPMXMatch(int[] tablica1, int[] tablica2, int value){//funkcja pomocnicza do szukania matchy w PMX
        int returnValue=0;
        for (int j = 0; j < tablica2.length; j++) {
            if (value==tablica2[j]) {
                    returnValue=tablica1[j];
                    break;
            }
        }
        return returnValue;
    }

    //mutacja (inwersja)
    public static void MutujChromosom(Chromosom chromosom) {
        Random rng = new Random();
        int[] geny = chromosom.geny;
        double szansaNaMutacje = 0.25, r;
        int temp;
        for (int i = 0; i < geny.length; i++) {
            r = rng.nextDouble();
            if(r < szansaNaMutacje){
                if(i==0 || i == geny.length-1){
                    temp = geny[0];
                    geny[0] = geny[geny.length-1];
                    geny[geny.length-1] = temp;
                }
                else {
                    temp = geny[i];
                    geny[i] = geny[i++];
                    geny[i++] = temp;
                }
                
            }
        }
    }

        

        // ruletka oparta o wykład, jak będzie inna opcja to usunę
        public static void GenerujRuletkowo() {
            AE.GenerujLosowaPopulację(30);
            Chromosom.populacja.get(0).wyznaczPrzystosowaniaPopulacji();
            
    
    
        }


    //gen = miasto
    //Chromosom = droga do celu


    // populacja to największa ilość trans między miastami (na start 20, a później do zmiany)
    // chromosom[iloscmiast] -> trasa między miastami
    // na chromosom składa się liczba genów równa ilości miast
    // każdy gen musi być reprezentowany przez inną liczbę od 0 do liczbamiast
    
    // funkcja przystosowania danego chromosomu to suma drogi między wszystkimi miastami w kolejności wskazanej przez geny chromosomu
    // optymalizacja polega na znalezieniu jak najkrótszej drogi pozwalającej na przebycie wszystkich wskazanych miast
    
}
