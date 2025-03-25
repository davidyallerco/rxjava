package org.example.pack27GroupBy;

import io.reactivex.rxjava3.core.Observable;

public class Principal2 {
    public static void main(String[] args) {
        Observable<String> words = Observable.just("apple", "banana", "cherry", "date", "elderberry");

        words.groupBy(word -> word.length()) // Agrupar por longitud de la palabra
                .subscribe(group -> {
                    System.out.println("Grupo de palabras con " + group.getKey() + " letras:");
                    group.subscribe(word -> System.out.println(" - " + word));
                });
    }
}
