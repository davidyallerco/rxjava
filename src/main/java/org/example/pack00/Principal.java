package org.example.pack00;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class Principal {
    public static void main(String[] args) {

        Observable<String> source = Observable.create(e -> {
            e.onNext("Hola");
            e.onNext("RxJava");
        });
        source.subscribe(e -> System.out.println("Observer 1 : " + e));
        source.subscribe(e -> System.out.println("Observer 2 : " + e));
    }
}
/*
El observable emite los datos
El observer es el que tiene los metodos onNext(),.....y son llamados por el observable
Es llamdo siempre y cuando el observer se haya suscrito al observable
 */
