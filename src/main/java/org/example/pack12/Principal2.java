package org.example.pack12;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class Principal2 {

        public static void main(String[] args) {
            // Completable sin lamba y de manera explicita
            Completable completable = Completable.create(emitter -> {
                // Simular una operación que puede fallar o completarse
                boolean success = realizarOperacion();
                if (success) {
                    emitter.onComplete(); // Operación exitosa
                } else {
                    emitter.onError(new RuntimeException("Operación fallida")); // Operación fallida
                }
            });

            // Suscribir un Observer al Completable
            completable.subscribe(new CompletableObserver() {
                @Override
                public void onSubscribe(Disposable d) {
                    System.out.println("Subscrito");
                }

                @Override
                public void onComplete() {
                    System.out.println("Operación completada con éxito");
                }

                @Override
                public void onError(Throwable e) {
                    System.err.println("Error: " + e.getMessage());
                }
            });
        }

        private static boolean realizarOperacion() {
            // Simular una operación que puede fallar o tener éxito
            return Math.random() > 0.5;
        }
}
