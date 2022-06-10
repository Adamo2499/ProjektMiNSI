package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pliki {
    //zapisywanie do pliku i wyciąganie rzeczy z pliku 

    public static void odczytajPlik(String sciezkaDoPliku) throws FileNotFoundException, IOException {
        File plikWejsciowy = new File(sciezkaDoPliku);
        FileReader odczytajPlik = new FileReader(plikWejsciowy);
        BufferedReader czytnik = new BufferedReader(odczytajPlik);
        System.out.println("Kodowanie pliku: "+odczytajPlik.getEncoding()); 
        String linia = czytnik.readLine();
        while(linia != null){
            System.out.println( linia);
            linia = czytnik.readLine();
        }    
        odczytajPlik.close();
    }

    public static void zapiszPlikCzasowy(String napisDoDopisania) throws IOException{
        File wyniki = new File("czas.txt");
        FileWriter zapiszPlik = new FileWriter(wyniki);
        zapiszPlik.append(napisDoDopisania);
        zapiszPlik.close();
    }

    public static void zapiszPlikWynikowy(String napisDoDopisania, int iloscmiast, int rozmiarPopulacji, int powtorzenie) throws IOException{
        File wyniki = new File("wyniki\\Miasta["+iloscmiast+"] PopulacjaSize["+rozmiarPopulacji+"] Wynik["+powtorzenie+"].txt");
        FileWriter zapiszPlik = new FileWriter(wyniki);
        zapiszPlik.write("nrOsobnika current best_current best_global\r\n");
        zapiszPlik.append(napisDoDopisania);
        zapiszPlik.close();
    }
    public static void zapiszPlikWynikowySrednia(String napisDoDopisania, int iloscmiast, int rozmiarPopulacji) throws IOException{
        File wyniki = new File("wyniki\\miasta["+iloscmiast+"] PopulacjaSize["+rozmiarPopulacji+"] Srednia.txt");
        FileWriter zapiszPlik = new FileWriter(wyniki);
        zapiszPlik.write("nrOsobnika current best_current best_global\r\n");
        zapiszPlik.append(napisDoDopisania);
        zapiszPlik.close();
        System.out.println("Zakończono sprawdzanie dla populacji");
    }
}
