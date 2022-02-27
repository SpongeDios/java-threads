package com.hector.hilos.ejemplosync;

import java.util.concurrent.TimeUnit;

public class Panaderia {

    private String pan;
    private boolean disponible;


    public synchronized void hornear(String masa) throws InterruptedException {
        while (disponible){
            wait();
        }
        this.pan = masa;
        System.out.println("Panadero hornea: " + this.pan);
        this.disponible = true;
        notify();
    }

    public synchronized String consumir() throws InterruptedException {
        while (!disponible){
            wait();
        }

        System.out.println("Cliente consume: " + this.pan);
        this.disponible = false;
        notify();
        return pan;
    }
}
