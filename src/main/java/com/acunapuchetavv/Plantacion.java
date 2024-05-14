package com.acunapuchetavv;

public class Plantacion {
    //Atributos
    private double metrosTotales;
    private double metrosOcupados;
    private int parcelas;
    private int cultivos;
    private int estado;
    final static int PARCELA_CHICA = 0;
    final static int PARCELA_MEDIANA = 1;
    final static int PARCELA_GRANDE = 2;
    final static int LIMITE_CULTIVOS = 3;
    final static int ESTADO_PRODUCTIVO = 0;
    final static int ESTADO_EXCEDIDO = 1;
    final static int ESTADO_CON_RESERVA = 2;
    final static int ESTADO_IMPRODUCTIVO = 3;

    //Métodos Privados
    private double cantidadTipo(int tipoParcela){
        if(tipoParcela == PARCELA_CHICA)
            return 2000;
        else if(tipoParcela == PARCELA_MEDIANA)
            return 4000;
        else if(tipoParcela == PARCELA_GRANDE)
            return 5000;
        return 0; //Caso no contemplado
    }

    private boolean permitirCambioCultivos(int cantidad){
        return cantidad > 0 && cantidad <= LIMITE_CULTIVOS;
    }

    private double calcularPO(){
        return 100 - ((metrosOcupados*100)/metrosTotales);
    }

    private int calcularEstado(){
        double po = calcularPO();
        if(po > 20)
            return ESTADO_IMPRODUCTIVO;
        if(po <= 0 && po <= 20)
            return ESTADO_PRODUCTIVO;
        if(po >= -20 && po < 0)
            return ESTADO_CON_RESERVA;
        return ESTADO_EXCEDIDO;
    }

    private boolean transicionValida(){
        int nuevo_estado = calcularEstado();
        if(estado == ESTADO_CON_RESERVA || estado == nuevo_estado)
            return true;
        if(estado == ESTADO_IMPRODUCTIVO && nuevo_estado != ESTADO_PRODUCTIVO)
            return false;
        if(estado == ESTADO_PRODUCTIVO && nuevo_estado == ESTADO_EXCEDIDO)
            return false;
        if(estado == ESTADO_EXCEDIDO && nuevo_estado != ESTADO_CON_RESERVA)
            return false;
        return true;
    }

    private void restaurar(int cultivos_previo, int parcelas_previo, double metros_totales_previo, double metros_ocupados_previo){
        cultivos = cultivos_previo;
        parcelas = parcelas_previo;
        metrosTotales = metros_totales_previo;
        metrosOcupados = metros_ocupados_previo;
    }

    private void confirmar_cambio(int cultivos_previo, int parcelas_previo, double metros_totales_previo, double metros_ocupados_previo){
        if(transicionValida()){
            estado = calcularEstado();
        }else{
            restaurar(cultivos_previo, parcelas_previo, metros_totales_previo, metros_ocupados_previo);
        }
    }

    //Métodos (eventos) Públicos
    public Plantacion(){
        this.cultivos = 0;
        this.parcelas = 2;
        this.metrosTotales = 8000;
        this.metrosOcupados = 0;
        this.estado = ESTADO_IMPRODUCTIVO;
    }

    public int getParcelas(){
        return parcelas;
    }

    public int getCultivos(){
        return cultivos;
    }

    public double getMetrosTotales(){
        return metrosTotales;
    }

    public double getMetrosOcupados(){
        return metrosOcupados;
    }

    public int getEstado(){
        return estado;
    }
    
    public void addParcela(int tipoParcela){
        double metros_totales_previo = metrosTotales;
        int parcelas_previo = parcelas;
        metrosTotales+=cantidadTipo(tipoParcela);
        parcelas++;
        confirmar_cambio(cultivos, parcelas_previo, metros_totales_previo, metrosOcupados);
    }

    public void deleteParcela(int tipoParcela){
        if(parcelas > 0){
            int parcelas_previo = parcelas;
            double metros_totales_previo = metrosTotales;
            metrosTotales-=cantidadTipo(tipoParcela);
            parcelas--;
            confirmar_cambio(cultivos, parcelas_previo, metros_totales_previo, metrosOcupados);
        }
    }

    public void addCultivos(int cantidad){
        if(permitirCambioCultivos(cantidad)){
            double metros_ocupados_previo = metrosOcupados;
            int cultivos_previo = cultivos;
            metrosOcupados+=cantidad * 2000;
            cultivos+=cantidad;
            confirmar_cambio(cultivos_previo, parcelas, metrosTotales, metros_ocupados_previo);
        }
    }

    public void deleteCultivos(int cantidad){
        if(permitirCambioCultivos(cantidad) && cultivos - cantidad >= 0){
            double metros_ocupados_previo = metrosOcupados;
            int cultivos_previo = cultivos;
            metrosOcupados-=cantidad * 2000;
            cultivos-=cantidad;
            confirmar_cambio(cultivos_previo, parcelas, metrosTotales, metros_ocupados_previo);
        }
    }

}
