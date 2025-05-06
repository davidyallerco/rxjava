package org.example.pack38Buffer;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/*
El operador buffer recolecta múltiples elementos del Observable fuente y los emite juntos como listas (colecciones).

Características de Buffer:
Agrupa items en listas

Emite colecciones completas

Útil para procesamiento por lotes
 */
public class Principal3 {
    public static void main(String[] args) {
        // Simulación de lecturas de sensor cada 500ms
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .take(10) // Tomar 10 lecturas
                .buffer(3, TimeUnit.SECONDS) // Agrupar lo recibido cada 3 segundos
                .subscribe(
                        batch -> System.out.println("Datos del batch: " + batch),
                        Throwable::printStackTrace,
                        () -> System.out.println("Procesamiento completo")
                );

        // Esperar para ver los resultados
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
