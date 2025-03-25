package org.example.pack04;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        // EJEMPLO OBSERVABLE COLD
        System.out.println("--------------------- INICIO ---------------------------");

        List<String> lista = new ArrayList<>();
        lista.add("Martha");
        lista.add("Raquel");
        lista.add("David");

        Observable<String> source = Observable.fromIterable(lista);

        source.subscribe(System.out::println);

        // agregamos algo a la lista
        lista = getData(lista);

        System.out.println("-----------");
        // segunda subscribcion
        source.subscribe(System.out::println);

        System.out.println("---------------------  FIN  ----------------------------");
    }
    private static List<String> getData(List<String> lista) {
        lista.add("Maribel");
        return lista;
    }
}
