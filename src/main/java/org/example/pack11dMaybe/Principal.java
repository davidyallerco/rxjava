package org.example.pack11dMaybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class Principal {
    public static void main(String[] args) {
        //Maybe con lambda
        Maybe<String> source1 = Maybe.just("David");
        source1.subscribe(System.out::println);

        Maybe<String> source2 = Maybe.empty();
        source2.subscribe(System.out::println);

        Maybe<String> source3 = Maybe.just("Yallerco");
        source3.subscribe(
                        valor -> System.out.println("Éxito: " + valor), // Lambda para onSuccess
                        error -> System.err.println("Error: " + error.getMessage()), // Lambda para onError
                        () -> System.out.println("Completado") // Lambda para onComplete
                );


    }
}
