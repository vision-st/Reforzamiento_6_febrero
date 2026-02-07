package com.duoc.refor.ejemplo02.main;

import com.duoc.refor.ejemplo02.service.Inventario;

public class Main {

    public static void main(String[]args){
        Inventario tienda = new Inventario();

        Thread v1 = new Thread(()-> tienda.realizarVenta("Vendedor A", 5)  );
        Thread v2 = new Thread(()-> tienda.realizarVenta("Vendedor B", 7)  );
        Thread v3 = new Thread(()-> tienda.realizarVenta("Vendedor C", 2)  );
        Thread v4 = new Thread(()-> tienda.realizarVenta("Vendedor D", 2)  );
        v1.start();
        v2.start();
        v3.start();
        v4.start();
    }

}
