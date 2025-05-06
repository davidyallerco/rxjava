package org.example.pack38Buffer;

import io.reactivex.rxjava3.core.Observable;

/*
buffer()
El operador buffer() acumula los elementos emitidos por el Observable fuente en una lista (o alguna otra colección)
y luego emite esa lista como un único elemento cuando se cumple una condición específica.

Puedes definir cómo se forman los buffers de varias maneras:

Por conteo: Agrupa un número fijo de elementos en cada buffer.
Por tiempo: Agrupa los elementos emitidos durante un período de tiempo específico.
Por otro Observable (boundary): Agrupa los elementos hasta que otro Observable emite un valor.
Con saltos (skip): Define un tamaño de buffer y un número de elementos para saltar antes de
iniciar el siguiente buffer (útil para crear buffers solapados o con huecos).
En esencia, buffer() transforma un Observable<T> en un Observable<List<T>> (o Observable<Collection<T>>).
 */
public class Principal2 {
    public static void main(String[] args) {


        Observable.range(1, 10)
                .buffer(3) // Agrupa los elementos en listas de 3
                .subscribe(
                        buffer -> System.out.println("Buffer recibido: " + buffer),
                        Throwable::printStackTrace,
                        () -> System.out.println("Completado")
                );


        







    }
}
