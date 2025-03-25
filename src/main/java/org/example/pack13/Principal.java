package org.example.pack13;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;
/*
dispose() es un método que se usa para cancelar la
suscripción a un flujo reactivo y liberar recursos asociados.
Cuando te suscribes a un Observable, Single, Completable, etc., RxJava crea
 una suscripción activa. Si no cancelas esta suscripción cuando
 ya no la necesitas, podrías causar fugas de memoria (memory leaks).
 */
public class Principal {
    public static void main(String[] args) throws InterruptedException {

        Disposable disposable = Observable.interval(1, TimeUnit.SECONDS) // Emite cada 1 segundo
                .subscribe(
                        item -> System.out.println("Recibido: " + item),
                        error -> System.out.println("Error: " + error),
                        () -> System.out.println("Completado")
                );

// Cancelar la suscripción después de 5 segundos
        Thread.sleep(5000);
        disposable.dispose(); // Detiene la emisión
        System.out.println("Suscripción cancelada");
    }
}
/*
¿Cuándo es necesario usar Disposable?
El Disposable es útil en los siguientes escenarios:
Cancelación manual de suscripciones: Si necesitas detener la recepción de
emisiones antes de que el Observable complete o falle, debes usar Disposable
para cancelar la suscripción explícitamente.
Evitar fugas de memoria: En aplicaciones de larga duración (como aplicaciones Android),
si no cancelas las suscripciones, los objetos pueden permanecer en memoria
indefinidamente, lo que lleva a fugas de memoria.
Gestionar múltiples suscripciones: Si tienes varias suscripciones y deseas
cancelarlas todas de una sola vez, puedes usar CompositeDisposable.
¿Cuándo no es necesario usar Disposable?
En algunos casos, no es necesario usar Disposable explícitamente:
Suscripciones de corta duración: Si el Observable completa o falla rápidamente,
 y no hay riesgo de fugas de memoria, no es necesario gestionar el Disposable.
Uso de operadores que manejan la suscripción automáticamente: Algunos operadores
de RxJava, como take, first, o timeout, cancelan automáticamente la suscripción
cuando se cumple una condición, por lo que no necesitas gestionar el Disposable manualmente.
 */
