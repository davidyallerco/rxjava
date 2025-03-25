package org.example.pack12a;

import io.reactivex.rxjava3.core.Completable;

public class Principal {
    public static void main(String[] args) {
        //Sin emisión de datos: Un Completable no emite ningún valor.
        //Su propósito principal es indicar que una operación se ha completado o ha fallado.
        //Finalización o error: Un Completable puede estar
        // en uno de dos estados: completado (exitoso) o error.

        // Uso del Completable:
        guardarDatos("David")
                .subscribe(
                        () -> System.out.println("Datos guardados correctamente."),
                        error -> System.err.println("Error al guardar los datos: " + error.getMessage())
                );
    }

    static Completable guardarDatos(String dato) {
        return Completable.create(emitter -> {
            try {
                // Simula guardar los datos en una base de datos.
                guardarDatosEnLaBaseDeDatos(dato);
                emitter.onComplete(); // Indica que la operación se completó con éxito.
            } catch (Exception e) {
                emitter.onError(e); // Indica que ocurrió un error durante la operación.
            }
        });
    }

    private static void guardarDatosEnLaBaseDeDatos(String datos){
        System.out.println("Guardando en la base de datos... : "+ datos);
    }

}
