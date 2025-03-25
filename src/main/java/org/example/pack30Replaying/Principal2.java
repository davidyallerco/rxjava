package org.example.pack30Replaying;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/*
El replaying permite almacenar una serie de elementos emitidos por un Observable y
luego reproducirlos para nuevos suscriptores. Esto es útil cuando tienes un
Observable que emite datos valiosos, pero los nuevos suscriptores necesitan
acceder a esos datos incluso si se suscriben tarde.
 */
public class Principal2 {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS).take(5)
                .replay()// Convierte el Observable en un ConnectableObservable
                .autoConnect();// Conecta automáticamente cuando hay al menos un suscriptor

        source.subscribe(value -> System.out.println("Suscriptor 1: " + value));

        Thread.sleep(3000);

        source.subscribe(value -> System.out.println("Suscriptor 2: " + value));
    }
}

/*
RxJava proporciona varios operadores para implementar el replaying:

replay(): Almacena todas las emisiones y las reproduce para nuevos suscriptores.
replay(bufferSize): Almacena las últimas "bufferSize" emisiones y las reproduce.
replay(windowDuration, timeUnit): Almacena las emisiones dentro de un período de tiempo específico y las reproduce.
replay().autoConnect(): Similar a replay(), pero se conecta automáticamente al Observable fuente cuando hay al menos un suscriptor.
shareReplay(): Combina las funcionalidades de "share" y "replay", permitiendo compartir un Observable y almacenar sus emisiones.
 */
