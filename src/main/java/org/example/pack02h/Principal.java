package org.example.pack02h;


import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {


        // usando error
        Observable<Object> errorData = Observable.error(new Exception("Something went wrong!"));
        errorData.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed!"));

        // Salida esperada:
        // java.lang.Exception: Something went wrong!


    }
}
