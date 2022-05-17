import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import classes.Miasta;
import classes.Pliki;
import classes.AE.AE;
import classes.AE.Chromosom;

public class App {
    public static void main(String[] args) throws Exception {
        // Miasta.DrukujOdleglosciMIASTA();
        // Pliki.zapiszPlikWynikowy("");
        // Pliki.odczytajPlik("wyniki.txt");

        AE.GenerujLosowaPopulację(50, 30);
        AE.WypiszInfoOPopulacji();
        
    }
}
