package org.example.pack36ReplaySubject;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.ReplaySubject;

/*
Aquí tienes un ejemplo más realista de ReplaySubject en RxJava, simulando un sistema de
notificaciones donde los nuevos suscriptores reciben las últimas notificaciones publicadas:

Ejemplo: Sistema de Notificaciones con Histórico
 */
public class Principal6 {
    public static void main(String[] args) {
        // Simulamos un sistema de notificaciones que guarda las 2 últimas notificaciones
        ReplaySubject<String> notificationSubject = ReplaySubject.createWithSize(2);

        // Servicio que envía notificaciones
        Runnable notificationService = () -> {
            notificationSubject.onNext("Nueva promoción: 20% de descuento");
            sleep(1000);
            notificationSubject.onNext("Recordatorio: Reunión a las 15:00");
            sleep(1000);
            notificationSubject.onNext("Alerta: Sistema se actualizará a las 18:00");
        };

        // Iniciamos el servicio en un hilo aparte
        new Thread(notificationService).start();

        // Usuario 1 se suscribe después de 500ms (recibirá algunas notificaciones iniciales)
        sleep(500);
        notificationSubject.subscribe(createObserver("Usuario 1"));

        // Usuario 2 se suscribe después de 2500ms (recibirá las 2 últimas notificaciones)
        sleep(2000);
        notificationSubject.subscribe(createObserver("Usuario 2"));

        // Esperamos para que el programa no termine inmediatamente
        sleep(3000);
    }

    private static Observer<String> createObserver(String user) {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println(user + ": Suscrito al sistema de notificaciones");
            }

            @Override
            public void onNext(String notification) {
                System.out.println(user + " recibió -> " + notification);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(user + ": Error - " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println(user + ": Notificaciones completadas");
            }
        };
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*
Explicación del caso real:
Configuración: Creamos un ReplaySubject que almacena las 2 últimas notificaciones (createWithSize(2)).

Flujo:

El servicio envía 3 notificaciones con intervalos de 1 segundo

El Usuario 1 se suscribe después de 500ms y recibe todas las notificaciones emitidas hasta ese momento

El Usuario 2 se suscribe después de 2500ms y recibe automáticamente las 2 últimas notificaciones
(por la configuración del buffer)

Escenario real: Esto simula:

Una app que muestra notificaciones push

Un chat que muestra los últimos mensajes al conectarse

Un sistema de alertas que mantiene el historial reciente

Ventajas en este escenario:
Los nuevos usuarios no se pierden las notificaciones importantes recientes

No hay necesidad de hacer consultas adicionales a una base de datos para obtener el historial

El sistema es reactivo y eficiente en el manejo de suscriptores tardíos
 */
