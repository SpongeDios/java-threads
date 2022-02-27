package com.hector.hilos.ejemploexecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploScheduleExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        System.out.println("Alguna tarea en el main");

        CountDownLatch lock = new CountDownLatch(10);

        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Hola mundo tarea 1");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                lock.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hola mundo tarea 2");
        }, 1000, 2000 ,TimeUnit.MILLISECONDS);

//        TimeUnit.SECONDS.sleep(10);
        lock.await();
        System.out.println("Alguna otra tarea en el main ...");
        executorService.shutdown();


    }
}
