package org.example.pack26conbineLatest;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Principal2 {
    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> numbers = Observable.just(1, 2, 3);
        Observable<String> letters = Observable.just("A", "B", "C","D");

        Observable.combineLatest(
                numbers,
                letters,
                (number, letter) -> number + letter
        ).subscribe(result -> System.out.println(result));
    }
}
