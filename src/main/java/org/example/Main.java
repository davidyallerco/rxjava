package org.example;


import io.reactivex.rxjava3.core.Observable;

public class Main {
    public static void main(String[] args) {



        Observable<String> source = Observable.create(
                e-> {
                    e.onNext("Hello");
                    e.onNext("rxjava");
                }
        );
        source.subscribe(e->System.out.println("Observer 1: "+ e));
        source.subscribe(e->System.out.println("Observer 2: "+ e));
    }
}