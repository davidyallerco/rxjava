package org.example.pack09;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        // CONVERTIR COLD A HOT con share()
        // solo emite cuando hay al menos un subcriptor
        // se detiene si ya no hay subcriptores
        // Cuando quieres compartir datos en tiempo real y parar emisión sin
        // suscriptores.
        // Emisión automática, sin repetición de valores anteriores.
        System.out.println("--------------------- INICIO ---------------------------");

        Observable<Long> hotObservable = Observable.interval(1, TimeUnit.SECONDS).share();

        // Suscriptor 1 se conecta inmediatamente
        hotObservable.subscribe(value -> System.out.println("Suscriptor --->: " + value));

        // Espera 2 segundos antes de añadir el Suscriptor 2
        Thread.sleep(2000);

        // Suscriptor 2 se conecta después de 2 segundos
        hotObservable.subscribe(value -> System.out.println("Suscriptor ===>: " + value));

        // Espera suficiente tiempo para ver la emisión de valores
        Thread.sleep(5000);

        System.out.println("---------------------  FIN  ----------------------------");
    }
}
