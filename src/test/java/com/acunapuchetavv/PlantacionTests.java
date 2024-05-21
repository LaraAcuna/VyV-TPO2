package com.acunapuchetavv;

//Importar JUnit
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
//import org.junit.Assert;


public class PlantacionTests {

    @Test   
    @DisplayName("permitirCambioCultivos debería devolver TRUE")
    public void permitirCambioCultivosTrue(){
        Plantacion test = new Plantacion();
        boolean permiteCambio = test.permitirCambioCultivos(2);
        Assertions.assertTrue(permiteCambio);
    }

    @Test 
    @DisplayName("permitirCambioCultivos debería devolver FALSE")
    public void permitirCambioCultivosFalse(){
        Plantacion test = new Plantacion();
        boolean permiteCambio = test.permitirCambioCultivos(4);
        Assertions.assertFalse(permiteCambio);
    }


    @Test
    @DisplayName("calcularPo debería devolver 100")
    public void calcularPo(){
        Plantacion test = new Plantacion();
        double po = test.calcularPO(0, 8000);
        Assertions.assertEquals(100, po);
    }

    @Test
    @DisplayName("calcularEstado debería devolver 0 (PRODUCTIVO)")
    public void calcularEstadoDaEstadoProductivo(){
        Plantacion test = new Plantacion();
        int estado = test.calcularEstado(10);
        Assertions.assertEquals(0, estado);
    }

    @Test
    @DisplayName("calcularEstado debería devolver 3 (IMPRODUCTIVO)")
    public void calcularEstadoDaEstadoImproductivo(){
        Plantacion test = new Plantacion();
        int estado = test.calcularEstado(50);
        Assertions.assertEquals(3, estado);
    }

    @Test
    @DisplayName("calcularEstado debería devolver 1 (EXCEDIDO)")
    public void calcularEstadoDaEstadoExcedido(){
        Plantacion test = new Plantacion();
        int estado = test.calcularEstado(-22);
        Assertions.assertEquals(1, estado);
    }

    @Test
    @DisplayName("calcularEstado debería devolver 2 (CON RESERVA)")
    public void calcularEstadoDaEstadoConReserva(){
        Plantacion test = new Plantacion();
        int estado = test.calcularEstado(-5);
        Assertions.assertEquals(2, estado);
    }

    @Test
    @DisplayName("transicionValida de Improductivo a Productivo debería devolver TRUE")
    public void transicionValidaImproductivoAProductivo(){
        Plantacion test = new Plantacion();
        boolean transicionValida = test.transicionValida(Plantacion.ESTADO_IMPRODUCTIVO, Plantacion.ESTADO_PRODUCTIVO);
        Assertions.assertTrue(transicionValida);
    }

    @Test
    @DisplayName("transicionValida de Productivo a ConReserva debería devolver TRUE")
    public void transicionValidaProductivoAConReserva(){
        Plantacion test = new Plantacion();
        boolean transicionValida = test.transicionValida(Plantacion.ESTADO_PRODUCTIVO, Plantacion.ESTADO_CON_RESERVA);
        Assertions.assertTrue(transicionValida);
    }

    @Test
    @DisplayName("transicionValida de ConReserva a Excedido debería devolver TRUE")
    public void transicionValidaConReservaAExcedido(){
        Plantacion test = new Plantacion();
        boolean transicionValida = test.transicionValida(Plantacion.ESTADO_CON_RESERVA, Plantacion.ESTADO_EXCEDIDO);
        Assertions.assertTrue(transicionValida);
    }

    @Test
    @DisplayName("transicionValida de Excedido a ConReserva debería devolver TRUE")
    public void transicionValidaExcedidoAConReserva(){
        Plantacion test = new Plantacion();
        boolean transicionValida = test.transicionValida(Plantacion.ESTADO_EXCEDIDO, Plantacion.ESTADO_CON_RESERVA);
        Assertions.assertTrue(transicionValida);
    }

    @Test
    @DisplayName("transicionValida de Improductivo a Excedido (Inválido) debería devolver FALSE")
    public void TransicionInvalida(){
        Plantacion test = new Plantacion();
        boolean transicionInvalida = test.transicionValida(Plantacion.ESTADO_IMPRODUCTIVO, Plantacion.ESTADO_EXCEDIDO);
        Assertions.assertFalse(transicionInvalida);
    }

    @Test 
    @DisplayName("Plantacion, inicialización correcta de variables")
    public void Plantacion(){
        Plantacion test = new Plantacion();
        int cultivos = test.getCultivos();
        int parcelas = test.getParcelas();
        double metrosTotales = test.getMetrosTotales();
        double metrosOcupados = test.getMetrosOcupados();
        int estado = test.getEstado();
        
        Assertions.assertEquals(0, cultivos);
        Assertions.assertEquals(2, parcelas);
        Assertions.assertEquals(8000 ,metrosTotales);
        Assertions.assertEquals(0, metrosOcupados);
        Assertions.assertEquals(3, estado);
    }

    @Test
    @DisplayName("getParcelas debería devolver 2")
    public void getParcelas(){
        Plantacion test = new Plantacion();
        int parcelas = test.getParcelas();
        Assertions.assertEquals(2, parcelas);
    }

    @Test
    @DisplayName("getCultivos debería devolver 0")
    public void getCultivos(){
        Plantacion test = new Plantacion();
        int cultivos = test.getCultivos();
        Assertions.assertEquals(0, cultivos);
    }

    @Test   
    @DisplayName("getMetrosTotales debería devolver 8000")
    public void getMetrosTotales(){
        Plantacion test = new Plantacion();
        double metrosTotales = test.getMetrosTotales();
        Assertions.assertEquals(8000, metrosTotales);
    }

    @Test
    @DisplayName("getMetrosOcupados debería devolver 0")
    public void getMetrosOcupados(){
        Plantacion test = new Plantacion();
        double metrosOcupados = test.getMetrosOcupados();
        Assertions.assertEquals(0, metrosOcupados);
    }

    @Test   
    @DisplayName("getEstado debería devolver 3")
    public void getEstado(){
        Plantacion test = new Plantacion();
        int estado = test.getEstado();
        Assertions.assertEquals(3, estado);
    }

    @Test
    @DisplayName("deleteParcela deberia cambiar correctamente los valores de metrosTotales, parcelas y estado")
    public void deleteParcelaAceptado(){
        Plantacion test = new Plantacion();
        test.deleteParcela(0);
        double metrosTotales = test.getMetrosTotales();
        int parcelas = test.getParcelas();
        int estado = test.getEstado();
        Assertions.assertEquals(6000, metrosTotales);
        Assertions.assertEquals(1, parcelas);
        Assertions.assertEquals(Plantacion.ESTADO_IMPRODUCTIVO, estado);
    }

    @Test
    @DisplayName("deleteParcela NO debería provocar cambios ya que la transición provocada no fue válida")
    public void deleteParcelaRechazado(){
        Plantacion test = new Plantacion();
        /* Primero agregamos cultivos para lograr llegar a un estado inválido,
         de lo contrario siempre se pasará a "Estado Improductivo" al no haber cultivos*/
        test.addCultivos(3);
        test.deleteParcela(1);
        int parcelas = test.getParcelas();
        double metrosTotales = test.getMetrosTotales();
        int estado = test.getEstado();
        Assertions.assertEquals(2, parcelas);
        Assertions.assertEquals(8000, metrosTotales);
        Assertions.assertEquals(Plantacion.ESTADO_IMPRODUCTIVO, estado);
    }

    @Test
    @DisplayName("deleteParcela NO debería provocar cambios ya que no hay parcelas para eliminar")
    public void deleteParcelaInvalido(){
        Plantacion test = new Plantacion(); //Plantacion comienza con 2 parcelas
        test.deleteParcela(0);
        test.deleteParcela(0);
        //Se eliminan 2 parcelas chicas, ahora deberia haber 0 parcelas. Si se quiere eliminar otra mas, no se harían cambios (parcelas no debería ser -1)
        test.deleteParcela(0);
        int parcelas = test.getParcelas();
        double metrosTotales = test.getMetrosTotales();
        int estado = test.getEstado();
        Assertions.assertEquals(0, parcelas);
        Assertions.assertEquals(4000, metrosTotales);
        Assertions.assertEquals(Plantacion.ESTADO_IMPRODUCTIVO, estado);
    }

    @Test
    @DisplayName("deleteParcela NO debería provocar cambios ya que se quiere eliminar más metros de los disponibles")
    public void deleteParcelaInvalidoMetros(){
        Plantacion test = new Plantacion(); //Plantacion comienza con 8000 metros
        test.deleteParcela(2); //Se elimina una parcela grande (resta 5000 metros)
        test.deleteParcela(2); //Se quieren eliminar otros 5000 metros pero solo hay 3000
        int parcelas = test.getParcelas();
        double metrosTotales = test.getMetrosTotales();
        int estado = test.getEstado();
        Assertions.assertEquals(1, parcelas);
        Assertions.assertEquals(3000, metrosTotales);
        Assertions.assertEquals(Plantacion.ESTADO_IMPRODUCTIVO, estado);
    }

    @Test
    @DisplayName("deleteCultivos deberia cambiar correctamente los valores de metrosOcupados, cultivos y estado")
    public void deleteCultivosAceptado(){
        Plantacion test = new Plantacion();
        test.addCultivos(2);
        test.deleteCultivos(1);
        double metrosOcupados = test.getMetrosOcupados();
        int cultivos = test.getCultivos();
        int estado = test.getEstado();
        Assertions.assertEquals(2000, metrosOcupados);
        Assertions.assertEquals(1, cultivos);
        Assertions.assertEquals(Plantacion.ESTADO_IMPRODUCTIVO, estado);
    }

    @Test
    @DisplayName("deleteCultivos NO debería provocar cambios ya que la transición provocada no fue válida")
    public void deleteCultivosRechazado(){
        Plantacion test = new Plantacion();
        //Preparamos el escenario
        test.addParcela(2);
        test.addParcela(1);
        test.addCultivos(3);
        test.addCultivos(3);
        test.addCultivos(1);
        test.addCultivos(2);
        test.addCultivos(2);
        /* En este punto, los datos son:
         * MO: 22000
         * MT: 17000
         * Cultivos: 11
         * Parcelas: 4
         * Estado: EXCEDIDO
         */
        //Realizamos la acción que provoca la transición no posible
        test.deleteCultivos(3); //"provocaría" un pasaje a estado PRODUCTIVO, pero es inválido
        double metrosOcupados = test.getMetrosOcupados();
        int cultivos = test.getCultivos();
        int estado = test.getEstado();
        Assertions.assertEquals(22000, metrosOcupados);
        Assertions.assertEquals(11, cultivos);
        Assertions.assertEquals(Plantacion.ESTADO_EXCEDIDO, estado);
    }

    @Test
    @DisplayName("deleteCultivos NO debería provocar cambios ya que la cantidad de cultivos a eliminar no es válida")
    public void deleteCultivosInvalido(){
        Plantacion test = new Plantacion();
        test.addCultivos(3);
        test.addParcela(2);
        test.addCultivos(3);
        test.deleteCultivos(5);
        double metrosOcupados = test.getMetrosOcupados();
        int cultivos = test.getCultivos();
        int estado = test.getEstado();
        Assertions.assertEquals(12000, metrosOcupados);
        Assertions.assertEquals(6, cultivos);
        Assertions.assertEquals(Plantacion.ESTADO_PRODUCTIVO, estado);
    }

    @Test
    @DisplayName("deleteCultivos NO debería provocar cambios ya que la cantidad de cultivos a eliminar es mayor a la disponible")
    public void deleteCultivosInvalidoExcede(){
        Plantacion test = new Plantacion();
        test.addCultivos(2);
        test.deleteCultivos(3);
        double metrosOcupados = test.getMetrosOcupados();
        int cultivos = test.getCultivos();
        int estado = test.getEstado();
        Assertions.assertEquals(4000, metrosOcupados);
        Assertions.assertEquals(2, cultivos);
        Assertions.assertEquals(Plantacion.ESTADO_IMPRODUCTIVO, estado);
    }
}
