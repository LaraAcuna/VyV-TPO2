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
    @DisplayName("testando getParcela")
    public void testearGetParcelas(){
        Plantacion thisPlantacion = new Plantacion();

        int parcelas = thisPlantacion.getParcelas();

        Assertions.assertEquals(2, parcelas);
    }

    @Test   
    @DisplayName("testando getMetrosTotales")
    public void testearGetMetrosTotales(){
        Plantacion thisPlantacion = new Plantacion();

        double metrosTotales = thisPlantacion.getMetrosTotales();

        Assertions.assertEquals(8000, metrosTotales);
    }

    @Test   
    @DisplayName("testando getEstado")
    public void testearGetEstados(){
        Plantacion thisPlantacion = new Plantacion();

        int estado = thisPlantacion.getEstado();

        Assertions.assertEquals(3, estado);
    }

    @Test   
    @DisplayName("testando permitirCambioCultivos")
    public void testearPermiteCambioCultivoTrue(){
        Plantacion thisPlantacion = new Plantacion();

        boolean permiteCambio = thisPlantacion.permitirCambioCultivos(2);

        Assertions.assertEquals(true, permiteCambio);
    }

    @Test 
    @DisplayName("testando permitirCambioCultivos")
    public void testearPermiteCambioCultivoFalse(){
        Plantacion thisPlantacion = new Plantacion();

        boolean permiteCambio = thisPlantacion.permitirCambioCultivos(4);

        Assertions.assertEquals(false, permiteCambio);
    }

    @Test 
    @DisplayName("testando permitirCambioCultivos")
    public void testearConstructor(){
        Plantacion thisPlantacion = new Plantacion();

        int cultivos = thisPlantacion.getCultivos();
        int parcelas = thisPlantacion.getParcelas();
        double metrosTotales = thisPlantacion.getMetrosTotales();
        double metrosOcupados = thisPlantacion.getMetrosOcupados();
        int estado = thisPlantacion.getEstado();
        
        Assertions.assertEquals(0, cultivos);
        Assertions.assertEquals(2, parcelas);
        Assertions.assertEquals(8000,metrosTotales);
        Assertions.assertEquals(0, metrosOcupados);
        Assertions.assertEquals(3, estado);

    }


}
