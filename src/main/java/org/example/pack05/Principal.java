package org.example.pack05;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        // EJEMPLO OBSERVABLE HOT
        // emite haya o no subscriptores
        // Observable.interval, Observable.timer
        System.out.println("--------------------- INICIO ---------------------------");

        io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<@NonNull Long> source = Observable
                .interval(1, TimeUnit.SECONDS).publish();
        source.connect();

        // primera subscripcion
        source.subscribe(System.out::println);

        Thread.sleep(10000);
        System.out.println("-----------");

        // segunda subscribcion
        source.subscribe(System.out::println);
        Thread.sleep(10000);

        System.out.println("---------------------  FIN  ----------------------------");
    }
}
