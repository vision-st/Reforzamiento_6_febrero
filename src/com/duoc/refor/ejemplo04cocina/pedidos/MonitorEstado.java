package com.duoc.refor.ejemplo04cocina.pedidos;

public class MonitorEstado implements Runnable {

    private final CocinaSincronizada cocina;
    private volatile boolean activo = true;

    public MonitorEstado(CocinaSincronizada cocina) {
        this.cocina = cocina;
    }

    public void detener(){
        activo= false;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        while(activo){
            System.out.println("[MONITOR] Pendientes: " + cocina.getCantidadPendientes());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
