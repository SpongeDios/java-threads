package com.hector.hilos.app;

import com.hector.hilos.app.threads.NombreThread;

public class EJemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new NombreThread("Hector");
        hilo.start();
        //Thread.sleep(1);

        Thread hilo2 = new NombreThread("Alvarado");
        hilo2.start();

        Thread hilo3 = new NombreThread("Campos");
        hilo3.start();

        System.out.println(hilo.getState());

    }
}
