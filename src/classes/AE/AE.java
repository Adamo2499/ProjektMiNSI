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





    public static void KrzyzujChromosomy(Chromosom chromosom1, Chromosom chromosom2){
        
        int dlugoscChromosomu=chromosom1.geny.length;
        int[] geny1=chromosom1.geny;
        int[] geny2=chromosom2.geny;
        int[] noweGeny1= new int[geny1.length];
        int[] noweGeny2= new int[geny2.length];

        //wyznaczanie indeksu pocżatkowego i końcowego
        int IndexPoczatekowy=(int)(Math.random()*(dlugoscChromosomu/2));
        int IndexKoncowy=(int)(Math.random()*(dlugoscChromosomu/2))+IndexPoczatekowy;
        System.out.println("Początek: "+IndexPoczatekowy+" Koniec: "+IndexKoncowy);// debug 
        //przepisywanie
        boolean przepisuj= false; 
        for (int i = 0; i < geny1.length; i++) {
            //wykrywanie kiedy trzeba przepisywać
            if((i>=IndexPoczatekowy)&&(i<=IndexKoncowy)){
                przepisuj=true;
            }else{
                przepisuj=false;
            }
            //tak wiem że da się w jednej potem się poprawi xDDD
            if(przepisuj){
                noweGeny1[i]=geny2[i];
                noweGeny2[i]=geny1[i];
            }else{
                noweGeny1[i]=999;
                noweGeny2[i]=999;
            }
        }
        przepisuj= false; 
        for (int i = 0; i < geny1.length; i++) {
            if(noweGeny1[i]==999){// operacje na nieprzepisanych
                //sprawdzanie czy liczba przypadkiem nie znajduje się w łańcuchu
                boolean LiczbaZnajdujeSięWŁańcuchu=false;

                for (int j = 0; j < noweGeny2.length; j++) {
                    LiczbaZnajdujeSięWŁańcuchu=false;
                    for (int j2 = 0; j2 < noweGeny2.length; j2++) {
                        if (noweGeny1[j]==geny1[j2]) {
                            
                        }
                    }
                    
                }

            }

    
        }

        new Chromosom(noweGeny1);
        new Chromosom(noweGeny2);

        //WypiszInfoOPopulacji(); debug
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
