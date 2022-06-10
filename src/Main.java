import java.util.Date;
import java.util.Timer;
import classes.Miasta;
import classes.Pliki;
import classes.AE.AE;
import classes.AE.Chromosom;

public class Main {
    public static void main(String[] args) throws Exception {
        // Całkowita liczba osobników dla 20 miast: 80000
        // Całkowita liczba osobników dla 30 miast: 100000
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        String czas = "";
        String czasdane = "";

        int[] rozmiarypopulacji = { 20, 50, 100, 200, 400, 500, 1000, 2000 };
        for (int aktualnyindekspopulacji = 0; aktualnyindekspopulacji < rozmiarypopulacji.length; aktualnyindekspopulacji++) {
            double szansaNaMutacje = 0.05;
            double szansaNaKrzyżowanie = 0.6;
            int rozmiarPopulacji = rozmiarypopulacji[aktualnyindekspopulacji];
            int iloscPowtorzenAlgorytmu = (100000 / rozmiarPopulacji);
            int iloscUruchomienCalosci = 30;
            int numerOsobnika = 1;
            int nieDoKońcaLosowaLiczba;
            double bestGlobal = 10000, bestCurrent = 10000;
            double[][] srednie = new double[3][iloscPowtorzenAlgorytmu * rozmiarPopulacji];
            String dane = "";
            startTime = System.currentTimeMillis();
            for (int powtorzenie = 1; powtorzenie <= iloscUruchomienCalosci; powtorzenie++) {
                elapsedTime = (new Date()).getTime() - startTime;
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
                        srednie[0][numerOsobnika - 1] = srednie[0][numerOsobnika - 1] + chr.przystosowanieChromosomu;
                        srednie[1][numerOsobnika - 1] = srednie[1][numerOsobnika - 1] + bestCurrent;
                        srednie[2][numerOsobnika - 1] = srednie[2][numerOsobnika - 1] + bestGlobal;
                        numerOsobnika++;

                    }
                    AE.SelekcjaRankingowa(rozmiarPopulacji);

                }
                seconds = (elapsedTime / 1000) % 60;
                minutes = (elapsedTime / (1000 * 60) % 60);
                hours = (elapsedTime / (60 * 60 * 1000));
                czas = "[" + hours + "]godz [" + minutes + "]min [" + seconds + "]sec";
                hours = 0;
                minutes = 0;
                seconds = 0;
                Pliki.zapiszPlikWynikowy(dane, Miasta.MIASTA.length, rozmiarPopulacji, powtorzenie);
                Chromosom.populacja.clear();
                dane = "";
                numerOsobnika = 1;
                System.out.println("\033[H\033[2J");// to coś czyści konsolę
                System.out.println("Rozmiar Populacji: " + rozmiarPopulacji);
                System.out.println("Ilość powtórzeń algorytmu: " + iloscPowtorzenAlgorytmu);
                System.out.println("Ukończono: " + (int) (((double) powtorzenie / iloscUruchomienCalosci) * 100) + "%");
                System.out.println("Upłynęło: " + czas);
            }
            for (int i = 0; i < iloscPowtorzenAlgorytmu * rozmiarPopulacji; i++) {
                srednie[0][i] = srednie[0][i] / iloscUruchomienCalosci;
                srednie[1][i] = srednie[1][i] / iloscUruchomienCalosci;
                srednie[2][i] = srednie[2][i] / iloscUruchomienCalosci;
            }
            for (int i = 0; i < iloscPowtorzenAlgorytmu * rozmiarPopulacji; i++) {
                dane += i + 1 + " " + String.format("%.3f", srednie[1][i]) + " "
                        + String.format("%.3f", srednie[0][i]) + " " + String.format("%.3f", srednie[0][i]) + "\r\n";
            }
            czasdane += "Populacja: " + rozmiarPopulacji + " Czas: " + czas + "\n";

            Pliki.zapiszPlikWynikowySrednia(dane, Miasta.MIASTA.length, rozmiarPopulacji);
        }
        Pliki.zapiszPlikCzasowy(czasdane);
    }
}
