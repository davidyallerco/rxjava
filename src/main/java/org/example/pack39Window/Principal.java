package org.example.pack39Window;

import io.reactivex.rxjava3.core.Observable;
/*
window()
Agrupa los elementos en Observables (cada grupo es un Observable<T>).
Devuelve un Observable<Observable<T>>.
Útil si quieres procesar cada grupo de datos de manera independiente o asincrónica.
 */
public class Principal {
    public static void main(String[] args) {


        Observable.range(1, 10)
                .window(3)
                .flatMapSingle(obs -> obs.toList())
                .subscribe(list -> System.out.println("Window: " + list));

    }
}
/*
Este ejemplo usa flatMapSingle(obs -> obs.toList()) para convertir cada
ventana (que es un Observable) a una lista, solo para mostrar la salida.
 */