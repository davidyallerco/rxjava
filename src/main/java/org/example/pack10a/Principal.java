package org.example.pack10a;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class Principal {
    public static void main(String[] args) {
        // SINGLE

        System.out.println("--------------------- INICIO ---------------------------");

        // Crear un Observable que emite tres valores y luego completa
        Single<Integer> source = Single.just(1984);

        // Crear un Observer
        source.subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
                // No es necesario guardar el Disposable en este caso
            }

            @Override
            public void onSuccess(@NonNull Integer value) {
                System.out.println("onSuccess: " + value);//El valor lo trae en onSuccess y no en onNext
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.err.println("onError: " + e.getMessage());
            }


        });

        System.out.println("---------------------  FIN  ----------------------------");

    }

}
