package com.duoc.refor.ejemplo02.service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Inventario {

    private int stock = 10;
    private final ReentrantLock lock = new ReentrantLock(true);

    public void realizarVenta(String vendedor, int cantidad) {
        System.out.println(" >>> " + vendedor + " esta intentando vender " + cantidad + "unidades");

        try {

            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                // logica critica
                try {
                    if (stock >= cantidad) {
                        System.out.println("[PROCESANDO] : " + vendedor + " esta descontando del inventario ");
                        Thread.sleep(1500);
                        stock -= cantidad;
                        System.out.println("[EXITO] : venta completada por " + vendedor);
                    } else {
                        System.out.println("[ERROR] : stock insuficiente ");
                    }
                } finally {
                    lock.unlock();
                    System.out.println("LOG: Lock liberado por " + vendedor);
                }
            } else {
                System.out.println("[TIMEOUT]" + "no se pudo acceder al inventario");
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
