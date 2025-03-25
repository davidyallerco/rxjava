package org.example.pack11bMaybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class Principal {
    public static void main(String[] args) {
        //Maybe devolviendo cero elementos - caso sin lambda y de manera explicita
        Maybe<String> source = Maybe.empty();

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
