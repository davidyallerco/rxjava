package org.example.pack18Skip;

import io.reactivex.rxjava3.core.Observable;

public class Principal2 {
    public static void main(String[] args) {
        //Skip , salta los n valores
        Observable.range(1, 10) // Emite números del 1 al 10
                .skip(3) // Omite los primeros 3 elementos
                .subscribe(
                        item -> System.out.println("Recibido: " + item), // Recibe los elementos después de skip
                        error -> System.err.println("Error: " + error), // Maneja errores
                        () -> System.out.println("Completado") // Se ejecuta cuando el Observable termina
                );
    }
}
