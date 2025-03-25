package org.example.pack28Concurrencia;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        // Simulamos una tarea que emite números
        Observable<Integer> tarea = Observable.range(1, 5);

        tarea
                .subscribeOn(Schedulers.io()) // Ejecuta la suscripción en un hilo de E/S (background)
                .doOnNext(number -> System.out.println("Emisión en el hilo: " + Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread()) // Procesa los resultados en un nuevo hilo
                .subscribe(
                        number -> {
                            // Simulamos un procesamiento de datos
                            System.out.println("Procesando " + number + " en el hilo: " + Thread.currentThread().getName());
                        },
                        error -> System.err.println("Error: " + error.getMessage()),
                        () -> System.out.println("Completado!")
                );

        // Esperamos un momento para que los hilos terminen su trabajo
        try {
            Thread.sleep(3000); // Espera 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
