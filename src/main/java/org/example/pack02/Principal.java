package org.example.pack02;


import io.reactivex.rxjava3.core.Observable;


public class Principal {
    public static void main(String[] args) {
        // usando create
        Observable<Integer> source = Observable.create(e -> {
            e.onNext(10);
            e.onNext(11);
            e.onNext(12);
            e.onComplete();
        });
        source.subscribe(System.out::println);

    }
}
