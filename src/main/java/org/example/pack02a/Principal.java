package org.example.pack02a;


import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {

        // usando just
        Observable<Integer> data = Observable.just(1, 2, 3);
        data.subscribe(System.out::println);


    }
}
