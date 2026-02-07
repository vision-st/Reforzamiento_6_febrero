package com.duoc.refor.ejemplo01;

public class ProcesadorPago extends ServicioBase implements Runnable {

    private double monto;

    public ProcesadorPago(double monto) {
        this.monto = monto;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Procesando pado de: $ " + monto);
        conectarPasarela();
        System.out.println("Pago de: $ " + monto + " aprobado");
    }
}
