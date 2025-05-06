package org.example.pack35BehaviorSubject;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

/*
BehaviorSubject: Un BehaviorSubject emite el elemento más reciente que se emitió antes de la suscripción y
luego continúa emitiendo cualquier elemento posterior a los nuevos suscriptores. Requiere un valor inicial
al crearse. Es como un marcador deportivo que muestra el resultado actual cuando empiezas a ver el partido
y luego se actualiza con los nuevos puntos.
 */
public class Principal2 {
    public static void main(String[] args) {


        BehaviorSubject<String> subject = BehaviorSubject.createDefault("Initial");
        subject.subscribe(value -> System.out.println("Subscriber 1: " + value)); // Recibe "Initial"
        subject.onNext("Event 1"); // Recibe "Event 1"
        subject.subscribe(value -> System.out.println("Subscriber 2: " + value)); // Recibe "Event 1" (último valor)

        







    }
}
