package org.example.pack20distinctUntilChanged;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

/*

En RxJava, el operador distinctUntilChanged() se utiliza para filtrar un flujo de datos (Observable)
 y emitir solo los elementos que son diferentes al elemento inmediatamente anterior.
 A diferencia de distinct(), que mantiene un registro de todos los elementos emitidos,
 distinctUntilChanged() solo compara el elemento actual con el anterior.
 */
public class Principal2 {
    public static void main(String[] args) {

        List<String> lista = List.of("A", "A", "B", "B", "A", "C", "C", "D", "C", "C", "E");
        Observable<String> source = Observable.fromIterable(lista);

                source.distinctUntilChanged() // Solo elimina duplicados consecutivos
                .subscribe(item -> System.out.println("Recibido: " + item));
    }
}
