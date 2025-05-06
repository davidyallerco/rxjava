package org.example.pack36ReplaySubject;

import io.reactivex.rxjava3.subjects.ReplaySubject;

/*
ReplaySubject es una clase en RxJava que actúa como un puente entre un Observable y un Observer,
al igual que otros Subjects. Sin embargo, la característica distintiva de ReplaySubject es
que almacena en un buffer todos los elementos emitidos por el Observable y los reemite a
cualquier nuevo Observer que se suscriba, independientemente de cuándo se realice la suscripción.
 */
public class Principal2 {
    public static void main(String[] args) {


        // Creamos un ReplaySubject
        ReplaySubject<String> subject = ReplaySubject.create();

        // Un primer Observer se subscribe
        System.out.println("Observer 1 se subscribe:");
        subject.subscribe(
                value -> System.out.println("Observer 1 recibió: " + value),
                error -> System.err.println("Observer 1 error: " + error),
                () -> System.out.println("Observer 1 completado")
        );

        // Emitimos algunos valores
        subject.onNext("Hola");
        subject.onNext("Mundo");
        subject.onNext("RxJava");

        // Un segundo Observer se subscribe después de que se emitieron los valores
        System.out.println("\nObserver 2 se subscribe:");
        subject.subscribe(
                value -> System.out.println("Observer 2 recibió: " + value),
                error -> System.err.println("Observer 2 error: " + error),
                () -> System.out.println("Observer 2 completado")
        );

        // Emitimos un valor más
        subject.onNext("!");

        // Completamos el Subject
        subject.onComplete();



    }
}
