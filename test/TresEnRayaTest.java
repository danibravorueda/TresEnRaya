import org.junit.jupiter.api.Test;
import tresenrayabackend.TresEnRaya;

import static org.junit.jupiter.api.Assertions.*;

class TresEnRayaTest {

    TresEnRaya tresEnRaya = new TresEnRaya();


    @Test
    void testInserccionValida(){
        boolean seInserto = tresEnRaya.jugar(0,2);
        assertTrue(seInserto);
    }

    @Test
    void testInserccionNoValida(){
        boolean noSeInserto = tresEnRaya.jugar(3,3);
        assertFalse(noSeInserto);
    }

    @Test
    void testInserccionCasillaOcupada(){
        tresEnRaya.jugar(1,0);
        boolean ultimaInserccion = tresEnRaya.jugar(1,0);
        assertFalse(ultimaInserccion);
    }


    @Test
    void testNoExisteTresEnRayaTableroLleno1(){
        tresEnRaya.jugar(1,1);
        tresEnRaya.jugar(0,0);
        tresEnRaya.jugar(2,0);
        tresEnRaya.jugar(0,2);
        tresEnRaya.jugar(0,1);
        tresEnRaya.jugar(2,1);
        tresEnRaya.jugar(2,2);
        tresEnRaya.jugar(1,2);
        tresEnRaya.jugar(1,0);

        boolean noExiste = tresEnRaya.tie();
        assertTrue(noExiste);
    }

    @Test
    void testNoExisteTresEnRayaTableroLleno2(){
        tresEnRaya.jugar(0,0);  // x
        tresEnRaya.jugar(1,1);  // o
        tresEnRaya.jugar(2,0);  // x
        tresEnRaya.jugar(1,0); // o
        tresEnRaya.jugar(0,2); // x
        tresEnRaya.jugar(0,1); // o
        tresEnRaya.jugar(2,1); // x
        tresEnRaya.jugar(2,2); // 0
        tresEnRaya.jugar(1,2); // x
        boolean noExiste = tresEnRaya.tie();
        assertTrue(noExiste);
    }

    @Test
    void testNoExisteTresEnRayaTableroLleno3(){
        tresEnRaya.jugar(0,0);
        tresEnRaya.jugar(2,2);
        tresEnRaya.jugar(2,0);
        tresEnRaya.jugar(1,0);
        tresEnRaya.jugar(0,1);
        tresEnRaya.jugar(0,2);
        tresEnRaya.jugar(1,1);
        tresEnRaya.jugar(2,1);
        tresEnRaya.jugar(1,2);

        boolean noExiste = tresEnRaya.tie();
        assertTrue(noExiste);
    }

    @Test
    void testNoExisteTresEnRayaTableroLleno4(){
        tresEnRaya.jugar(2,0);
        tresEnRaya.jugar(0,0);
        tresEnRaya.jugar(2,2);
        tresEnRaya.jugar(2,1);
        tresEnRaya.jugar(1,0);
        tresEnRaya.jugar(0,2);
        tresEnRaya.jugar(1,1);
        tresEnRaya.jugar(1,2);
        tresEnRaya.jugar(0,1);

        boolean noExiste = tresEnRaya.tie();
        assertTrue(noExiste);
    }


   @Test
   void testExisteTresEnRayFila(){
        tresEnRaya.jugar(0,0); // x
        tresEnRaya.jugar(2,1);
        tresEnRaya.jugar(0,1); // x
        tresEnRaya.jugar(2,2);
        tresEnRaya.jugar(0,2); // x

        boolean ganadorFila = tresEnRaya.hayTresEnRaya();
        assertTrue(ganadorFila);
   }

   @Test
   void testExisteTresEnRayaColumna(){
        tresEnRaya.jugar(0,0);
        tresEnRaya.jugar(0,2);
        tresEnRaya.jugar(2,0);
        tresEnRaya.jugar(2,2);
        tresEnRaya.jugar(1,1);
        tresEnRaya.jugar(1,2);

        boolean ganadorColumna =  tresEnRaya.hayTresEnRaya();
        assertTrue(ganadorColumna);
   }

   @Test
   void testExisteTresEnRayaTableroLleno(){
       tresEnRaya.jugar(0,0);
       tresEnRaya.jugar(0,2);
       tresEnRaya.jugar(2,2);
       tresEnRaya.jugar(1,1);
       tresEnRaya.jugar(2,0);
       tresEnRaya.jugar(1,0);
       tresEnRaya.jugar(0,1);
       tresEnRaya.jugar(1,2);
       tresEnRaya.jugar(2,1);

       boolean existeTresEnRaya = tresEnRaya.hayTresEnRaya();
       assertTrue(existeTresEnRaya);
   }


    @Test
    void testExisteTresEnRayaDiagonalPrincipal(){ // JUGADOR1
        tresEnRaya.jugar(0,0);
        tresEnRaya.jugar(0,2);
        tresEnRaya.jugar(2,2);
        tresEnRaya.jugar(2,0);
        tresEnRaya.jugar(1,1);

        boolean existeTresEnRayaDP = tresEnRaya.hayTresEnRaya();
        assertTrue(existeTresEnRayaDP);
    }

    @Test
    void testExisteTresEnRayaDiagonalSecundario(){ // JUGADOR2
         tresEnRaya.jugar(0,0);
        tresEnRaya.jugar(0,2);
        tresEnRaya.jugar(2,2);
        tresEnRaya.jugar(1,1);
        tresEnRaya.jugar(0,1);
        tresEnRaya.jugar(2,0);

        boolean existeTresEnRayaDS = tresEnRaya.hayTresEnRaya();
        assertTrue(existeTresEnRayaDS);
    }

    @Test
    void testObtenerGanadorJugador1(){
        tresEnRaya.jugar(0,0);
        tresEnRaya.jugar(2,0);
        tresEnRaya.jugar(2,2);
        tresEnRaya.jugar(0,2);
        tresEnRaya.jugar(1,1);

        String jugador1 = tresEnRaya.obtenerGanador();

        assertEquals("JUGADOR1",jugador1);
    }

    @Test
    void testObtenerGanadorJugador2(){
        tresEnRaya.jugar(0,0);
        tresEnRaya.jugar(2,2);
        tresEnRaya.jugar(0,2);
        tresEnRaya.jugar(0,1);
        tresEnRaya.jugar(1,0);
        tresEnRaya.jugar(2,0);
        tresEnRaya.jugar(1,2);
        tresEnRaya.jugar(2,1);

        String jugador2 = tresEnRaya.obtenerGanador();
        assertEquals("JUGADOR2",jugador2);
    }

    @Test
    void testObtenerGanadorVacioEmpate(){
        tresEnRaya.jugar(0,0);
        tresEnRaya.jugar(2,2);
        tresEnRaya.jugar(2,0);
        tresEnRaya.jugar(1,0);
        tresEnRaya.jugar(0,2);
        tresEnRaya.jugar(1,2);
        tresEnRaya.jugar(1,1);
        tresEnRaya.jugar(0,1);
        tresEnRaya.jugar(2,1);

        String vacio = tresEnRaya.obtenerGanador();
        assertEquals("VACIO",vacio);
    }
}