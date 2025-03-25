package org.example.pack02c;


import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {

        // usando range
        // Se ingresa dos parametros valor inicial, cantidad de valores
        Observable<Integer> rangeData = Observable.range(5, 3);
        rangeData.subscribe(System.out::println);

        // Salida esperada:
        // 5
        // 6
        // 7
        // --------------------------------------

    }
}
