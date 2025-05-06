package org.example.pack34Subject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

/*
En RxJava, un Subject actúa como un puente o intermediario que es
tanto un Observable como un Observer. Esto significa que puede:

Emite todos los elementos posteriores a la suscripción.
No guarda ningún evento pasado.
Útil cuando solo quieres recibir eventos desde el momento de la suscripción.
 */
public class Principal3 {
    public static void main(String[] args) {
        // Fuente principal: emite eventos cada segundo
        Observable<String> sourcePrincipal = Observable.create(emitter -> {
            new Thread(() -> {
                try {
                    int counter = 1;
                    while (true) {
                        String value = "Evento " + counter++;
                        System.out.println("sourcePrincipal emite: " + value);
                        emitter.onNext(value);
                        Thread.sleep(1000); // Simular emisión periódica
                    }
                } catch (InterruptedException e) {
                    emitter.onError(e);
                }
            }).start();
        });

        // Intermediario: PublishSubject
        PublishSubject<String> sourceSubject = PublishSubject.create();

        // Fuente secundaria: se suscribe al intermediario
        Observable<String> sourceSecundario = sourceSubject;

        // Suscribirse a la fuente secundaria
        sourceSecundario.subscribe(event ->
                System.out.println("sourceSecundario recibe: " + event)
        );

        // Conectar la fuente principal al intermediario
        sourcePrincipal.subscribe(sourceSubject);
    }
}
