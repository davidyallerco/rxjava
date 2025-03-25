package org.example.pack02g;


import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {

        // usando never
        Observable<Object> neverData = Observable.never();
        neverData.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed!"));

        // Salida esperada:
        // (No se imprime nada porque nunca emite ni completa)


    }
}
