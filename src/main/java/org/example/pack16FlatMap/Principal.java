package org.example.pack16FlatMap;

import io.reactivex.rxjava3.core.Observable;

public class Principal {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Orange", "Black", "Red");
        source.flatMap(e-> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);
    }
}
