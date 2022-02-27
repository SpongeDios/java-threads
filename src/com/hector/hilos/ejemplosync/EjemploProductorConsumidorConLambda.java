package com.hector.hilos.ejemplosync;

import com.hector.hilos.ejemplosync.runnable.Consumidor;
import com.hector.hilos.ejemplosync.runnable.Panadero;

public class EjemploProductorConsumidorConLambda {
    public static void main(String[] args) {
        final Panaderia p = new Panaderia();

        new Thread(() -> {
            //Toda la logica de panadero
        }).start();

        new Thread(() -> {
            //Toda la logica de Consumidor
        }).start();
    }
}
