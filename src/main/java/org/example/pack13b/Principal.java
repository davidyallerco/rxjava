package org.example.pack13b;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/*
Cuando trabajas con múltiples suscripciones, es recomendable usar CompositeDisposable
 para administrar varias a la vez y evitar olvidarte de liberar alguna:
 */
public class Principal {
    public static void main(String[] args) throws InterruptedException {
        //CompositeDisposable

        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Disposable disposable1 = Observable.just("Hola")
                .delay(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Disposable disposable2 = Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

// Agregamos las suscripciones al CompositeDisposable
        compositeDisposable.addAll(disposable1, disposable2);

// Cancelar todas las suscripciones después de 3 segundos
        Thread.sleep(3000);
        compositeDisposable.dispose();
        System.out.println("Todas las suscripciones canceladas");

    }
}

/*
El método dispose() está asociado con la interfaz Disposable,
que representa una suscripción a un flujo de datos en RxJava.
Cuando te suscribes a un observable, recibes un objeto Disposable
que puedes usar para cancelar la suscripción cuando ya no sea necesaria.
 */
