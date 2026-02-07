package com.duoc.refor.ejemplo04cocina.pedidos;

import com.duoc.refor.ejemplo03.Paciente;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class CocinaSincronizada {

    private final ReentrantLock lock = new ReentrantLock();
    PriorityBlockingQueue<Pedido> colaPedidos = new PriorityBlockingQueue<>();
    private final int capacidadMaxima;

    public CocinaSincronizada(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public boolean recibirPedido(Pedido p){
        lock.lock();
        try{
            if(colaPedidos.size() >= capacidadMaxima){
                return false;
            }else{
                return colaPedidos.add(p);
            }
        }finally {
            lock.unlock();
        }
    }

    public Pedido procesarPedido(){
        lock.lock();
        try{
            return colaPedidos.poll();
        }finally {
            lock.unlock();
        }
    }

    public int getCantidadPendientes(){
        return colaPedidos.size();
    }

}
