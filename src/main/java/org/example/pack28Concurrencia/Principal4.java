package org.example.pack28Concurrencia;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Un caso típico en aplicaciones empresariales es cuando necesitas hacer
múltiples llamadas a una API externa, procesar los datos y almacenarlos
en una base de datos de manera concurrente.

Supongamos que tenemos una lista de IDs de usuarios y necesitamos:
Consultar la información de cada usuario en una API externa.
Procesar los datos y transformarlos.
Almacenar los resultados en una base de datos.
Todo esto sin bloquear el hilo principal y de manera concurrente.
 */
public class Principal4 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> userIds = Arrays.asList(101, 102, 103, 104, 105);

        Observable.fromIterable(userIds)
                .subscribeOn(Schedulers.io()) // Ejecuta en un hilo de I/O (ideal para llamadas a APIs)
                .flatMap(userId -> getUserFromApi(userId) // Simulación de API REST
                        .subscribeOn(Schedulers.io()) // Cada llamada a la API se ejecuta en un hilo separado
                        .map(user -> processUserData(user)) // Simula procesamiento de datos
                        .flatMap(user -> saveUserToDatabase(user)) // Simula almacenamiento en DB
                )
                .observeOn(Schedulers.single()) // Se observa en un único hilo
                .subscribe(result -> System.out.println("✅ Usuario almacenado: " + result + " en " + Thread.currentThread().getName()),
                        error -> System.out.println("❌ Error: " + error),
                        () -> System.out.println("🎉 ¡Proceso completado!"));

        Thread.sleep(5000); // Se usa para esperar que terminen los hilos antes de que finalice la app
    }
    // Simula una llamada a una API REST externa
    private static Observable<String> getUserFromApi(int userId) {
        return Observable.fromCallable(() -> {
            System.out.println("📡 Consultando API para usuario " + userId + " en " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1); // Simula retardo de la API
            return "Usuario_" + userId;
        });
    }

    // Simula el procesamiento de los datos del usuario
    private static String processUserData(String user) {
        System.out.println("🔄 Procesando datos de " + user + " en " + Thread.currentThread().getName());
        return user.toUpperCase();
    }

    // Simula el almacenamiento del usuario en la base de datos
    private static Observable<String> saveUserToDatabase(String user) {
        return Observable.fromCallable(() -> {
            System.out.println("💾 Guardando " + user + " en la DB en " + Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(500); // Simula tiempo de almacenamiento en BD
            return user;
        });
    }
}

/*
📌 Explicación paso a paso
✅ fromIterable(userIds): Convierte la lista de IDs de usuarios en un Observable.
✅ subscribeOn(Schedulers.io()): Ejecuta la lógica en un hilo de I/O (ideal para APIs y BD).
✅ flatMap(userId -> getUserFromApi(userId)):

Llama a una API REST de manera concurrente.
Cada llamada se ejecuta en un hilo separado.
✅ map(user -> processUserData(user)): Procesa los datos antes de guardarlos.
✅ flatMap(user -> saveUserToDatabase(user)): Guarda los datos en la base de datos.
✅ observeOn(Schedulers.single()): Procesa los resultados en un solo hilo para evitar condiciones de carrera.
 */