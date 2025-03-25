package org.example.pack27GroupBy;

import io.reactivex.rxjava3.core.Observable;

public class Principal {
    public static void main(String[] args) {
        Observable<Persona> personas = Observable.just(
                new Persona("Ana", 25),
                new Persona("Juan", 30),
                new Persona("María", 25),
                new Persona("Pedro", 35),
                new Persona("Luis", 30)
        );

        personas.groupBy(Persona::getEdad)
                .subscribe(groupedObservable -> {
                    System.out.println("Grupo de edad: " + groupedObservable.getKey());
                    groupedObservable.subscribe(persona -> System.out.println(persona.getNombre()));
                });
    }
}
