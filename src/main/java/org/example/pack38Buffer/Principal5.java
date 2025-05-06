package org.example.pack38Buffer;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;
/*
Un caso real común donde el operador buffer() en RxJava resulta muy útil es en el procesamiento por
lotes de eventos o datos que llegan a alta velocidad, como eventos de clicks en una interfaz de
usuario o lecturas de sensores.

Imagina una aplicación que rastrea los movimientos del mouse de un usuario. Se generan
muchísimos eventos de "mousemove" por segundo. Si intentaras procesar y responder a
cada uno de estos eventos individualmente (por ejemplo, actualizar una coordenada
en la pantalla), la aplicación podría volverse muy lenta e ineficiente.

Aquí es donde buffer() puede optimizar el proceso:

El Observable fuente: Sería el flujo continuo de eventos "mousemove".

Aplicando buffer(): Podrías usar buffer() para agrupar estos eventos en lotes basados
en el tiempo (por ejemplo, recolectar todos los eventos de los últimos 100 milisegundos)
o por conteo (por ejemplo, agrupar los últimos 50 eventos).

El Observer: En lugar de procesar cada evento individualmente, el Observer recibiría
una lista de eventos de movimiento del mouse.

Procesamiento por lote: Dentro del Observer, podrías entonces realizar un procesamiento
más eficiente sobre el lote de eventos. Por ejemplo, podrías calcular la trayectoria
general del mouse durante ese intervalo de tiempo en lugar de actualizar la posición
por cada pequeño movimiento. O podrías enviar los datos a un servidor en lotes más
grandes, reduciendo la sobrecarga de las peticiones individuales.
 */
public class Principal5 {
    public static void main(String[] args) throws InterruptedException {

        // Simulación de un flujo de eventos de movimiento del mouse muy rápido
        Observable<Point> mouseMovements = Observable.interval(10, TimeUnit.MILLISECONDS)
                .map(i -> new Point((int) (Math.random() * 100), (int) (Math.random() * 100)));

        System.out.println("Iniciando captura de movimientos del mouse...");

        mouseMovements
                .buffer(100, TimeUnit.MILLISECONDS) // Agrupa los eventos cada 100 milisegundos
                .observeOn(Schedulers.computation()) // Procesa los lotes en un hilo de cálculo
                .subscribe(
                        batch -> {
                            System.out.println("Procesando lote de " + batch.size() + " movimientos.");
                            // Aquí podrías realizar un procesamiento más eficiente del lote
                            // Por ejemplo, calcular la velocidad promedio, la trayectoria, etc.
                            // batch.forEach(System.out::println); // Si quisieras ver cada punto
                        },
                        Throwable::printStackTrace,
                        () -> System.out.println("Procesamiento completado")
                );

        Thread.sleep(5000); // Ejecutar durante 5 segundos
        System.out.println("Deteniendo captura.");
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
/*
En este ejemplo:

Simulamos un flujo rápido de eventos MouseMovements.
Usamos buffer(100, TimeUnit.MILLISECONDS) para agrupar todos los eventos que ocurren dentro de
un intervalo de 100 milisegundos.
El subscribe() recibe una List<Point> (el lote de movimientos).
El procesamiento del lote se realiza en un hilo de cálculo (Schedulers.computation()) para no
bloquear el hilo principal donde se emiten los eventos.
Otros casos reales donde buffer() es útil:

Procesamiento de formularios: En lugar de enviar cada cambio en un formulario individualmente,
puedes buffer los cambios durante un breve período y luego enviar todos los datos juntos.
Ingesta de datos de sensores: Agrupar lecturas de múltiples sensores antes de analizarlas o almacenarlas.
Operaciones de base de datos por lotes: Recopilar varias operaciones de escritura y ejecutarlas
en un lote para mejorar el rendimiento.
Control de velocidad (throttling): Aunque existen operadores dedicados para esto, buffer() con
un límite de tamaño podría usarse para procesar un máximo de N elementos cada cierto tiempo.
En resumen, buffer() es una herramienta poderosa en RxJava para optimizar el rendimiento y la
eficiencia al procesar flujos de datos de alta velocidad o cuando las operaciones por lotes son
más eficientes que las operaciones individuales.
 */