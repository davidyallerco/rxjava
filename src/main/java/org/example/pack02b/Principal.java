package org.example.pack02b;


import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {


        // usando fromIterable
        List<String> lista = List.of("David", "Juan", "Maria");
        Observable<String> observable = Observable.fromIterable(lista);
        observable.subscribe(System.out::println);


    }
}
