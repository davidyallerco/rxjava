package org.example.pack11eMaybe;

import io.reactivex.rxjava3.core.Maybe;

public class Principal {
    public static void main(String[] args) {
        // Llamamos a la función que devuelve un Maybe
        obtenerUsuarioPorId(1)
                .subscribe(
                        usuario -> System.out.println("Usuario encontrado: " + usuario),  // onSuccess
                        error -> System.out.println("Error en la consulta: " + error.getMessage()),  // onError
                        () -> System.out.println("No se encontró el usuario")  // onComplete
                );
    }

    // Simulación de consulta a base de datos
    public static Maybe<String> obtenerUsuarioPorId(int id) {
        return Maybe.create(emitter -> {
            String usuario = buscarUsuarioEnDB(id);
            if (usuario != null) {
                emitter.onSuccess(usuario); // Emite el usuario si existe
            } else {
                emitter.onComplete(); // No hay usuario, se completa sin emitir nada
            }
        });
    }

    // Simulación de base de datos
    public static String buscarUsuarioEnDB(int id) {
        return (id == 1) ? "Juan Pérez" : null;
    }
}
/*
En RxJava, el emitter que se utiliza dentro de Maybe.create() no es
directamente un Observer ni un Observable. Es un objeto de tipo MaybeEmitter.

MaybeEmitter
Es un puente que permite al código que se ejecuta dentro de Maybe.create()
 comunicarse con el Maybe que se está creando.
Proporciona métodos para emitir un valor (onSuccess()), señalar
un error (onError()) o indicar que se ha completado sin emitir ningún valor (onComplete()).
 */
