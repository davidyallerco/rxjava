package org.example.pack24Amb;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/*
Toma múltiples Observables como entrada.
Se suscribe a todos simultáneamente.
El primer Observable que emite un valor "gana".
Los demás Observables se cancelan (se ignoran).
 */
public class Principal3 {
    public static void main(String[] args) throws InterruptedException {

        Observable<String> source1 = Observable.timer(1, TimeUnit.SECONDS).map(i -> "Source 1");
        Observable<String> source2 = Observable.timer(500, TimeUnit.MILLISECONDS).map(i -> "Source 2");

        Observable.amb(Arrays.asList(source1, source2))
                .subscribe(
                        item -> System.out.println("Received: " + item),
                        error -> System.out.println("Error: " + error),
                        () -> System.out.println("Completed")
                );

        Thread.sleep(2000); // Esperamos para ver la salida
    }
}
/*
Casos de uso
Elegir la respuesta más rápida entre múltiples fuentes de datos (ej. servidores, caché vs API).
Implementar tolerancia a fallos al probar varias conexiones y tomar la primera disponible.
 */