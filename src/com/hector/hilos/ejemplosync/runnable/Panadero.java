package com.hector.hilos.ejemplosync.runnable;

import com.hector.hilos.ejemplosync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Panadero implements Runnable{

    private final Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                this.panaderia.hornear("Pan numero: " + i);
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
