package com.hector.hilos.app;

import com.hector.hilos.app.runnable.ViajeTarea;

import java.util.concurrent.TimeUnit;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) throws InterruptedException {

        //Implementacion sin necesidad de crear una clase con implementacion runnable
        Runnable viaje = new Runnable() {
            @Override
            public void run() {
                //Aca va toda la logica de ViajeTarea
            }
        };

        //Implementacion con expresiones lambda
        Runnable viajeFlecha = () -> {

        };

        //Implementacion normal
        Thread thread = new Thread(new ViajeTarea("Isla de Pascua"));
        Thread thread2 = new Thread(new ViajeTarea("Concepcion"));
        Thread thread3 = new Thread(new ViajeTarea("Santiago"));
        Thread thread4 = new Thread(new ViajeTarea("Puente Alto"));
        Thread thread5 = new Thread(new ViajeTarea("Los Vilos"));

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        //Los .join bloquean al metodo main a que siga en ejecucion y lo espera.
        //Por lo tanto el sout final se ejecutara al final del ultimo thread
        thread.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        //TimeUnit.MILLISECONDS.sleep(7000);
        System.out.println("Continuando con la ejecucion del metodo main");
    }
}
