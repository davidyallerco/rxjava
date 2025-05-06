package org.example.pack39Window;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Principal4FraudDetectionSystem {

    static class Transaction {
        String accountId;
        double amount;
        long timestamp;

        public Transaction(String accountId, double amount) {
            this.accountId = accountId;
            this.amount = amount;
            this.timestamp = System.currentTimeMillis();
        }

        @Override
        public String toString() {
            return String.format("[%s: $%.2f @ %d]", accountId, amount, timestamp);
        }
    }
    public static void main(String[] args) throws InterruptedException {
    // Simulador de transacciones (1 transacción cada 300ms ± 200ms)
    Observable<Transaction> transactionStream = Observable.intervalRange(
                    1,   // start
                    50,  // count
                    0,   // initialDelay
                    200, // period
                    TimeUnit.MILLISECONDS)
            .map(tick -> new Transaction(
                    "ACCT-" + (tick % 5 + 1),   // 5 cuentas diferentes
                    (Math.random() * 9000) + 1000 // Monto entre $1000-$10000
            ));

    // Pipeline de detección de fraude:
        transactionStream
                .window(2, TimeUnit.SECONDS)   // Ventana de 2 segundos
            .flatMap(window ->
            window.groupBy(tx -> tx.accountId)   // Agrupar por cuenta
            .flatMap(group ->
            group.scan(0, (count, tx) -> count + 1) // Contar transacciones por grupo
            .filter(count -> count > 2) // Emitir solo si hay más de 2
            .map(count -> "⚠ ALERTA: Cuenta " + group.getKey() +
            " tiene " + count + " transacciones en 2 segundos")
            )
            )
            .subscribeOn(Schedulers.computation())
            .subscribe(System.out::println);

    // Mantener la aplicación corriendo
        Thread.sleep(15000);
}
}
