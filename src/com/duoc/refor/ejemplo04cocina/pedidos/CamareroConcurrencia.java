package com.duoc.refor.ejemplo04cocina.pedidos;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class CamareroConcurrencia implements Runnable {

    private static final AtomicInteger contador = new AtomicInteger(1);

    private final CocinaSincronizada cocina;

    private final String nombre;

    public CamareroConcurrencia(CocinaSincronizada cocina, String nombre) {
        this.cocina = cocina;
        this.nombre = nombre;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){

            Pedido p = new Pedido(contador.getAndIncrement(), "Plato", PrioridadPedido.BAJA);
            if(cocina.recibirPedido(p)){
                System.out.println("[" + nombre + "] Enviado " + p);
            }else{
                System.out.println("[" + nombre + "] Rechazado la cocina esta llena ");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
