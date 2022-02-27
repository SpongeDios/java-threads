package com.hector.hilos.app.threads;

import java.util.stream.IntStream;

public class NombreThread extends Thread{

    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Se inicia el thread: " + this.getName());

        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("finaliza el hilo:" + this.getName());
    }


}
