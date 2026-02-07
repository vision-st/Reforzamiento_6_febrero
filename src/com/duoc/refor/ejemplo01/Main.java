package com.duoc.refor.ejemplo01;

public class Main {

    public static void main(String[]args){

        Runnable tarea = new ProcesadorPago(150.89);

        Thread hilo1 = new Thread(tarea);
        hilo1.start();

    }

}
