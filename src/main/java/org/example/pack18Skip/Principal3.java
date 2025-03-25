package org.example.pack18Skip;

import io.reactivex.rxjava3.core.Observable;

public class Principal3 {
    public static void main(String[] args) {
        //Skip y doOnEach
        Observable.range(1, 10) // Emite números del 1 al 10
                .doOnEach(notification -> {
                    if (notification.isOnNext()) {
                        System.out.println("Elemento emitido (antes de skip): " + notification.getValue());
                    } else if (notification.isOnError()) {
                        System.out.println("Error: " + notification.getError());
                    } else if (notification.isOnComplete()) {
                        System.out.println("Completado (antes de skip)");
                    }
                })
                .skip(3) // Omite los primeros 3 elementos
                .doOnEach(notification -> {
                    if (notification.isOnNext()) {
                        System.out.println("Elemento emitido (después de skip): " + notification.getValue());
                    } else if (notification.isOnError()) {
                        System.out.println("Error: " + notification.getError());
                    } else if (notification.isOnComplete()) {
                        System.out.println("Completado (después de skip)");
                    }
                })
                .subscribe(
                        item -> System.out.println("Recibido: " + item),
                        error -> System.err.println("Error: " + error),
                        () -> System.out.println("Completado (en subscribe)")
                );
    }
}
