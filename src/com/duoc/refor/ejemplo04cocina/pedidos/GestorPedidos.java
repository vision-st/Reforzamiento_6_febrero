package com.duoc.refor.ejemplo04cocina.pedidos;

import java.util.concurrent.PriorityBlockingQueue;

public class GestorPedidos {

    private final PriorityBlockingQueue<Pedido> colaPedidos;

    public GestorPedidos(int capacidad) {
        this.colaPedidos = new PriorityBlockingQueue<>(capacidad);
    }

    public void agregarPedido(Pedido pedido){
        colaPedidos.put(pedido);
    }

    public Pedido tomarPedido(){
        try {
            return colaPedidos.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}
