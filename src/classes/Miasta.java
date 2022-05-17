package classes;

public class Miasta {

    final public static double[][] ODLEGLOSCI= { 
        {1,2,3,4,51},
        {1,2,3,4,52},
        {1,2,3,4,53},
        {1,2,3,4,54},
        {1,2,3,4,55},
    };
    
    public static void DrukujOdleglosci(){
        for (int i = 0; i < ODLEGLOSCI.length; i++) {
            for (int j = 0; j < ODLEGLOSCI[0].length; j++) {
                System.out.println(ODLEGLOSCI[i][j]);
            }
        }
    }
}
