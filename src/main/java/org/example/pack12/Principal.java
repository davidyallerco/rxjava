package org.example.pack12;

import io.reactivex.rxjava3.core.Completable;

public class Principal {
    public static void main(String[] args) {

        Completable completable = Completable.complete();

        System.out.println();

        completable.subscribe(() -> System.out.println("Completed"));

        Completable
                .fromRunnable(() -> System.out.println("Some process executing"))
                .subscribe(() -> System.out.println("The process executed successfully"));
    }
}
