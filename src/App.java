import classes.Miasta;
import classes.AE.AE;

public class App {
    public static void main(String[] args) throws Exception { 
        //wszystkie duże komponenty sklejone w całość są w mainie


        // Miasta.DrukujOdleglosciMIASTA();
        // Pliki.zapiszPlikWynikowy("");
        // Pliki.odczytajPlik("wyniki.txt");

        new Miasta(); //Inicjowanie domyślnego zestawu miast ( Miasta.java linijka 45)

        AE.GenerujLosowaPopulację(50, 30);//przyjmuje jako argumenty wielkość populacji i ilośc genów
        //Spostrzeżenie: ilość genów zawsze będzie równa ilości miast co oznacza że można to w przyszłości uprościć tak aby funcja 
        //               GenerujLosowąPopulację() przyjmowała jako argument tylko wielkośc populacji 

        AE.WypiszInfoOPopulacji();
    }
}
