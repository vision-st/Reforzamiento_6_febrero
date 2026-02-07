package com.duoc.refor.ejemplo03;

import com.sun.jdi.event.ThreadDeathEvent;

import java.util.concurrent.PriorityBlockingQueue;

public class Urgencia {

    public static void main(String[]args) throws InterruptedException {
        PriorityBlockingQueue<Paciente> colaTriage = new PriorityBlockingQueue<>();

        //productor
        Thread recepcion = new Thread(()-> {
            colaTriage.put(new Paciente("Pepe - resfriado", 5));
            colaTriage.put(new Paciente("Pepa - Infarto", 1));
            colaTriage.put(new Paciente("Oscar - Fractura", 2));
            System.out.println("LOG:::> Recepcion registro 3 pacientes");
        });

        //consumidor
        Thread medico = new Thread(()->{
            try{
                System.out.println("Medico listo para atender...");
                while(true){
                    Paciente paciente = colaTriage.take();
                    System.out.println("ATENDIENDO A : " + paciente);
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });
        recepcion.start();
        Thread.sleep(500);
        medico.start();
    }

}
