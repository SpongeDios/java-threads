package com.hector.hilos.ejemplosync.runnable;

import com.hector.hilos.ejemplosync.Panaderia;

public class Consumidor implements Runnable{
    private final Panaderia panaderia;

    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                panaderia.consumir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
