package org.example.pack30Replaying;

import io.reactivex.rxjava3.core.Observable;
/*
replay(): Reemisión Completa de Elementos
Guarda y reemite todos los elementos emitidos a cualquier nuevo suscriptor,
incluso después de completar el flujo.

Utiliza un buffer en memoria para almacenar los elementos.
Útil cuando quieres que todos los suscriptores reciban el mismo conjunto completo de datos.
 */
public class Principal {
    public static void main(String[] args) throws InterruptedException {
        // Creamos un Observable con replay()
        Observable<String> source = Observable.just("A", "B", "C")
                .replay()
                .autoConnect();  // Activa el replay cuando hay al menos un suscriptor

        // Primer suscriptor (recibe todos los elementos)
        source.subscribe(data -> System.out.println("Suscriptor 1: " + data));

        Thread.sleep(1000);  // Simulamos un retardo

        // Segundo suscriptor (recibe también todos los elementos)
        source.subscribe(data -> System.out.println("Suscriptor 2: " + data));
    }
}

/*
Explicación:
Ambos suscriptores reciben los mismos valores (A, B, C) aunque el segundo se suscribe después de la emisión.
replay() guarda todos los elementos emitidos.
autoConnect() inicia la emisión automáticamente cuando hay al menos un suscriptor.
 */
