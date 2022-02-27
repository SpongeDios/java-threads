package com.hector.hilos.ejemploexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploScheduleExecutorService {
    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        System.out.println("Alguna tarea en el main");
        executorService.schedule(() -> {
            System.out.println("Hola mundo tarea 1");

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hola mundo tarea 2");
        }, 2000, TimeUnit.MILLISECONDS);

        System.out.println("Alguna otra tarea en el main ...");
        executorService.shutdown();


    }
}
