package classes.AE;

public class AE {
    //wszystko co związane z tworzeniem i zarządzaniem chromosomami (Czyli algorytm ewolucyjny)


    //Adnotacja: Tworzenie nowej populacji (krzyżowanie, ruletka, mutacje itp)

    //W przypadku np krzyżowania chcemy stworzyć nową populację w oparciu o starą
    //W tym przypadku najpierw trzeba przepisać starą populację na inny array i wyczyścić array w chromosomie, aby zrobić miejsce dla nowej populacji
    //Można wymyślić inne rozwiązanie, ale zaletą tego jest fakt że po wykonaniu funkcji operującej na populacji nie tworzymy nowych zmiennych(poza funkcją)
    
    //tj w kodzie to wygląda mniej więcej tak:

    //public static ArrayList<Chromosom> StaraPopulacja = Chromosom.populacja;
    //Chromosom.populacja.clear();
    
    //for(i=0;i<StaraPopulacja.size();i++){
    //  int[] NoweGeny= new int[StaraPopulacja.get(0).geny.length];
    //  operacje na chromosomie
    //  new Chromosom(NoweGeny); <--- można stworzyć nowy chromosom podając jako argument tablicę genów 
    //                                z  racji na fakt jak napisany jest konstruktor nowy chromosom jest automatycznie wpisywany do populacji 
    //                                i natychmiastowo obliczane jest jego przystosowanie
    //}

    public static void KrzyzujChromosomy(Chromosom chromosom1, Chromosom chromosom2){
        
        int dlugoscChromosomu=chromosom1.geny.length/2;
        //wyznaczanie indeksu pocżatkowego i końcowego
        int IndexPoczatekowy=(int)(Math.random()*(dlugoscChromosomu));
        int IndexKoncowy=(int)(Math.random()*(dlugoscChromosomu))+IndexPoczatekowy;
        // System.out.println("Początek: "+IndexPoczatekowy+" Koniec: "+IndexKoncowy);// debug 
        //przepisywanie 




        int indexodwzorowania=0;
        boolean ZnajdujeSięWCiaguOdwzorowania=false;
        for (int i = 0; i < dlugoscChromosomu; i++) {
             if((i>=IndexPoczatekowy)&&(i<=IndexKoncowy)){

                 //ChromosomPMX.arrayChromosomy.get(ChromosomPMX.arrayChromosomy.size()-1).chromosom[i]=this.chromosom[i];   
             }else{
                 //sprawdzamy czy element znajduje się w ciągu odwzorowania
                
                 for (int j = IndexPoczatekowy; j < IndexKoncowy; j++) {
                     ZnajdujeSięWCiaguOdwzorowania=false;

                     if(chromosom1.geny[i]==chromosom2.geny[j]){
                         ZnajdujeSięWCiaguOdwzorowania=true;
                         indexodwzorowania=j;
                     }
                 }

        //         //jeżeli tak to odwzorowujemy
        //         //jeżeli nie to przepisujemy
                
                //  if (ZnajdujeSięWCiaguOdwzorowania) {
                //      ChromosomPMX.arrayChromosomy.get(ChromosomPMX.arrayChromosomy.size()-1).chromosom[i]=drugirodzic.chromosom[indexodwzorowania];
                //  }else{
                //      ChromosomPMX.arrayChromosomy.get(ChromosomPMX.arrayChromosomy.size()-1).chromosom[i]=drugirodzic.chromosom[i];
                //  }
                
             }     
         }

    }

    public static void GenerujLosowaPopulację(int wielkoscPopulacji, int iloscGenow){//funkcja tworzy nową losową populację 
        for (int i = 0; i < wielkoscPopulacji; i++) {
            new Chromosom(iloscGenow);         
        }
    }

    public static double WyznaczOptimumPopulacji(){//wyznacza najmniejszą wartość przystosowania w całej populacji
        double optimumPopulacji = Double.MAX_VALUE, wartoscFP=0.0;
        for (int i = 0; i < Chromosom.populacja.size(); i++) {
            wartoscFP = Chromosom.populacja.get(i).przystosowanieChromosomu;
            if(wartoscFP < optimumPopulacji){
                optimumPopulacji = wartoscFP;
            }
        }
        return optimumPopulacji;
    }

    public static void WypiszInfoOPopulacji(){//zmienioned
        System.out.println("Wielkość populacji: "+Chromosom.populacja.size());
        System.out.println("Nr osobnika i wartość funkcji przystosowania:");
        for (int i = 0; i < Chromosom.populacja.size(); i++) {
            System.out.println("Osobnik nr "+i+"    Przystosowanie: "+ String.format("%.5f", Chromosom.populacja.get(i).przystosowanieChromosomu));
        }
        System.out.println("Optimum funkcji: "+WyznaczOptimumPopulacji());
    }
    

    //gen = miasto
    //Chromosom = droga do celu


    // populacja to największa ilość trans między miastami (na start 20, a później do zmiany)
    // chromosom[iloscmiast] -> trasa między miastami
    // na chromosom składa się liczba genów równa ilości miast
    // każdy gen musi być reprezentowany przez inną liczbę od 0 do liczbamiast
    
    // funkcja przystosowania danego chromosomu to suma drogi między wszystkimi miastami w kolejności wskazanej przez geny chromosomu
    // optymalizacja polega na znalezieniu jak najkrótszej drogi pozwalającej na przebycie wszystkich wskazanych miast
    
}
