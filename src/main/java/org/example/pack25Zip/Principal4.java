package org.example.pack25Zip;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/*
Ejemplo con retardos (para simular asincronía)
 */
public class Principal4 {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable1 = Observable.just("Uno", "Dos", "Tres")
                .delay(1, TimeUnit.SECONDS);

        Observable<Integer> observable2 = Observable.just(100, 200)
                .delay(1500, TimeUnit.MILLISECONDS);

        Observable<String> observable3 = Observable.just("A","B","C","D","F")
                .delay(500, TimeUnit.MILLISECONDS);

        Observable.zip(observable1, observable2,observable3, (texto, numero,texto2) -> texto + " - " + numero + " - "+texto2)
                .subscribe(System.out::println);

        Thread.sleep(5000); // Para esperar la salida en la consola
    }
}
/*

 */
