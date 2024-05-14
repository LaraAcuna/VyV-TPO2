package com.acunapuchetavv;

//Importar JUnit
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
//import org.junit.Assert;


public class PlantacionTests {
    @Test
    public void calcularPo(){
        Plantacion test = new Plantacion();
        double po = test.calcularPO();
        Assertions.assertEquals(100, po);
    }

    @Test
    @DisplayName("Estado es 3 (IMPRODUCTIVO)")
    public void testearEstadoImproductivo(){
        Plantacion test = new Plantacion();
        int estado = test.calcularEstado(50);
        Assertions.assertEquals(3, estado);
    }

    @Test
    @DisplayName("Estado es 0 (PRODUCTIVO)")
    public void testearEstadoProductivo(){
        Plantacion test = new Plantacion();
        int estado = test.calcularEstado(10);
        Assertions.assertEquals(0, estado);
    }

    @Test
    @DisplayName("Estado es 1 (EXCEDIDO)")
    public void testearEstadoExcedido(){
        Plantacion test = new Plantacion();
        int estado = test.calcularEstado(-22);
        Assertions.assertEquals(1, estado);
    }

    @Test
    @DisplayName("Estado es 2 (CON RESERVA)")
    public void testearEstadoConReserva(){
        Plantacion test = new Plantacion();
        int estado = test.calcularEstado(-5);
        Assertions.assertEquals(2, estado);
    }

}
