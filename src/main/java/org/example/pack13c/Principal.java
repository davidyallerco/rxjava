package org.example.pack13c;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/*
CompositeDisposable. Te permite agrupar múltiples instancias de
Disposable en un solo contenedor. Luego, puedes llamar al método
dispose() del CompositeDisposable para liberar todos los recursos
 de todas las suscripciones a la vez.
 */
public class Principal {
    public static void main(String[] args) throws InterruptedException {
        //CompositeDisposable
        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Disposable disposable1 = Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);
        compositeDisposable.add(disposable1);

        Disposable disposable2 = Observable.just("A", "B", "C")
                .subscribe(System.out::println);
        compositeDisposable.add(disposable2);

// ... (haces algo con los datos) ...

// Cuando ya no necesitas las suscripciones:
        compositeDisposable.dispose();

    }
}

/*
En resumen:
Un CompositeDisposable es un contenedor para múltiples instancias de Disposable.
Facilita la gestión y liberación de recursos de múltiples suscripciones a la vez.
Es especialmente útil cuando tienes muchas suscripciones que necesitas cancelar
en un momento dado.
 */
