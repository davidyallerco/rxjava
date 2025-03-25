package org.example.pack24Amb;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/*
amb toma dos o más observables como entrada.
Cuando cualquiera de estos observables emite su primer elemento, amb selecciona ese observable como la fuente de datos definitiva.
A partir de ese momento, amb ignora las emisiones de los demás observables y solo pasa los elementos del observable seleccionado.
 */
public class Principal {
    public static void main(String[] args) throws InterruptedException {

        Observable<String> observable1 = Observable.interval(1,TimeUnit.SECONDS).take(10).map(e->"Ob 1: "+e);
        Observable<String> observable2 = Observable.interval(1,TimeUnit.MILLISECONDS).take(10).map(e->"Ob 2: "+e);

        Observable.amb(Arrays.asList(observable1, observable2))
                .subscribe(System.out::println);

        Thread.sleep(11000); // Esperamos para ver la salida
    }
}
/*
Carreras de observables:
Un caso de uso común es cuando tienes varias formas de obtener los mismos datos (por ejemplo,
desde una caché local o desde un servidor remoto) y quieres usar la primera que responda.
amb te permite iniciar varias solicitudes en paralelo y procesar solo el resultado de la más rápida.
Conmutación por error (failover):
Puedes usar amb para implementar una forma sencilla de conmutación por error.
Si tienes un observable principal y un observable de respaldo, amb seleccionará
el observable principal si funciona correctamente, pero cambiará al observable
de respaldo si el principal falla o tarda demasiado.
Redundancia:
En sistemas donde la redundancia es muy importante, y se tienen varias
fuentes que proveen la misma información, se puede usar amb para tomar
la primera que responda, y así asegurar que la información llegue lo mas rápido posible.
 */
