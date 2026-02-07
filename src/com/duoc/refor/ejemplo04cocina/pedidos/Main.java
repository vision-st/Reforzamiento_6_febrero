package com.duoc.refor.ejemplo04cocina.pedidos;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Semana 4\n2. Semana 5\nOpcion:  ");
        if(sc.nextLine().equals(1)){
            ejecutarS4();
        }else{
            ejecutarS5();
        }

    }

    private static void ejecutarS4() {
        GestorPedidos g = new GestorPedidos(10);
        ExecutorService ex = Executors.newFixedThreadPool(4);
        ex.execute(new Camarero(1, g));
        ex.execute(new Cocinav4(g));
        try{
            Thread.sleep(10000);
        }catch (Exception e){

        }
        ex.shutdown();
    }

    private static void ejecutarS5() {

        CocinaSincronizada c = new CocinaSincronizada(5);
        Thread monitor = new Thread(new MonitorEstado(c));
        monitor.start();
        ExecutorService ex = Executors.newFixedThreadPool(3);
        ex.execute(new CamareroConcurrencia(c, "C1"));

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ex.shutdownNow();
        monitor.interrupt();
    }
}
