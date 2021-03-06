package com.hector.hilos.app.runnable;

import java.util.concurrent.TimeUnit;

public class ViajeTarea implements Runnable{

    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1 + " - " + this.nombre);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalmente me voy de viaje a: "+ this.nombre);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
