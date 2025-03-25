package org.example.pack24Amb;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/*
En RxJava, el operador amb (abreviatura de ambiguous) se utiliza para seleccionar
el primer Observable que emite un valor y descartar los demás. Es útil cuando
tienes múltiples fuentes de datos y solo quieres la respuesta más rápida.
 */
public class Principal2 {
    public static void main(String[] args) throws InterruptedException {
/*
        Observable<String> observable1 = Observable
                .just("Fuente 1")
                .delay(1, TimeUnit.SECONDS); // Se retrasa 1 segundo

        Observable<String> observable2 = Observable
                .just("Fuente 2")
                .delay(500, TimeUnit.MILLISECONDS); // Se retrasa 500 ms

        Observable.ambArray(observable1, observable2)
                .subscribe(System.out::println);

        Thread.sleep(2000); // Esperamos para ver la salida
        */

    String nombreObjeto = "avion";
    String[]  colores = { "blanco", "celeste", "amarillo", " negro" };
    int cantidadAlas = 5;
    int cantidadVentanas = 11;
    Double precio = 50.5;

    System.out.println("El nombre es " + nombreObjeto);
    System.out.println("El color que tiene es " + colores[0] + " y " + colores[3]);
    System.out.println("La cantidad de alas es " + cantidadAlas);
    System.out.println("La cantidad de ventanas es " + cantidadVentanas);
    System.out.println("El precio del avión es " + precio + " centimos");
    }
}
/*
Casos de uso comunes
Redundancia en solicitudes de red: Si tienes múltiples servidores que pueden proporcionar
los mismos datos, puedes usar amb para seleccionar el servidor que responde más rápido.

Fuentes de datos alternativas: Si tienes varias fuentes de datos (por ejemplo, caché,
base de datos local, API remota), puedes usar amb para seleccionar la fuente que responde primero.

Tiempos de espera: Puedes combinar amb con un Observable que emite después de un tiempo
de espera para manejar casos en los que ninguna fuente responde en un tiempo razonable.
 */
