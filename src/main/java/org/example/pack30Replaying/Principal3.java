package org.example.pack30Replaying;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/*
Caso: Actualizaciones de la ubicación del usuario en una aplicación de mapas
Imagina una aplicación de mapas que muestra la ubicación en tiempo real de un usuario.
La aplicación recibe actualizaciones de la ubicación a través de un Observable,
que podría provenir de un servicio GPS.

Problema:
El mapa se carga después de que el usuario ha estado en movimiento durante un tiempo.
El mapa necesita mostrar la trayectoria reciente del usuario, no solo la ubicación actual.

Solución con replay():

Observable de ubicación:
El servicio GPS emite actualizaciones de la ubicación como un Observable.
Replaying:
Usamos replay(n) para almacenar las últimas "n" actualizaciones de la ubicación.
autoConnect() es muy util para este tipo de casos, ya que el observable de la
localizacion debe de estar activo en todo momento.
Suscripción del mapa:
Cuando el mapa se carga, se suscribe al Observable de ubicación.
replay() reproduce las "n" actualizaciones de ubicación almacenadas, mostrando la
trayectoria reciente del usuario.
A partir de ese momento, el mapa recibe las actualizaciones de ubicación en tiempo real.
 */
public class Principal3 {
    public static void main(String[] args) throws InterruptedException {
        // Simulación de actualizaciones de ubicación (latitud, longitud)
        Observable<String> ubicacionObservable = Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> "Lat: " + (37.77 + i * 0.001) + ", Long: " + (-122.41 + i * 0.001))
                .take(10)
                .replay(3)
                .autoConnect();

        // Suscripción del mapa (después de 3 segundos)
        Thread.sleep(3000);
        System.out.println("Mapa cargado. Mostrando trayectoria reciente:");
        ubicacionObservable.subscribe(ubicacion -> System.out.println(ubicacion));

        //El observable sigue emitiendo datos, y el mapa los sigue recibiendo.
        Thread.sleep(7000);
        System.out.println("El mapa sigue recibiendo actualizaciones en tiempo real");
    }
}

/*
Ventajas:

El mapa muestra una trayectoria reciente precisa, incluso si se carga tarde.
Se evita la necesidad de almacenar manualmente las actualizaciones de ubicación.
Se asegura que el observable de la localizacion esta siempre activo.
 */
