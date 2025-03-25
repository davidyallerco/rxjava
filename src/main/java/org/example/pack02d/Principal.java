package org.example.pack02d;


import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {

        // usando interval
        Observable<Long> intervalData = Observable.interval(1, TimeUnit.SECONDS).take(3); // Limita a 3 emisiones

        intervalData.subscribe(System.out::println);

        // Salida esperada (con pausas de 1 segundo entre cada emisión):
        // 0
        // 1
        // 2

    }
}
