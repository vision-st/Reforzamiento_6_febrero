package com.duoc.refor.ejemplo04cocina.pedidos;

public class Cocinav4 implements Runnable {

    private final GestorPedidos gestor;

    public Cocinav4(GestorPedidos gestor) {
        this.gestor = gestor;
    }

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try{
                Pedido p = gestor.tomarPedido();
                System.out.println("[COCINA] Preparando " + p);
                Thread.sleep(5000);
                System.out.println("[COCINA] Pedido completado " + p);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }
}
