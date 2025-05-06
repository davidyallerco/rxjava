package org.example.pack34Subject;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

/*
En RxJava, un Subject actúa como un puente o intermediario que es
tanto un Observable como un Observer. Esto significa que puede:

PublishSubject: Este es el tipo más básico. Un PublishSubject solo emite a sus suscriptores
los elementos que se emiten después del momento en que se suscriben. Los elementos emitidos
previamente se pierden para los nuevos suscriptores. Imagina un locutor de radio que solo
escuchas a partir del momento en que sintonizas la emisora; no oyes lo que dijo antes.
 */
public class Principal2 {
    public static void main(String[] args) {
        // Crea un Subject (en este caso, un PublishSubject)
        Subject<String> subject = PublishSubject.create();

        // Suscribe un Observer al Subject
        subject.subscribe(
                item -> System.out.println("Observer 1: " + item),
                throwable -> System.err.println("Observer 1 Error: " + throwable),
                () -> System.out.println("Observer 1 Completed")
        );

        // Emite algunos elementos en el Subject
        subject.onNext("Elemento 1");
        subject.onNext("Elemento 2");

        // Suscribe otro Observer al Subject
        subject.subscribe(
                item -> System.out.println("Observer 2: " + item),
                throwable -> System.err.println("Observer 2 Error: " + throwable),
                () -> System.out.println("Observer 2 Completed")
        );

        // Emite más elementos
        subject.onNext("Elemento 3");
        subject.onComplete(); // Indica que el flujo ha terminado
    }
}
