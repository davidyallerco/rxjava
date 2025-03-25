package org.example.pack21;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {

        //Intervalo de tiempo
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        source.subscribe(System.out::println);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
