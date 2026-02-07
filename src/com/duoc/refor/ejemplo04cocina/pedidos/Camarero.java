package com.duoc.refor.ejemplo04cocina.pedidos;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Camarero implements Runnable {

    private static final AtomicInteger contadorGlobal = new AtomicInteger();

    private final GestorPedidos gestor;

    private final String nombre;

    private final Random random = new Random();

    public Camarero(int id, GestorPedidos gestor){
        this.gestor = gestor;
        this.nombre = (id == 1) ? "Rafael" : (id == 2) ? "Donnatello" : "Raphael";
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            int idPedido = contadorGlobal.getAndIncrement();
            Pedido p = new Pedido(idPedido, "Plato", PrioridadPedido.values()[random.nextInt(3)]);
            System.out.println("[Camarero ]" + nombre + "] Generando: " + p );
            gestor.agregarPedido(p);
            try{
                Thread.sleep(1000 + random.nextInt(1000));
            }catch (InterruptedException ex){
                Thread.interrupted();
            }
        }
    }
}
