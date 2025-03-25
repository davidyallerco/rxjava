package org.example.pack25Zip;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/*
Ejemplo con retardos (para simular asincronía)
 */
public class Principal5 {
    public static void main(String[] args) throws InterruptedException {


        Observable<Long> observable1 = Observable.interval(200, TimeUnit.MILLISECONDS);
        Observable<Long> observable2 = Observable.interval(1, TimeUnit.SECONDS);



        Observable.zip(observable1, observable2, (x, y) -> "Source1: " + x + " Source2: " + y )
                .subscribe(System.out::println);

        Thread.sleep(20000); // Para esperar la salida en la consola
    }
}
/*

 */
