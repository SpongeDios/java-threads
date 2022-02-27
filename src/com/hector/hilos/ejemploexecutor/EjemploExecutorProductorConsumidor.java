package com.hector.hilos.ejemploexecutor;

import com.hector.hilos.ejemplosync.Panaderia;
import com.hector.hilos.ejemplosync.runnable.Consumidor;
import com.hector.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService2 = Executors.newCachedThreadPool();// CREA HILOS SEGUN LA
        ThreadPoolExecutor executorService3 = (ThreadPoolExecutor) Executors.newCachedThreadPool();// Esta no es la interface, es la clase.
        //ThreadPoolExecutor   Tiene metodos interesantes como getPoolSize, getQueue,


//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        //Puede ser Runnable o Callable

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> resultado = executorService.submit(productor);
        Future<?> resultado2 = executorService.submit(consumidor);

//        executorService.shutdownNow() este metodo no espera a que termine la tarea. La detiene abruptamente
        executorService.shutdown();
        System.out.println("Continuando con la ejecucion del main 1");
        System.out.println(resultado.isDone());


    }
}
