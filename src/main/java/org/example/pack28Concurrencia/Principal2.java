package org.example.pack28Concurrencia;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Imagina una aplicación que muestra información sobre el clima y las noticias de
diferentes ciudades. Para obtener esta información, la aplicación realiza llamadas
a múltiples APIs asíncronas. Queremos mostrar la información combinada de
todas las ciudades de forma concurrente.
 */
public class Principal2 {
    public static void main(String[] args) throws InterruptedException {

        List<String> ciudades = Arrays.asList("Londres", "Nueva York", "Tokio");

        Observable.fromIterable(ciudades)
                .flatMap(ciudad -> obtenerClima(ciudad)
                        .zipWith(obtenerNoticias(ciudad), (clima, noticias) ->
                                "Ciudad: " + ciudad + ", Clima: " + clima + ", Noticias: " + noticias))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(
                        resultado -> System.out.println("Resultado: " + resultado ),
                        error -> System.err.println("Error: " + error)
                );

        // Esperar un tiempo para que las operaciones asíncronas se completen
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // Simula una llamada a una API para obtener el clima (asíncrono)
    private static Observable<String> obtenerClima(String ciudad) {
        return Observable.fromCallable(() -> {
            // Simula una demora de la red
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
            return "Soleado"; // Simula un resultado del clima
        }).subscribeOn(Schedulers.io()); // Ejecutar en un hilo de E/S
    }

    // Simula una llamada a una API para obtener noticias (asíncrono)
    private static Observable<String> obtenerNoticias(String ciudad) {
        return Observable.fromCallable(() -> {
            // Simula una demora de la red
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1500));
            return "Noticias importantes"; // Simula un resultado de noticias
        }).subscribeOn(Schedulers.io()); // Ejecutar en un hilo de E/S
    }
}

/*
Explicación:

Observable.fromIterable(ciudades): Crea un Observable que emite los nombres de las ciudades.
flatMap(): Para cada ciudad, realiza llamadas asíncronas para obtener el clima y las noticias.
obtenerClima(ciudad) y obtenerNoticias(ciudad): Simulan llamadas a APIs asíncronas, cada una
ejecutándose en un hilo de E/S (Schedulers.io()).
zipWith(): Combina los resultados de las llamadas al clima y las noticias en un solo resultado.
subscribeOn(Schedulers.io()): Ejecuta las llamadas a las APIs en hilos de E/S.
observeOn(Schedulers.computation()): Ejecuta el procesamiento de los resultados en un hilo de cálculo.
subscribe(): Imprime los resultados combinados o maneja errores.
TimeUnit.SECONDS.sleep(5): Espera un tiempo para que las operaciones asíncronas se completen.
Puntos clave:

Este ejemplo demuestra cómo realizar múltiples llamadas asíncronas de forma concurrente
usando flatMap() y Schedulers.
El uso de Schedulers.io() permite realizar operaciones de E/S sin bloquear el hilo principal.
El uso de Schedulers.computation() permite procesar los resultados en un hilo de cálculo.
zipWith() se utiliza para combinar los resultados de múltiples Observables asíncronos.
 */
