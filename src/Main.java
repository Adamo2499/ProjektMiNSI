import classes.AE.AE;
import classes.AE.Chromosom;

public class Main {
    public static void main(String[] args) throws Exception { 
        //wszystkie duże komponenty sklejone w całość są w mainie

        System.out.println("\033[H\033[2J");// to coś czyści konsolę 
        double szansaNaMutacje=0.1;
        double szansaNaKrzyżowanie=0.4;
        int rozmiarPopulacji=50;
        int iloscPowtorzenAlgorytmu=10;


        AE.GenerujLosowaPopulację(rozmiarPopulacji);
        for (int i = 0; i < iloscPowtorzenAlgorytmu; i++) {

            System.out.println("Krzyżowanie");//debug
            for (int j = 0; j < rozmiarPopulacji; j++) {
                if (Math.random()<szansaNaKrzyżowanie) {
                    AE.KrzyzujChromosomy(Chromosom.populacja.get(j), Chromosom.populacja.get((int)(Chromosom.populacja.size()*Math.random())));
                }
            }
            //AE.WypiszInfoOPopulacji();

            System.out.println("Mutacja");//debug
            for (int j = 0; j < Chromosom.populacja.size(); j++) {
                if (Math.random()<szansaNaMutacje) {
                   AE.MutujChromosom(Chromosom.populacja.get(j));//mutacja zdaje się zawieszać po 3 uruchomieniachg algorytmu
                }
            }
            //AE.WypiszInfoOPopulacji();

            System.out.println("Selekcja");//debug
            AE.SelekcjaRankingowa(rozmiarPopulacji);

        }
        AE.WypiszInfoOPopulacji();

    }
}
