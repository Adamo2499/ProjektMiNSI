package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pliki {
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

    public static void zapiszPlikWynikowy(String napisDoDopisania) throws IOException{
        File wyniki = new File("wyniki.txt");
        FileWriter zapiszPlik = new FileWriter(wyniki);
        zapiszPlik.append(napisDoDopisania);
        zapiszPlik.close();
        System.out.println("Zapisano plik!");
    }
}
