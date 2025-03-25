package org.example.pack10;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Principal {
    public static void main(String[] args) {
        // SINGLE

        System.out.println("--------------------- INICIO ---------------------------");

        Observable<String> source = Observable.just("David","Mario","Juan");

        source.first("Name").subscribe(System.out::println);

        System.out.println("------------------");
        // Usando Single
        Single<String> source2 = Single.just("David");
        source2.subscribe(System.out::println);
        //lo mismo que el anterior pero mas corto
        System.out.println("------------------");
        Single.just("David")
        .subscribe(System.out::println);
        System.out.println("------------------");

        System.out.println("---------------------  FIN  ----------------------------");

    }

}
