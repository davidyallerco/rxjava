package org.example.pack26conbineLatest;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Principal3 {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable1 = Observable.interval(1, TimeUnit.SECONDS) // Emite cada 1 seg
                .map(i -> i + 1) // Para que empiece en 1
                .take(5); // Solo toma 5 valores

        Observable<Long> observable2 = Observable.interval(2, TimeUnit.SECONDS) // Emite cada 2 seg
                .map(i -> (i + 1) * 10) // Multiplica por 10
                .take(5); // Solo toma 5 valores

        Observable.combineLatest(observable1, observable2, (val1, val2) ->
                        "Observable1: " + val1 + " | Observable2: " + val2)
                .subscribe(System.out::println);

        Thread.sleep(10000); // Esperar para ver las emisiones
    }
}
