package org.example.pack36ReplaySubject;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.ReplaySubject;

/*
Escenario: Chat con historial de mensajes
Los usuarios se conectan en diferentes momentos.

Todos deben ver los mensajes anteriores cuando se conectan.
 */
public class Principal4 {
    public static void main(String[] args) {


        // Crear un ReplaySubject para mantener el historial del chat
        ReplaySubject<String> chatHistory = ReplaySubject.create();

        // Emitir mensajes (como si fueran enviados por otros usuarios)
        chatHistory.onNext("Usuario1: Hola!");
        chatHistory.onNext("Usuario2: Buenas tardes!");
        chatHistory.onNext("Usuario1: ¿Cómo estás?");

        // Usuario 3 se une al chat más tarde
        System.out.println("🔵 Usuario3 se conecta al chat:");
        chatHistory.subscribe(msg -> System.out.println("Usuario3 ve -> " + msg));

        // Más mensajes se envían
        chatHistory.onNext("Usuario2: Todo bien, gracias.");
        chatHistory.onNext("Usuario3: Hola a todos!");

        // Usuario 4 se une incluso más tarde
        System.out.println("\n🟢 Usuario4 se conecta al chat:");
        chatHistory.subscribe(msg -> System.out.println("Usuario4 ve -> " + msg));




    }
}

