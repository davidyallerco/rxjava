package org.example.pack12b;

import io.reactivex.rxjava3.core.Completable;
/*
Operaciones de escritura en bases de datos o archivos.
Ejecución de tareas en segundo plano que no requieren un resultado.
Notificaciones de eventos que no llevan datos asociados.

Operadores comunes en Completable:
andThen(ObservableSource): Permite encadenar un Observable, Flowable, Single, Maybe o Completable después de que el Completable se complete.
subscribe(): Suscribe un CompletableObserver para recibir notificaciones de éxito o error.
onErrorResumeNext(CompletableSource): Permite manejar errores y continuar con otro Completable.
timeout(long, TimeUnit): Establece un tiempo máximo para que el Completable se complete.
 */

public class Principal {
    public static void main(String[] args) {
        //Completable
        Completable completable = Completable.create(emitter -> {
            // Simulamos una operación que no devuelve ningún valor
            try {
                saveDataToDatabase(); // Método que guarda datos en la base de datos
                emitter.onComplete(); // Notifica que la operación se completó con éxito
            } catch (Exception e) {
                emitter.onError(e); // Notifica que ocurrió un error
            }
        });

        // Suscribirse al Completable
        completable.subscribe(
                () -> System.out.println("Operación completada con éxito"),
                error -> System.err.println("Error: " + error.getMessage())
        );
    }

    private static void saveDataToDatabase(){
        System.out.println("Guardando en la base de datos");
    }

}

/*
No emite valores: A diferencia de Observable, Flowable, Single o Maybe, Completable no emite ningún valor. Solo notifica si la operación se completó con éxito o si ocurrió un error.
Éxito o error: Un Completable puede terminar de dos maneras:
onComplete(): Indica que la operación se completó con éxito.
onError(Throwable): Indica que ocurrió un error durante la operación.
Operaciones asíncronas: Es común usar Completable para operaciones asíncronas que no devuelven un resultado, como la escritura en una base de datos, la actualización de un archivo o la ejecución de una tarea en segundo plano.
 */