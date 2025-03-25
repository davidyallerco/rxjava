package org.example.pack01a;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;
/*
Observable: Es la fuente de datos o eventos. Su trabajo es emitir elementos a
través del método onNext().
Observer: Es quien recibe y maneja los elementos emitidos por el Observable.
Tiene métodos como onNext(), onError() y onComplete() para reaccionar a
los eventos del Observable.

 */
public class Principal {
    public static void main(String[] args) {

        // Crear un Observable que emite tres valores
        Observable<Integer> observable = Observable.just(1, 2, 3);

        // Crear un Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Suscrito");
            }

            @Override
            public void onNext(@NonNull Integer value) {
                System.out.println("Recibido: " + value);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.err.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completado");
            }
        };

        // Suscribir el Observer al Observable
        observable.subscribe(observer);
    }
}
