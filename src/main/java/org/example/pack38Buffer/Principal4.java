package org.example.pack38Buffer;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Caso real: Enviar lotes de datos a una API cada 5 elementos
Imagina que estás leyendo eventos o registros desde una fuente (como una base de datos, archivo, o socket),
y por eficiencia, solo quieres enviar a la API lotes de 5 registros a la vez.
 */
public class Principal4 {
    public static void main(String[] args) throws InterruptedException {
        // Simula un flujo continuo de eventos cada 300ms
        Observable<Long> events = Observable.interval(300, TimeUnit.MILLISECONDS).take(12);

        // Agrupa los eventos en lotes de 5
        events
                .buffer(5)
                .subscribe(
                        Principal4::enviarALaApi,
                        Throwable::printStackTrace,
                        () -> System.out.println("✔️ Proceso completado")
                );

        // Esperamos lo suficiente para que se procesen todos los eventos
        Thread.sleep(5000);
    }

    private static void enviarALaApi(List<Long> lote) {
        System.out.println("📤 Enviando lote a la API: " + lote);
    }
}
