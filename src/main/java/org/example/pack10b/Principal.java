package org.example.pack10b;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class Principal {
    public static void main(String[] args) {
        // SINGLE

        System.out.println("--------------------- INICIO ---------------------------");

        Single<Integer> source = Single.just(1984);

        source.subscribe(
                // () -> System.out.println("onSubscribe") // Lambda para onSubscribe (se ejecuta antes de onSuccess o onError)
                value -> System.out.println("onSuccess: " + value),  // Lambda para onSuccess
                error -> System.err.println("onError: " + error.getMessage()) // Lambda para onError
             );

        System.out.println("---------------------  FIN  ----------------------------");

    }

}
