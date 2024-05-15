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
        double po = test.calcularPO(0, 8000);
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

    @Test
    @DisplayName("Testeando getParcelas")
    public void testearGetParcelas(){
        Plantacion test = new Plantacion();
        int parcelas = test.getParcelas();
        Assertions.assertEquals(2, parcelas);
    }

    @Test
    @DisplayName("Transición Improductivo a Productivo - TRUE")
    public void testearImproductivoAProductivo(){
        Plantacion test = new Plantacion();
        boolean transicionValida = test.transicionValida(Plantacion.ESTADO_IMPRODUCTIVO, Plantacion.ESTADO_PRODUCTIVO);
        Assertions.assertTrue(transicionValida);
    }

    @Test
    @DisplayName("Transición Productivo a ConReserva - TRUE")
    public void testearProductivoAConReserva(){
        Plantacion test = new Plantacion();
        boolean transicionValida = test.transicionValida(Plantacion.ESTADO_PRODUCTIVO, Plantacion.ESTADO_CON_RESERVA);
        Assertions.assertTrue(transicionValida);
    }

    @Test
    @DisplayName("Transición ConReserva a Excedido - TRUE")
    public void testearConReservaAExcedido(){
        Plantacion test = new Plantacion();
        boolean transicionValida = test.transicionValida(Plantacion.ESTADO_CON_RESERVA, Plantacion.ESTADO_EXCEDIDO);
        Assertions.assertTrue(transicionValida);
    }

    @Test
    @DisplayName("Transición Excedido a ConReserva - TRUE")
    public void testearExcedidoAConReserva(){
        Plantacion test = new Plantacion();
        boolean transicionValida = test.transicionValida(Plantacion.ESTADO_EXCEDIDO, Plantacion.ESTADO_CON_RESERVA);
        Assertions.assertTrue(transicionValida);
    }

    @Test
    @DisplayName("Transición Improductivo a Excedido (Inválido) - FALSE")
    public void testearTransicionInvalida(){
        Plantacion test = new Plantacion();
        boolean transicionInvalida = test.transicionValida(Plantacion.ESTADO_IMPRODUCTIVO, Plantacion.ESTADO_EXCEDIDO);
        Assertions.assertFalse(transicionInvalida);
    }

    @Test
    @DisplayName("Testeando getCultivos")
    public void testearGetCultivos(){
        Plantacion test = new Plantacion();
        int cultivos = test.getCultivos();
        Assertions.assertEquals(0, cultivos);
    }

    @Test
    @DisplayName("Testeando getMetrosOcupados")
    public void testearGetMetrosOcupados(){
        Plantacion test = new Plantacion();
        double metrosOcupados = test.getMetrosOcupados();
        Assertions.assertEquals(0, metrosOcupados);
    }


}
