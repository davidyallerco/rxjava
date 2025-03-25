package org.example.pack17doOnEach;

import io.reactivex.rxjava3.core.Observable;

/*
doOnEach es un operador en RxJava que te permite realizar una acción cada vez que un
elemento es emitido por un Observable, incluyendo cuando se completa o cuando ocurre un error.
Es similar a doOnNext, doOnError, y doOnComplete, pero doOnEach combina estas
funcionalidades en un solo operador.
 */
public class Principal2 {
    public static void main(String[] args) {
        //doOnEach
        Observable.just("Hola", "Mundo")
                .doOnEach(notification -> {
                    if (notification.isOnNext()) {
                        System.out.println("Elemento emitido: " + notification.getValue());
                    } else if (notification.isOnError()) {
                        System.out.println("Error: " + notification.getError());
                    } else if (notification.isOnComplete()) {
                        System.out.println("Completado");
                    }
                })
                .subscribe(
                        item -> System.out.println("Recibido: " + item),
                        error -> System.err.println("Error: " + error),
                        () -> System.out.println("Completado")
                );
    }
}

/*
¿Cuándo usar doOnEach?
Depuración: Puedes usar doOnEach para depurar tu flujo de datos y ver qué está pasando en cada paso.
Registro de eventos: Si necesitas registrar cada evento (emisión, error, completado) para auditoría o análisis.
Acciones secundarias: Si necesitas realizar acciones secundarias cada vez que se emite un elemento, como
actualizar una interfaz de usuario o enviar una notificación.
 */
