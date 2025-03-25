package org.example.pack18Skip;

import io.reactivex.rxjava3.core.Observable;

public class Principal {
    public static void main(String[] args) {
        //Skip , salta los n valores
        Observable<Integer> source = Observable.range(1, 10); // Emite números del 1 al 10

                source.skip(3) // Omite los primeros 3 elementos
                .subscribe(System.out::println);
    }
}
