package org.example.pack25Zip;

import io.reactivex.rxjava3.core.Observable;

/*
Combinación de emisiones:
zip toma dos o más observables como entrada.
Espera a que cada observable emita un elemento.
Cuando todos los observables han emitido un elemento, zip aplica una función a estos elementos y emite el resultado.
Repite este proceso para las siguientes emisiones de cada observable.
La secuencia resultante tendrá la longitud del observable más corto.
 */
public class Principal2 {
    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<Integer> observable2 = Observable.just(10, 20, 30);

        Observable.zip(observable1, observable2, (num1, num2) -> num1 + num2)
                .subscribe(
                        sum -> System.out.println("Sum: " + sum),
                        error -> System.out.println("Error: " + error),
                        () -> System.out.println("Completed")
                );
    }
}
/*
¿Para qué sirve?

Sincronización de datos:
zip es útil cuando necesitas combinar datos de diferentes fuentes que deben estar sincronizados.
 Por ejemplo, si tienes un observable que emite nombres y otro que emite edades, puedes usar zip
 para combinar estos datos en objetos de tipo "Empleado".
Ejecución paralela con combinación de resultados:
Puedes usar zip para ejecutar varias operaciones asíncronas en paralelo y combinar sus resultados
 cuando todas las operaciones hayan finalizado. Esto es útil para realizar tareas que
 dependen de múltiples fuentes de datos.
Procesamiento de eventos relacionados:
Si tienes múltiples flujos de eventos que están relacionados entre sí, puedes usar zip para
procesar estos eventos en conjunto. Por ejemplo, puedes combinar eventos de clic de ratón con
eventos de pulsación de teclas para realizar acciones complejas.
 */
