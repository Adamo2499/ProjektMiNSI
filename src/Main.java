import classes.Miasta;
import classes.Pliki;
import classes.AE.AE;
import classes.AE.Chromosom;

public class Main {
    public static void main(String[] args) throws Exception {
        // wszystkie duże komponenty sklejone w całość są w mainie

        // Całkowita liczba osobników dla 20 miast: 80000
        // Całkowita liczba osobników dla 30 miast: 100000


        double szansaNaMutacje = 0.05;
        double szansaNaKrzyżowanie = 0.6;
        int rozmiarPopulacji = 20;
        int iloscPowtorzenAlgorytmu = 2000;
        int iloscUruchomienCalosci = 30;
        int numerOsobnika = 1;
        int nieDoKońcaLosowaLiczba;
        double bestGlobal = 10000, bestCurrent = 10000;
        double[][] srednie = new double[3][iloscPowtorzenAlgorytmu * rozmiarPopulacji];
        String dane = "";

        for (int powtorzenie = 1; powtorzenie <= iloscUruchomienCalosci; powtorzenie++) {
            AE.GenerujLosowaPopulację(rozmiarPopulacji);
            for (int i = 0; i < iloscPowtorzenAlgorytmu; i++) {
                for (int j = 0; j < rozmiarPopulacji; j++) {
                    if (Math.random() < szansaNaKrzyżowanie) {
                        do {
                            nieDoKońcaLosowaLiczba = (int) (Chromosom.populacja.size() * Math.random());
                        } while (nieDoKońcaLosowaLiczba == j);

                        AE.KrzyzujChromosomy(Chromosom.populacja.get(j),
                                Chromosom.populacja.get(nieDoKońcaLosowaLiczba));
                    }

                }
                for (int j = 0; j < rozmiarPopulacji; j++) {
                    if (Math.random() < szansaNaMutacje) {
                        AE.MutujChromosom(Chromosom.populacja.get(j));
                    }
                }

                bestCurrent = AE.WyznaczOptimumPopulacji();
                if (bestCurrent < bestGlobal) {
                    bestGlobal = bestCurrent;
                }
                for (int j = 0; j < rozmiarPopulacji; j++) {
                    Chromosom chr = Chromosom.populacja.get(j);
                    dane += numerOsobnika + " " + String.format("%.3f", chr.przystosowanieChromosomu) + " "
                            + String.format("%.3f", bestCurrent) + " " + String.format("%.3f", bestGlobal) + "\r\n";
                    srednie[0][numerOsobnika - 1] = srednie[0][numerOsobnika - 1]+ chr.przystosowanieChromosomu;
                    srednie[1][numerOsobnika - 1] = srednie[1][numerOsobnika - 1]+ bestCurrent;
                    srednie[2][numerOsobnika - 1] = srednie[2][numerOsobnika - 1]+ bestGlobal;
                    numerOsobnika++;

                }

                AE.SelekcjaRankingowa(rozmiarPopulacji);

            }
            Pliki.zapiszPlikWynikowy(dane, Miasta.MIASTA.length, rozmiarPopulacji, powtorzenie);
            Chromosom.populacja.clear();
            dane = "";
            numerOsobnika = 1;
            System.out.println("\033[H\033[2J");// to coś czyści konsolę
            System.out.println("Ukończono "+(int)(((double)powtorzenie/iloscUruchomienCalosci)*100)+"%");
        }
        for (int i = 0; i < iloscPowtorzenAlgorytmu * rozmiarPopulacji; i++) {
            srednie[0][i] = srednie[0][i]/iloscUruchomienCalosci;
            srednie[1][i] = srednie[1][i]/iloscUruchomienCalosci;
            srednie[2][i] = srednie[2][i]/iloscUruchomienCalosci;
            
        }

        for (int i = 0; i < iloscPowtorzenAlgorytmu * rozmiarPopulacji; i++) {
            dane += i+1 + " " + String.format("%.3f", srednie[1][i] ) + " "
            + String.format("%.3f", srednie[0][i] ) + " " + String.format("%.3f", srednie[0][i] ) + "\r\n"; 
        }
        Pliki.zapiszPlikWynikowySrednia(dane, Miasta.MIASTA.length, rozmiarPopulacji);

    }
}
