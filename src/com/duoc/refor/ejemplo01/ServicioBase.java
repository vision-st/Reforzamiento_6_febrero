package com.duoc.refor.ejemplo01;

public class ServicioBase {

    protected void conectarPasarela(){
        System.out.println("[LOG]: Estableciendo conexion segura con transbank");
        try {
            Thread.sleep(5000);
            System.out.println("-----");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    protected void registrarLog(String mensaje){
        System.out.println("[Auditoria]: " + mensaje);
    }
}
