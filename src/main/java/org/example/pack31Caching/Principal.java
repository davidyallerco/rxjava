package org.example.pack31Caching;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;
/*
Imagina que tienes una aplicación que necesita obtener datos de una API externa.
La llamada a la API es costosa en términos de tiempo y recursos. Si varios
componentes de tu aplicación necesitan los mismos datos, no quieres realizar
la llamada a la API repetidamente.

Solución con cache():
Observable de la API:
Crea un Observable que realice la llamada a la API y emita los datos.
Caching:
Aplica el operador cache() al Observable de la API.
Suscripciones:
Todos los componentes que necesiten los datos se suscriben al Observable con cache().
La primera suscripción realizará la llamada a la API.
Las suscripciones posteriores recibirán los datos almacenados en caché.
 */
public class Principal {
    public static void main(String[] args) throws InterruptedException {
        // Simulación de una llamada a la API (costosa)
        Observable<String> datosAPI = Observable.fromCallable(() -> {
            System.out.println("Realizando llamada a la API...");
            TimeUnit.SECONDS.sleep(2); // Simula el tiempo de espera de la API
            return "Datos de la API";
        }).cache();

        // Primera suscripción
        datosAPI.subscribe(datos -> System.out.println("Suscriptor 1: " + datos));

        // Segunda suscripción (inmediata)
        datosAPI.subscribe(datos -> System.out.println("Suscriptor 2: " + datos));

        // Tercera suscripción (después de un tiempo)
        Thread.sleep(3000);
        datosAPI.subscribe(datos -> System.out.println("Suscriptor 3: " + datos));
    }
}

/*
En este ejemplo, la llamada a la API solo se realiza una vez, incluso con múltiples suscripciones.
2. Configuración de la aplicación
Si tu aplicación carga su configuración desde un archivo o una base de datos, puedes usar cache()
para almacenar la configuración y evitar recargarla repetidamente.
3. Resultados de cálculos complejos
Si tienes un Observable que realiza cálculos complejos, puedes usar cache() para almacenar el
resultado y evitar recalcularlo.
Puntos clave:
cache() almacena la última emisión del Observable.
Las suscripciones posteriores reciben la emisión almacenada en caché.
cache() es útil para evitar operaciones costosas repetidas.
Es importante tener en cuenta que cache() almacena la emisión de forma indefinida. Si los
datos subyacentes cambian, el caché no se actualizará automáticamente. En tales casos, es
posible que necesites invalidar o actualizar el caché manualmente.

 */
