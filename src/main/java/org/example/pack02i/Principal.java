package org.example.pack02i;


import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {

        // usando fromCallable
        Observable<String> callableData = Observable.fromCallable(() -> {
            if (Math.random() > 0.5)
                throw new Exception("Random error!");
            return "Success!";
        });
        callableData.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed!"));

        // Salida esperada (es aleatoria, dependiendo del valor de Math.random()):
        // Success!
        // Completed!
        // O si ocurre un error:
        // java.lang.Exception: Random error!
    }
}
