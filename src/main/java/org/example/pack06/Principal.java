package org.example.pack06;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        // EJEMPLO OBSERVABLE conectable
        // el ConectableObservable permite convertir cold en hot , tambien con connect()
        System.out.println("--------------------- INICIO ---------------------------");
        //io...esta mas explicito, en vez de tener el import en la parte superior
        //@NonNull es que no acepta nulos, es mejor en cuando usas lombok u otra herramienta estatica
        io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<@NonNull Long> source = Observable
                .interval(1, TimeUnit.SECONDS).publish();
        source.connect();

        // primera subscripcion
        source.subscribe(System.out::println);

        Thread.sleep(10000);
        System.out.println("-----------");

        // segunda subscribcion
        source.subscribe(System.out::println);
        Thread.sleep(10000);

        System.out.println("---------------------  FIN  ----------------------------");
    }
}
