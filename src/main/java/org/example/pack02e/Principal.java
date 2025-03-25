package org.example.pack02e;


import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {

        // usando fromFuture
        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> "Hello from Future!");
        Observable<String> futureData = Observable.fromFuture(future);
        futureData.subscribe(System.out::println);

        // Salida esperada:
        // Hello from Future!


    }
}
