package org.example.pack19distinct;

import io.reactivex.rxjava3.core.Observable;

public class Principal2 {
    public static void main(String[] args) {
        //distinct, no toma los repetidos

        Observable.just("A", "B", "A", "C", "B", "D", "E", "C")
                .distinct() // Filtra valores duplicados
                .subscribe(item -> System.out.println("Recibido: " + item));
    }
}
