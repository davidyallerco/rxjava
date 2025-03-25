package org.example.pack26conbineLatest;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;
/*
combineLatest es un operador de RxJava que combina múltiples Observables y
emite un nuevo valor cada vez que cualquiera de los Observables de origen
emite un valor. La emisión contiene el último valor de cada Observable.

 */
public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(10);
        Observable<Long> observable2 = Observable.interval(1, TimeUnit.SECONDS).take(10);



        Observable.combineLatest(observable1, observable2, (x, y) -> "Source1: " + x + " Source2: " + y )
                .subscribe(System.out::println);

        Thread.sleep(20000); // Para esperar la salida en la consola
    }
}
/*
¿Cómo funciona combineLatest?
Se suscribe a varios Observable o Flowable.
Cada vez que cualquiera de ellos emite un valor, se combinan los últimos valores emitidos por todos los Observable.
Solo comienza a emitir cuando todos los Observable han emitido al menos un valor.
Útil para manejar dependencias entre múltiples flujos de datos.
 */