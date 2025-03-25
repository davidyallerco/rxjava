package org.example.pack11aMaybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
/*
Maybe es un tipo de observable en RxJava que representa una
secuencia que puede emitir un solo elemento, ningún elemento o un error.
Es útil cuando tienes una operación que puede o no devolver un resultado.
 */
public class Principal {
    public static void main(String[] args) {
        //Maybe devolviendo un solo elemento- caso sin lambda y de manera explicita
        Maybe<String> source = Maybe.just("David");

        source.subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onSuccess(String usuario) {
                System.out.println("onSuccess: " + usuario);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}

/*
Implementamos los cuatro métodos:
onSubscribe(Disposable d): Se llama cuando el Observer se suscribe
 al Maybe. Aquí puedes manejar la disposición del recurso si es necesario.
onSuccess(String value): Se llama cuando el Maybe emite un valor.
onError(Throwable e): Se llama si ocurre un error durante la emisión.
onComplete(): Se llama cuando el Maybe se completa sin emitir ningún valor.
 */
