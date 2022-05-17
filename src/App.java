import classes.AE.AE;

public class App {
    public static void main(String[] args) throws Exception { 
        //wszystkie duże komponenty sklejone w całość są w mainie


        // Miasta.DrukujOdleglosciMIASTA();
        // Pliki.zapiszPlikWynikowy("");
        // Pliki.odczytajPlik("wyniki.txt");

        AE.GenerujLosowaPopulację(50, 30);
        AE.WypiszInfoOPopulacji();
    }
}
