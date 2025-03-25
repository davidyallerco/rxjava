package org.example.pack08;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        // CONVERTIR COLD A HOT con publish() y autoConnect()
        // Cuando deseas iniciar la emisión solo cuando se llama connect().
        // Emisión controlada, sin repetición de valores anteriores.
        System.out.println("--------------------- INICIO ---------------------------");

        Observable<Long> hotObservable = Observable.interval(1, TimeUnit.SECONDS).publish().autoConnect();

        // Suscriptor 1 se conecta inmediatamente
        hotObservable.subscribe(value -> System.out.println("Suscriptor 1: " + value));

        // Espera 2 segundos antes de añadir el Suscriptor 2
        Thread.sleep(2000);

        // Suscriptor 2 se conecta después de 2 segundos
        hotObservable.subscribe(value -> System.out.println("Suscriptor 2: " + value));

        // Espera suficiente tiempo para ver la emisión de valores
        Thread.sleep(5000);

        System.out.println("---------------------  FIN  ----------------------------");
    }
}
