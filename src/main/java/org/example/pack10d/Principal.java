package org.example.pack10d;

import io.reactivex.rxjava3.core.Single;

public class Principal {
    public static void main(String[] args) {
        // SINGLE

        System.out.println("--------------------- INICIO ---------------------------");

        // Crear un Single que siempre emite un error
        Single<Object> source = Single.error(new RuntimeException("Algo salió mal"));

        // Suscribirnos al Single usando lambda, su uso es mas comun
        source.subscribe(
                value -> System.out.println("onSuccess: " + value), // onSuccess
                error -> System.err.println("onError: " + error.getMessage()) // onError
        );

        System.out.println("---------------------  FIN  ----------------------------");

    }

}
