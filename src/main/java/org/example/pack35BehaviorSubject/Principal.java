package org.example.pack35BehaviorSubject;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

/*
Guarda el último valor emitido y lo envía a nuevos suscriptores.
Útil para mantener un "estado actual".
 */
public class Principal {
    public static void main(String[] args) {

        BehaviorSubject<String> subject = BehaviorSubject.createDefault("valor_inicial");

        subject.subscribe(val -> System.out.println("Observador 1: " + val));

        subject.onNext("evento 1");
        subject.onNext("evento 2");

        subject.subscribe(val -> System.out.println("Observador 2: " + val)); // Recibe "evento 2"






    }
}
/*
¿Cuándo usar cada uno?
PublishSubject: Eventos en tiempo real (ej: notificaciones de clicks).
BehaviorSubject: Estado actual (ej: último valor de un sensor).
ReplaySubject: Reemitir historial completo (ej: caching de datos).
AsyncSubject: Resultados finales (ej: operaciones que solo importan al finalizar).

RxJava 3 sigue manteniendo estos tipos, aunque también existen alternativas
como Flowable con backpressure para casos más específicos.
 */
