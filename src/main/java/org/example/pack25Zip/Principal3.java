package org.example.pack25Zip;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/*
Ejemplo con retardos (para simular asincronía)
 */
public class Principal3 {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable1 = Observable.just("Uno", "Dos", "Tres")
                .delay(1, TimeUnit.SECONDS);

        Observable<Integer> observable2 = Observable.just(100, 200, 300)
                .delay(500, TimeUnit.MILLISECONDS);

        Observable.zip(observable1, observable2, (texto, numero) -> texto + " - " + numero)
                .subscribe(System.out::println);

        Thread.sleep(3000); // Para esperar la salida en la consola
    }
}
/*
¿Cuándo usar zip?
Para combinar datos de múltiples fuentes en paralelo.
Cuando necesitas sincronizar datos antes de procesarlos (ejemplo: combinar API y caché).
Para realizar operaciones en paralelo y unificarlas.
 */
