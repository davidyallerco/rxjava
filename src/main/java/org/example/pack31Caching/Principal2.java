package org.example.pack31Caching;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Aspecto                             | cache()                                               | replay()
------------------------------------|-------------------------------------------------------|-------------------------------------------------------
Cuándo se almacena                  | Solo después de la primera suscripción.                | Inmediatamente después de la emisión, antes de cualquier suscripción.
Duración del almacenamiento         | Hasta que el Observable termine o la aplicación se reinicie. | Controlado por parámetros como tiempo y cantidad de ítems.
Propósito principal                 | Evitar consultas repetidas y optimizar recursos.       | Garantizar que todos los suscriptores reciban los mismos datos.

Caché de datos de una API
Supongamos que tienes una aplicación que consume datos de una API, como una lista de productos.
Para evitar hacer múltiples solicitudes de red, puedes usar cache() para almacenar la respuesta y reutilizarla.

 */
public class Principal2 {
    public static void main(String[] args) throws InterruptedException {
        // Simulación de una solicitud de red que devuelve una lista de productos
        Observable<List<String>> productsObservable = Observable.fromCallable(() -> {
                    System.out.println("Haciendo solicitud a la API...");
                    Thread.sleep(2000); // Simular un retraso en la red
                    return Arrays.asList("Producto 1", "Producto 2", "Producto 3");
                }).subscribeOn(Schedulers.io()) // Ejecutar en un hilo de fondo
                .cache(); // Almacenar en caché los resultados

// Suscriptor 1: Pantalla principal
        productsObservable.subscribe(products ->
                System.out.println("Pantalla principal: " + products));

// Suscriptor 2: Pantalla de detalles (se suscribe después de un retraso)
        new Thread(() -> {
            try {
                Thread.sleep(3000); // Simular un retraso antes de suscribirse
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            productsObservable.subscribe(products ->
                    System.out.println("Pantalla de detalles: " + products));
        }).start();
    }
}

/*
Explicación:
La solicitud a la API solo se realiza una vez.

Los datos se almacenan en caché y se reutilizan para el segundo suscriptor.

Esto evita hacer múltiples solicitudes de red, lo que mejora el rendimiento y reduce el consumo de recursos.

 */
