package org.example.pack14Range;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Martha", "Raquel", "David","Maribel","Maritza","Anita","Sarita");
        source.subscribe(System.out::println);

        Observable<Integer> source1 = Observable.range(1,10);
        source1.subscribe(System.out::println);

        List<String> lista = List.of("Martha", "Raquel", "David","Maribel","Maritza","Anita","Sarita");
        Observable<String> source2 = Observable.fromIterable(lista);
        source2.subscribe(System.out::println);
        //TAKE , toma los 10 primeros
        Observable<Integer> source3 = Observable.range(1,100);
        source3.take(10).subscribe(System.out::println);
    }
}
