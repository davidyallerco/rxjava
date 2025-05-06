package org.example.pack39Window;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/*
Window Operator
El operador window es similar a buffer, pero en lugar de emitir listas,
emite Observables que contienen los items agrupados.
Características de Window:
Agrupa items en nuevos Observables
Permite procesamiento reactivo de los grupos
Más eficiente en memoria para grandes conjuntos de datos
 */
public class Principal3 {
    public static void main(String[] args) {
        // Simulación de transacciones bancarias
        Observable.interval(200, TimeUnit.MILLISECONDS)
                .take(20) // 20 transacciones
                .window(1, TimeUnit.SECONDS) // Agrupar por segundo
                .subscribe(windowObservable -> {
                    System.out.println("\nNuevo grupo de transacciones:");
                    Disposable d = windowObservable.subscribe(
                            tx -> System.out.println("Procesando transacción: " + tx),
                            Throwable::printStackTrace,
                            () -> System.out.println("Fin del grupo")
                    );
                });

        // Esperar para ver los resultados
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
