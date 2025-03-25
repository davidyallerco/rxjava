package org.example.pack13a;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/*
En aplicaciones más complejas, es común usar CompositeDisposable para
gestionar múltiples suscripciones. Este contenedor te permite agregar
 varios objetos Disposable y cancelarlos todos de una sola vez cuando
 ya no son necesarios.
 */
public class Principal {
    public static void main(String[] args) throws InterruptedException {
        //CompositeDisposable

        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Disposable disposable1 = Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(value -> System.out.println("Observable 1: " + value));

        Disposable disposable2 = Observable.interval(2, TimeUnit.SECONDS)
                .subscribe(value -> System.out.println("Observable 2: " + value));

        compositeDisposable.add(disposable1);
        compositeDisposable.add(disposable2);

// Después de un tiempo, cancelamos todas las suscripciones
        Thread.sleep(5000);
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
