package org.example.pack34Subject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

/*
En RxJava, un Subject actúa como un puente o intermediario que es
tanto un Observable como un Observer. Esto significa que puede:

Emitir elementos: Como un Observable, un Subject puede emitir una secuencia de elementos.
Recibir elementos: Como un Observer, un Subject puede suscribirse a otros Observables y
recibir los elementos que emiten.
 */
public class Principal {
    public static void main(String[] args) {

        PublishSubject<String> subject = PublishSubject.create();

        subject.subscribe(item -> System.out.println("Subscriber 1: " + item));
        subject.onNext("A"); // Subscriber 1 recibe "A"

        subject.subscribe(item -> System.out.println("Subscriber 2: " + item));
        subject.onNext("B"); // Subscriber 1 y 2 reciben "B"
    }
}
