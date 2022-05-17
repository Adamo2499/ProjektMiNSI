import java.util.ArrayList;

import classes.Miasta;
import classes.Pliki;
import classes.AE.AE;
import classes.AE.Chromosom;

public class App {
    public static void main(String[] args) throws Exception {
        // Miasta.DrukujOdleglosciMIASTA();
        // Pliki.zapiszPlikWynikowy("");
        // Pliki.odczytajPlik("wyniki.txt");

        ArrayList<double[]> populacjaTras = AE.utworzPopulacje();
        AE.WypiszInfoOPopulacji(populacjaTras);

    }
}
