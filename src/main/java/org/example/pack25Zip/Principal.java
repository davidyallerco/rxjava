package org.example.pack25Zip;

import io.reactivex.rxjava3.core.Observable;
/*
En RxJava, el operador zip se utiliza para combinar las emisiones de múltiples
Observables en un solo Observable, aplicando una función específica a los elementos
correspondientes de cada Observable. El resultado es un nuevo Observable
que emite los valores combinados.
 */
public class Principal {
    public static void main(String[] args) {
        Observable<String> observable1 = Observable.just("A", "B", "C");
        Observable<Integer> observable2 = Observable.just(1, 2, 3);

        Observable.zip(observable1, observable2, (letra, numero) -> letra + numero)
                .subscribe(System.out::println);
    }
}
/*
El operador zip es útil cuando necesitas combinar los resultados de varios Observables
y realizar alguna operación con ellos. Por ejemplo, si tienes dos Observables que
emiten valores de manera independiente, puedes usar zip para combinar sus emisiones
en pares (o tuplas) y luego aplicar una función a esos pares.
 */
