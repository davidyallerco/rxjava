package org.example.pack38Buffer;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
buffer() en RxJava, simulando un sistema de batch processing para guardar lecturas de
sensores en una base de datos de manera eficiente:
 */
public class Principal6SensorBatchProcessor {
    // Simulación: Lecturas de sensor (timestamp, valor)
    static class SensorReading {
        long timestamp;
        double value;

        public SensorReading(long timestamp, double value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("[%d: %.2f]", timestamp, value);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Simulador de lecturas de sensor (1 lectura cada 100ms)
        Observable<SensorReading> sensorData = Observable.interval(100, TimeUnit.MILLISECONDS)
                .map(tick -> new SensorReading(
                        System.currentTimeMillis(),
                        Math.random() * 100 // Valor aleatorio entre 0-100
                ));

        // Pipeline de procesamiento:
        sensorData
                .buffer(5, TimeUnit.SECONDS)  // Agrupa lecturas cada 5 segundos
                .observeOn(Schedulers.io())   // Ejecuta en hilo de I/O
                .subscribe(
                        Principal6SensorBatchProcessor::saveToDatabase,  // Guarda el lote
                        Throwable::printStackTrace,
                        () -> System.out.println("Proceso completado")
                );

        // Mantener la aplicación corriendo
        Thread.sleep(30000);
    }

    // Simulación: Guardar un lote en base de datos
    private static void saveToDatabase(List<SensorReading> batch) {
        System.out.println("\n--- INSERTANDO LOTE (" + batch.size() + " registros) ---");

        // Simulación de INSERT en batch (mucho más eficiente que insertar uno a uno)
        batch.forEach(reading ->
                System.out.println("INSERT INTO sensor_data VALUES (" +
                        reading.timestamp + ", " + reading.value + ")")
        );

        System.out.println("--- LOTE GUARDADO (" + batch.size() + " registros) ---\n");
    }
}
/*
¿Por qué usar buffer() aquí?
Eficiencia en Base de Datos:
Las inserciones por lotes (batch inserts) son 10-100x más rápidas que inserts individuales.

Control de Frecuencia:
Evita saturar la DB con requests continuos (ej: 1 insert cada 100ms vs. 1 lote cada 5 segundos).

Uso de Recursos:
Reduce el consumo de CPU y red al minimizar transacciones.
 */