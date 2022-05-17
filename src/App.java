import classes.Miasta;
import classes.Pliki;

public class App {
    public static void main(String[] args) throws Exception {
        Miasta.DrukujOdleglosciMIASTA();
        Pliki.zapiszPlikWynikowy("");
        Pliki.odczytajPlik("wyniki.txt");
    }
}
