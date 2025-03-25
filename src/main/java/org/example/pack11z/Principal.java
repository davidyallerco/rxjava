package org.example.pack11z;

import io.reactivex.rxjava3.core.Observable;

public class Principal {
    public static void main(String[] args) {
        //variante de un observable
        Observable<String> source = Observable.just("David","Mario","Juan");

        source
                .firstElement()
                .subscribe(System.out::println, e -> e.printStackTrace(), () -> System.out.println("Completed"));
    }
}
