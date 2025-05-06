package org.example.pack38Buffer;

import io.reactivex.rxjava3.core.Observable;

/*
buffer()
Agrupa los elementos en listas (List<T>).

Devuelve un Observable<List<T>>.

Útil si quieres trabajar con todos los elementos a la vez.
 */
public class Principal {
    public static void main(String[] args) {


        Observable.range(1, 10)
                .buffer(3)
                .subscribe(list -> System.out.println("Buffer: " + list));


    }
}
