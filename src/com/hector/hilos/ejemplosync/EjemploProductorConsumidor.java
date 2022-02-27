package com.hector.hilos.ejemplosync;

import com.hector.hilos.ejemplosync.runnable.Consumidor;
import com.hector.hilos.ejemplosync.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        final Panaderia p = new Panaderia();


        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
