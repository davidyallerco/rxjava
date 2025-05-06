package org.example.pack39Window;

import io.reactivex.rxjava3.core.Observable;

/*
window()
El operador window() es similar a buffer(), pero en lugar de emitir una
lista de elementos, emite Observables. Cada Observable emitido por
window() representa una "ventana" de los elementos del Observable fuente.

Al igual que buffer(), puedes definir cómo se crean estas ventanas
por conteo, tiempo o mediante otro Observable.

window() transforma un Observable<T> en un Observable<Observable<T>>.

Para acceder a los elementos dentro de cada ventana, normalmente necesitarás
usar operadores como flatMap(), concatMap() o switchMap() para suscribirte
a cada Observable "ventana" y procesar sus elementos.

Ejemplo simplificado de window() por conteo:
 */
public class Principal2 {
    public static void main(String[] args) {

        Observable.range(1, 10)
                .window(3) // Crea ventanas de 3 elementos
                .flatMapSingle(window -> // Itera sobre cada Observable ventana
                        window.reduce("", (acc, item) -> acc + " " + item)) // Reduce los elementos de cada ventana a un String
                .subscribe(
                        aggregated -> System.out.println("Ventana procesada: " + aggregated),
                        Throwable::printStackTrace,
                        () -> System.out.println("Completado")
                );



    }
}
/*
Diferencias clave entre buffer() y window():

Emisión: buffer() emite listas o colecciones de elementos; window() emite Observables de elementos.
Procesamiento posterior: Con buffer(), procesas la lista directamente. Con window(), necesitas
suscribirte al Observable emitido para acceder a los elementos.
Casos de uso:
buffer() es útil cuando necesitas procesar lotes de elementos de una sola vez (por ejemplo, enviar
datos en bloques, realizar cálculos agregados por lote).
window() es más útil cuando necesitas realizar operaciones complejas en secuencias de elementos
agrupados, donde cada grupo necesita ser tratado como un flujo de eventos independiente
(por ejemplo, aplicar operadores temporales dentro de cada ventana, realizar operaciones de "sesión").
 */