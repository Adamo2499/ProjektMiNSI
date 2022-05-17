import classes.Miasta;
import classes.Pliki;

public class App {
    public static void main(String[] args) throws Exception {
        Miasta.DrukujOdleglosciMIASTA();
        Pliki.zapiszPlikWynikowy("Adamo2499");
        Pliki.odczytajPlik("wyniki.txt");
    }
}
