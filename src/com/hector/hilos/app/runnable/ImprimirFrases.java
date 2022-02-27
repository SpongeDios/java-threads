package com.hector.hilos.app.runnable;

import com.hector.hilos.app.EjemploSincronizacionThread;

public class ImprimirFrases implements Runnable{

    private final String frase1, frase2;

    public ImprimirFrases(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        try {
            EjemploSincronizacionThread.imprimirFrases(this.frase1, this.frase2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
