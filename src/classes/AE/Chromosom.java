package classes.AE;

import java.util.ArrayList;
import java.util.Random;
import classes.Miasta;

public class Chromosom {
    //Chromosom jego tworzenie i parametry 

    public double przystosowanieChromosomu;
    int[] geny;
    public static ArrayList<Chromosom> populacja = new ArrayList<Chromosom>();

    public Chromosom(int iloscgenow){//konstruktor chromosomu wykorzystujący ilosc genów jako argument
        this.geny = GenerowanieGenow(iloscgenow);
        this.WyznaczPrzystosowanieChromosomu(); //chromosom zaraz po poznaniu swojego zestawu genów jest w stanie wyznaczyć swoje przystosowanie więc to robi
        populacja.add(this);
    }

    public Chromosom(int[] geny){//konstruktor chromosomu wykorzystujący gotowy zestaw genów jako argument
        this.geny = geny;
        this.WyznaczPrzystosowanieChromosomu();//chromosom zaraz po poznaniu swojego zestawu genów jest w stanie wyznaczyć swoje przystosowanie więc to robi
        populacja.add(this);
    }

    int[] GenerowanieGenow(int iloscgenow){//generowanie tablicy z genami, każdy gen występuje w tablicy tylko raz
        int[] geny =new int[iloscgenow];
        Random rng = new Random();
        int miasto;
        ArrayList <Integer> wykorzystaneMiasta = new ArrayList<Integer>();
        //dodanie tablicy uzytych indeksów w celu wykluczenia powtórzeń
        for(int i=0;i<iloscgenow;i++){
            do {
                miasto = rng.nextInt(iloscgenow);
            } 
            while (wykorzystaneMiasta.contains(miasto));
            wykorzystaneMiasta.add(miasto);
            geny[i]=miasto;
        }
        return geny;
    }

    void WyznaczPrzystosowanieChromosomu(){//przeniosłem z AE 
        // Chromosom zaraz po tym jak "pozna swój zestaw genów" w sumie może określić swoje przystosowanie
        // Dlatego wyznacznaie przystosowania znajduje się już w konstruktorze
        // Jednak w przypadku w którym modyfikujemy zestaw genów bez tworzenia nowego chromosomu będzie trzeba pamiętać aby tą funkcję wywołać 
        double wartoscFunkcjiPrzystosowania = 0.0;
        for (int i = 1; i < geny.length; i++) {
            wartoscFunkcjiPrzystosowania=Miasta.odleglosciUzytkownika[geny[i-1]][geny[i]]; 
        }
        przystosowanieChromosomu=wartoscFunkcjiPrzystosowania;
    }

    public void DrukujGeny(){// do debugowania XD
        for (int i = 0; i < geny.length; i++) {
            System.out.print(geny[i]+"|");
        }
        System.out.println();
    }
}
