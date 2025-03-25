package org.example.pack28Concurrencia;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
/*
Caso de uso: Obtener datos de múltiples APIs
Supongamos que tienes que obtener información de tres APIs diferentes:
API de usuarios: Devuelve información básica de un usuario.
API de pedidos: Devuelve los pedidos realizados por un usuario.
API de productos: Devuelve detalles de los productos en los pedidos.

Quieres combinar estos datos para mostrar una vista consolidada de la
información del usuario, sus pedidos y los detalles de los productos.
 */
public class Principal3 {
    public static void main(String[] args) throws InterruptedException {
        // Simulamos las llamadas a las APIs
        Observable<String> userApi = getUserInfo("123")
                .subscribeOn(Schedulers.io()); // Ejecuta en un hilo de E/S

        Observable<String> ordersApi = getOrders("123")
                .subscribeOn(Schedulers.io()); // Ejecuta en un hilo de E/S

        Observable<String> productsApi = getProducts("456")
                .subscribeOn(Schedulers.io()); // Ejecuta en un hilo de E/S

        // Combinamos los resultados de las APIs
        Observable.zip(
                        userApi,
                        ordersApi,
                        productsApi,
                        (userInfo, orders, products) -> "Usuario: " + userInfo + "\nPedidos: " + orders + "\nProductos: " + products
                )
                .observeOn(Schedulers.newThread()) // Procesa el resultado en un nuevo hilo
                .subscribe(
                        result -> System.out.println("Resultado combinado:\n" + result ),
                        error -> System.err.println("Error: " + error.getMessage()),
                        () -> System.out.println("Proceso completado!")
                );

        // Esperamos un momento para que los hilos terminen su trabajo
        try {
            Thread.sleep(5000); // Espera 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // Simula una llamada a la API de usuarios
    private static Observable<String> getUserInfo(String userId) {
        return Observable.just("Nombre: Juan Pérez, Email: juan@example.com")
                .delay(1, TimeUnit.SECONDS); // Simula un retardo de red
    }

    // Simula una llamada a la API de pedidos
    private static Observable<String> getOrders(String userId) {
        return Observable.just("Pedido 1, Pedido 2, Pedido 3")
                .delay(2, TimeUnit.SECONDS); // Simula un retardo de red
    }

    // Simula una llamada a la API de productos
    private static Observable<String> getProducts(String orderId) {
        return Observable.just("Producto A, Producto B, Producto C")
                .delay(3, TimeUnit.SECONDS); // Simula un retardo de red
    }
}

/*
Vamos a simular las llamadas a las APIs usando Observable y a manejar
la concurrencia con subscribeOn y observeOn.

Explicación del código
Simulación de APIs:

Cada método (getUserInfo, getOrders, getProducts) simula una llamada a una API utilizando
Observable.just y delay para simular un retardo de red.
Cada llamada se ejecuta en un hilo de E/S (Schedulers.io()).
Concurrencia:
Usamos subscribeOn(Schedulers.io()) para ejecutar cada llamada a la API en un hilo de E/S.
Usamos Observable.zip para combinar los resultados de las tres APIs cuando todas hayan terminado.
Procesamiento de resultados:
Usamos observeOn(Schedulers.newThread()) para procesar el resultado combinado en un nuevo hilo.
Espera:
Usamos Thread.sleep(5000) para mantener el programa en ejecución mientras las llamadas a las APIs se completan.

 */