package org.example.pack01b;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Principal {
    public static void main(String[] args) {

        //aqui el observer esta implicito
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        observable.subscribe(
                item -> System.out.println("Received: " + item),   // onNext
                error -> System.err.println("Error: " + error),    // onError
                () -> System.out.println("Done")                   // onComplete
        );
    }
}
