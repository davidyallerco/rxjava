package org.example.pack03;

import io.reactivex.rxjava3.core.Observable;


public class Principal {
    public static void main(String[] args) {
        // ############## Observable frios (cold) ############
        // Comienza al momento de suscribirse
        // Cada suscriptor tiene su propio flujo de datos
        // Usado mayormente en Archivos, listas, colecciones estáticas
        Observable<Integer> coldObservable = Observable.range(1, 5);

        // Suscriptor 1
        coldObservable.subscribe(value -> System.out.println("Subscriber ---> 1: " + value));

        // Suscriptor 2 (se suscribe en otro momento)
        coldObservable.subscribe(value -> System.out.println("Subscriber ===> 2: " + value));


    }
}
