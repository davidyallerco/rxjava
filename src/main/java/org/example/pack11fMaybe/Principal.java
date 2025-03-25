package org.example.pack11fMaybe;

import io.reactivex.rxjava3.core.Maybe;
/*
El emitter es un objeto que pertenece al Observable
(o a sus variantes como Maybe, Single, etc.). Es el mecanismo
que permite al Observable emitir eventos (valores, errores o
señales de completado) a sus Observers.
 */
public class Principal {
    public static void main(String[] args) {
        obtenerValor()
                .subscribe(
                        valor -> System.out.println("Éxito: " + valor), // Lambda para onSuccess
                        error -> System.err.println("Error: " + error.getMessage()), // Lambda para onError
                        () -> System.out.println("Completado") // Lambda para onComplete
                );
    }

    private static Maybe<String> obtenerValor() {
        // Simula una operación que puede o no retornar un valor
        boolean hayValor = Math.random() < 0.5; // 50% de probabilidad

        return Maybe.create(emitter -> {
            if (hayValor) {
                emitter.onSuccess("Valor presente");
            } else {
                emitter.onComplete();
            }
        });
    }
}

/*
Observable:
Es la fuente de datos o eventos.
Usa un emitter para emitir valores, errores o señales de completado.
Se crea usando métodos como Observable.create(), Maybe.create(), etc.
Observer:
Es el consumidor de los datos o eventos emitidos por el Observable.
Implementa métodos como onNext, onError, y onComplete para reaccionar a
las emisiones del Observable.
 */