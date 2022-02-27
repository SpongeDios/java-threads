package com.hector.hilos.app;

import com.hector.hilos.app.runnable.ImprimirFrases;

import java.util.concurrent.TimeUnit;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new ImprimirFrases("Hola ", "que tal"));
        thread1.start();
        Thread thread2 = new Thread(new ImprimirFrases("Quien eres ", "Tu?"));
        thread2.start();
        Thread thread3 = new Thread(new ImprimirFrases("Muchas ", "gracias amigo"));
        TimeUnit.MILLISECONDS.sleep(100);
        thread3.start();

        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(thread3.getState());

    }

    public synchronized static void imprimirFrases(String frase1, String frase2) throws InterruptedException {
        System.out.print(frase1);
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(frase2);
    }

}
