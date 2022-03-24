import tresenrayabackend.TresEnRaya;

public class Main {

    public static void main(String [] arg) {
        TresEnRaya tresEnRaya = new TresEnRaya();
       int [][] jugadas =  new int[9][2];
       boolean terminar = false;

        jugadas[0][0] = 2;
        jugadas[0][1] = 2;
        jugadas[1][0] = 1;
        jugadas[1][1] = 1;
        jugadas[2][0] = 0;
        jugadas[2][1] = 0;
        jugadas[3][0] = 0;
        jugadas[3][1] = 2;
        jugadas[4][0] = 2;
        jugadas[4][1] = 1;
        jugadas[5][0] = 2;
        jugadas[5][1] = 0;

        int i = 0;
        while (!terminar){
            tresEnRaya.jugar(jugadas[i][0],jugadas[i][1]);
            terminar = tresEnRaya.hayTresEnRaya() || tresEnRaya.tie();
            i++;
        }
       System.out.println("Estado Final:"+"\n"+tresEnRaya.toString());

    }

}




