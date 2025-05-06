package org.example.pack36ReplaySubject;

import io.reactivex.rxjava3.subjects.ReplaySubject;
import java.util.ArrayList;
import java.util.List;
/*
un sistema de chat en tiempo real con historial de mensajes.
Imagina una aplicación de chat donde los usuarios pueden unirse a una sala y ver los
mensajes que se envían. Cuando un nuevo usuario se une a la sala, no querrías que vea
la sala vacía. Querrías que automáticamente se le mostraran los mensajes que se
han enviado previamente en esa sala.
Aquí es donde ReplaySubject entra en juego:
El "servidor" o la lógica de la sala de chat actuaría como el Observable.
Cada vez que un nuevo mensaje es enviado por un usuario, este "servidor"
emitiría ese mensaje a través del ReplaySubject.

Cada usuario que se une a la sala se suscribiría como un Observer al ReplaySubject de esa sala.

La magia de ReplaySubject: Cuando un nuevo usuario se suscribe, inmediatamente recibiría
todos los mensajes que se han enviado en la sala hasta ese momento, ya que el ReplaySubject
los ha estado almacenando en su buffer. A partir de ese punto, el nuevo usuario también
comenzaría a recibir los mensajes en tiempo real a medida que se envían.
 */
public class Principal5 {
    private String roomName;
    private ReplaySubject<String> messageSubject = ReplaySubject.create();
    private List<String> users = new ArrayList<>();

    public Principal5(String roomName) {
        this.roomName = roomName;
        System.out.println("Sala de chat '" + roomName + "' creada.");
    }

    public void sendMessage(String user, String message) {
        String formattedMessage = user + ": " + message;
        System.out.println("(Sala " + roomName + ") " + formattedMessage);
        messageSubject.onNext(formattedMessage);
    }

    public void joinRoom(String user) {
        System.out.println("Usuario '" + user + "' se unió a la sala '" + roomName + "'.");
        users.add(user);
        // El nuevo usuario se subscribe y recibirá el historial de mensajes
        messageSubject.subscribe(
                message -> System.out.println("(Para " + user + ") " + message),
                Throwable::printStackTrace,
                () -> System.out.println("Chat completado (para " + user + ")")
        );
    }

    public static void main(String[] args) throws InterruptedException {
        Principal5 javaChat = new Principal5("Java Developers");

        javaChat.joinRoom("Alice");
        javaChat.sendMessage("Bob", "Hola a todos!");
        Thread.sleep(100); // Simular un poco de actividad
        javaChat.sendMessage("Charlie", "¿Alguien sabe sobre RxJava?");
        javaChat.joinRoom("David"); // David se une después de algunos mensajes
        javaChat.sendMessage("Alice", "¡Yo sí!");
        javaChat.joinRoom("Eve"); // Eve también se une tarde
    }
}

/*

 */
