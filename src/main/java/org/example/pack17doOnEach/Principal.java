package org.example.pack17doOnEach;

import io.reactivex.rxjava3.core.Observable;
/*
el operador doOnEach se usa para ejecutar una acción en cada evento emitido por
un Observable (o Flowable, Single, etc.), sin modificar el flujo de datos. Este operador
te permite interceptar onNext, onError y onComplete, lo cual es útil para depuración,
registro de eventos (logging) o ejecución de efectos secundarios.
 */
public class Principal {
    public static void main(String[] args) {
        //doOnEach
        Observable.just(1, 2, 3)
                .doOnEach(notification -> {
                    if (notification.isOnNext()) {
                        System.out.println("Elemento emitido: " + notification.getValue());
                    } else if (notification.isOnError()) {
                        System.out.println("Error ocurrido: " + notification.getError());
                    } else if (notification.isOnComplete()) {
                        System.out.println("Secuencia completada");
                    }
                })
                .subscribe(System.out::println);
    }
}
