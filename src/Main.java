import classes.AE.AE;
import classes.AE.Chromosom;

public class Main {
    public static void main(String[] args) throws Exception { 
        //wszystkie duże komponenty sklejone w całość są w mainie

        System.out.print("\033[H\033[2J");// to coś czyści konsolę 


        // Miasta.DrukujOdleglosciMIASTA();
        // Pliki.zapiszPlikWynikowy("");
        // Pliki.odczytajPlik("wyniki.txt");
        //AE.WypiszInfoOPopulacji();
        
        //debug PMX
        AE.GenerujLosowaPopulację(2);
        AE.KrzyzujChromosomy(Chromosom.populacja.get(0), Chromosom.populacja.get(1));
        AE.WypiszInfoOPopulacji();
        Chromosom.populacja.get(0).DrukujGeny();
        Chromosom.populacja.get(1).DrukujGeny();
        Chromosom.populacja.get(2).DrukujGeny();
        Chromosom.populacja.get(3).DrukujGeny();

        System.out.println("Geny przed mutacją: ");
        Chromosom.populacja.get(0).DrukujGeny();
        AE.MutujChromosom(Chromosom.populacja.get(0));
        System.out.println("Geny po mutacji: ");
        Chromosom.populacja.get(0).DrukujGeny();

        System.out.println("Geny przed ruletką: ");
        Chromosom.populacja.get(0).DrukujGeny();
        AE.reprodukujRuletkowo();
        System.out.println("Geny po ruletce: ");
        Chromosom.populacja.get(0).DrukujGeny();
    }
}
