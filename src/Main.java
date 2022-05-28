import classes.Miasta;
import classes.AE.AE;
import classes.AE.Chromosom;

public class Main {
    public static void main(String[] args) throws Exception { 
        //wszystkie duże komponenty sklejone w całość są w mainie
        new Miasta(); //Inicjowanie domyślnego zestawu miast ( Miasta.java linijka 45)

        System.out.print("\033[H\033[2J");// to coś czyści konsolę 


        // Miasta.DrukujOdleglosciMIASTA();
        // Pliki.zapiszPlikWynikowy("");
        // Pliki.odczytajPlik("wyniki.txt");



        //AE.GenerujLosowaPopulację(50, 30);//przyjmuje jako argumenty wielkość populacji i ilośc genów

       

        //Spostrzeżenie: ilość genów zawsze będzie równa ilości miast co oznacza że można to w przyszłości uprościć tak aby funcja 
        //               GenerujLosowąPopulację() przyjmowała jako argument tylko wielkośc populacji 
        //AE.WypiszInfoOPopulacji();
        
        //debug PMX
        AE.GenerujLosowaPopulację(2, 10);
        AE.KrzyzujChromosomy(Chromosom.populacja.get(0), Chromosom.populacja.get(1));
        Chromosom.populacja.get(0).DrukujGeny();
        Chromosom.populacja.get(1).DrukujGeny();
        Chromosom.populacja.get(2).DrukujGeny();
        Chromosom.populacja.get(3).DrukujGeny();
    }
}
