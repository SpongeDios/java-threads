package com.hector.hilos.ejemploexecutor;

import java.net.SocketTimeoutException;
import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService2 = Executors.newCachedThreadPool();// CREA HILOS SEGUN LA
        ThreadPoolExecutor executorService3 = (ThreadPoolExecutor) Executors.newCachedThreadPool();// Esta no es la interface, es la clase.
        //ThreadPoolExecutor   Tiene metodos interesantes como getPoolSize, getQueue,


//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        //Puede ser Runnable o Callable
        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea....");
            try {
                System.out.println("Nombre del thread: "+ Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea ... ");
            return "Algun resultado importante";
        };

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 2");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };


        Future<String> resultado = executorService.submit(tarea);
        Future<Integer> resultado2 = executorService.submit(tarea2);
        executorService.shutdown();
//        executorService.shutdownNow() este metodo no espera a que termine la tarea. La detiene abruptamente

        System.out.println("Continuando con la ejecucion del main 1");
        System.out.println(resultado.isDone());

        while(!(resultado.isDone() && resultado2.isDone())){
            System.out.println(String.format("Resultado 1: %s y Resultado 2: %s", resultado.isDone(), resultado2.isDone()));
            TimeUnit.MILLISECONDS.sleep(1500);
        }

        System.out.println("Obtenemos el resultado de la tarea: " + resultado.get(5, TimeUnit.SECONDS));
        System.out.println("Resultado de la tarea: "+resultado.isDone());
        System.out.println("Resultado de la tarea 2: "+resultado2.isDone());

    }
}
