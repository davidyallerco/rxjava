package org.example.pack36ReplaySubject;

import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
/*
Características principales:
Almacena todos los items emitidos (o hasta un límite configurado)
Los reemite a nuevos suscriptores
Útil cuando necesitas que los suscriptores reciban datos históricos
 */
public class Principal3 {
    public static void main(String[] args) {


        // Crear un ReplaySubject
        ReplaySubject<String> replaySubject = ReplaySubject.create();

        // Emitir algunos valores
        replaySubject.onNext("Mensaje 1");
        replaySubject.onNext("Mensaje 2");
        replaySubject.onNext("Mensaje 3");

        // Primer suscriptor (recibe todos los mensajes emitidos hasta ahora)
        replaySubject.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Suscriptor 1: Suscrito");
            }

            @Override
            public void onNext(String s) {
                System.out.println("Suscriptor 1: " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Suscriptor 1: Error - " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Suscriptor 1: Completado");
            }
        });

        // Emitir otro mensaje
        replaySubject.onNext("Mensaje 4");

        // Segundo suscriptor (recibe TODOS los mensajes anteriores también)
        replaySubject.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Suscriptor 2: Suscrito");
            }

            @Override
            public void onNext(String s) {
                System.out.println("Suscriptor 2: " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Suscriptor 2: Error - " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Suscriptor 2: Completado");
            }
        });

        // Completar el Subject
        replaySubject.onComplete();




    }
}

/*
Variaciones de ReplaySubject:
Puedes crear un ReplaySubject con diferentes configuraciones:
ReplaySubject.createWithSize(n): Limita el buffer a los últimos n elementos
ReplaySubject.createWithTime(t, unit): Almacena elementos emitidos en los últimos t unidades de tiempo
ReplaySubject.createWithTimeAndSize(t, unit, n): Combina ambas limitaciones
ReplaySubject es útil en escenarios donde necesitas que los nuevos suscriptores reciban
el historial completo o parcial de emisiones anteriores.
 */
