package org.example.pack19distinct;

import io.reactivex.rxjava3.core.Observable;

public class Principal {
    public static void main(String[] args) {
        //distinct, no toma los repetidos

        Observable.just(1, 2, 2, 3, 4, 4, 5)
                .distinct()
                .subscribe(System.out::println);
    }
}
