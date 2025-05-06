package org.example.pack35BehaviorSubject;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class Principal3 {
    public static void main(String[] args) {


        // Creamos un BehaviorSubject con un valor inicial de "0"
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("0");

        // Primer observador se suscribe
        System.out.println("Observador 1 se suscribe...");
        subject.subscribe(
                valor -> System.out.println("Observador 1 recibió: " + valor),
                Throwable::printStackTrace,
                () -> System.out.println("Observador 1 completado")
        );

        // Emitimos algunos valores
        subject.onNext("1");
        subject.onNext("2");

        // Segundo observador se suscribe después de que se emitieron algunos valores
        System.out.println("\nObservador 2 se suscribe...");
        subject.subscribe(
                valor -> System.out.println("Observador 2 recibió: " + valor),
                Throwable::printStackTrace,
                () -> System.out.println("Observador 2 completado")
        );

        // Emitimos un valor más
        subject.onNext("3");

        // Completamos el Subject
        subject.onComplete();

        

    }
}
/*
¿Qué sucede al ejecutar este código?
Creación: Creamos un BehaviorSubject llamado subject con el valor inicial "0".
Primera Suscripción: El "Observador 1" se suscribe al subject. Inmediatamente
recibe el valor inicial "0" y luego recibe las emisiones "1" y "2".
Segunda Suscripción: Después de que se emitieran "1" y "2", el "Observador 2"
se suscribe. Debido a la naturaleza del BehaviorSubject, este nuevo observador
recibe inmediatamente el último valor emitido antes de su suscripción, que es "2".
Luego, también recibe la nueva emisión "3".
Completado: Finalmente, llamamos a onComplete() en el subject, lo que hace
que ambos observadores reciban la notificación de completado.

En resumen:

Un BehaviorSubject es útil cuando quieres que los nuevos suscriptores reciban el valor
más reciente disponible inmediatamente al suscribirse. Esto es común en situaciones
donde necesitas mantener un estado actual y notificar a los nuevos interesados sobre
ese estado. Por ejemplo, podría usarse para representar el estado actual de una conexión de red,
la última ubicación conocida de un usuario o el valor actual de un campo de entrada.

 */
