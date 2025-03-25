package org.example.pack02f;


import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {

        // usando empty
        Observable<Object> emptyData = Observable.empty();
        emptyData.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed!"));

        // Salida esperada:
        // Completed!


    }
}
