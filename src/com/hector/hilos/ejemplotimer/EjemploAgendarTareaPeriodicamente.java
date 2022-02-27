package com.hector.hilos.ejemplotimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaPeriodicamente {
    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            private int contador = 3;

            @Override
            public void run() {
                if (contador > 0){
                    System.out.println("Tarea realizada en: " + new Date() + " Nombre del thread: "+ Thread.currentThread().getName());
                    contador--;
                }else{
                    System.out.println("Tiempo finalizado");
                    timer.cancel();
                }
            }
        }, 5000, 5000);

        System.out.println("Agendamos una tarea para 5 segundos mas....");
    }
}
