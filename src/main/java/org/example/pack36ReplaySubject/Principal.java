package org.example.pack36ReplaySubject;

import io.reactivex.rxjava3.subjects.ReplaySubject;

/*
En RxJava, ReplaySubject es un tipo especial de Subject que re-emite todos los ítems emitidos a cualquier
nuevo suscriptor, sin importar cuándo se suscriba.
Es como una grabadora: guarda todo lo emitido y lo reproduce para los nuevos observadores.
¿Cuándo usar ReplaySubject?
Cuando quieres que todos los observadores reciban todos los valores emitidos, incluso si
se suscriben después de que los valores hayan sido emitidos.
Útil en casos donde el historial de eventos importa (como logs, mensajes de estado, etc.).
 */
public class Principal {
    public static void main(String[] args) {


        // Crear el ReplaySubject
        ReplaySubject<String> subject = ReplaySubject.create();

        // Emitir algunos valores antes de suscribirse
        subject.onNext("Valor 1");
        subject.onNext("Valor 2");

        // Primer observador
        subject.subscribe(item -> System.out.println("Observador 1: " + item));

        // Emitir más valores
        subject.onNext("Valor 3");

        // Segundo observador (recibirá todos los valores desde el principio)
        subject.subscribe(item -> System.out.println("Observador 2: " + item));

        // Completar el flujo
        subject.onComplete();

        







    }
}
