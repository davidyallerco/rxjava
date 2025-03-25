package org.example.pack20distinctUntilChanged;

import io.reactivex.rxjava3.core.Observable;
/*

En RxJava, el operador distinctUntilChanged() se utiliza para filtrar un flujo de datos (Observable)
 y emitir solo los elementos que son diferentes al elemento inmediatamente anterior.
 A diferencia de distinct(), que mantiene un registro de todos los elementos emitidos,
 distinctUntilChanged() solo compara el elemento actual con el anterior.
 */
public class Principal {
    public static void main(String[] args) {

        Observable.just(1, 2, 2, 3, 4, 4, 5,6,7,5)
                .distinctUntilChanged()
                .subscribe(System.out::println);
    }
}
