import classes.Miasta;
import classes.Pliki;
import classes.AE.AE;
import classes.AE.Chromosom;

public class Main {
    public static void main(String[] args) throws Exception { 
        //wszystkie duże komponenty sklejone w całość są w mainie

        //Całkowita liczba osobników dla 20 miast: 80000
        //Całkowita liczba osobników dla 30 miast: 100000

        System.out.println("\033[H\033[2J");// to coś czyści konsolę 
        double szansaNaMutacje=0.05;
        double szansaNaKrzyżowanie=0.6;
        int rozmiarPopulacji=2000;
        int iloscPowtorzenAlgorytmu=40;
        int numerOsobnika = 1;
        int nieDoKońcaLosowaLiczba;
        double bestGlobal = 10000, bestCurrent = 10000;
        String dane = "";

        AE.GenerujLosowaPopulację(rozmiarPopulacji);
        System.out.println("Ilość miast: "+Miasta.MIASTA.length);
        for (int i = 0; i < iloscPowtorzenAlgorytmu; i++) {
            for (int j = 0; j < rozmiarPopulacji; j++) {
                if (Math.random()<szansaNaKrzyżowanie) {
                    do{
                        nieDoKońcaLosowaLiczba=(int)(Chromosom.populacja.size()*Math.random());
                    }while(nieDoKońcaLosowaLiczba==j);

                    AE.KrzyzujChromosomy(Chromosom.populacja.get(j), Chromosom.populacja.get(nieDoKońcaLosowaLiczba));
                }
               
            }
            for (int j = 0; j < rozmiarPopulacji; j++) {
                if (Math.random()<szansaNaMutacje) {
                   AE.MutujChromosom(Chromosom.populacja.get(j));
                }
            }
            
            bestCurrent = AE.WyznaczOptimumPopulacji();
            if(bestCurrent < bestGlobal){
                bestGlobal = bestCurrent;
            }
            for (int j = 0; j < rozmiarPopulacji; j++) {
                Chromosom chr = Chromosom.populacja.get(j);
                dane += numerOsobnika + " " + String.format("%.3f", chr.przystosowanieChromosomu)+" "+String.format("%.3f", bestCurrent)+" "+String.format("%.3f", bestGlobal)+"\r\n";
                numerOsobnika++;
            }
            
            AE.SelekcjaRankingowa(rozmiarPopulacji);
           
        }

        Pliki.zapiszPlikWynikowy(dane);

    }
}
