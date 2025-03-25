package org.example.pack32;

import io.reactivex.rxjava3.core.Observable;

public class Principal {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Orange", "Black", "Red");
        //onNext,onError,onComplete
        System.out.println("---------------------------------------------------");
        source.subscribe(
                i -> System.out.println(i),Throwable::printStackTrace,() -> System.out.println("Completed!")
        );
        //onNext, onErro
        System.out.println("--------------------------------------------------");

        source.subscribe(
                i -> System.out.println(i),Throwable::printStackTrace
        );
        //onNext
        System.out.println("---------------------------------------------------");

        source.subscribe(i -> System.out.println(i));
    }
}
