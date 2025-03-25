package org.example.pack07;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        // EJEMPLO OBSERVABLE HOT
        // emite haya o no subscriptores
        // Observable.interval, Observable.timer
        // revisar,no funciona
        System.out.println("--------------------- INICIO ---------------------------");

        Observable<Long> coldObservable = Observable.interval(1, TimeUnit.SECONDS).take(5) // Emite 5 valores con un
                // intervalo de 1 segundo
                .publish() // Convierte en Hot Observable
                .autoConnect(); // Inicia la emisión de datos

        // Suscriptor 1 (inmediatamente)
        coldObservable.subscribe(value -> System.out.println("Subscriber 1: " + value));

        // Espera 2 segundos antes de añadir otro suscriptor
        Thread.sleep(2000);

        // Suscriptor 2 (se suscribe más tarde)
        coldObservable.subscribe(value -> System.out.println("Subscriber 2: " + value));
        Thread.sleep(2000);//le puse esta linea para que funcione el suscriptor 2
        System.out.println("---------------------  FIN  ----------------------------");
    }
}
