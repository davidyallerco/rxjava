package org.example.pack15;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        List<Empleado> Empleados = Arrays.asList(
                new Empleado(401, "Juan", 12000.00),
                new Empleado(402, "Maria", 15000.00),
                new Empleado(403, "Carlos", 13500.00),
                new Empleado(404, "Ana", 14000.00),
                new Empleado(405, "Luis", 12500.00),
                new Empleado(406, "Elena", 15500.00),
                new Empleado(407, "Pedro", 13000.00),
                new Empleado(408, "Laura", 16000.00),
                new Empleado(409, "Diego", 14500.00),
                new Empleado(410, "Sofia", 17000.00),
                new Empleado(411, "Andrés", 11000.00),
                new Empleado(412, "Gabriela", 17500.00),
                new Empleado(413, "Ricardo", 14800.00),
                new Empleado(414, "Fernanda", 13200.00),
                new Empleado(415, "Miguel", 15800.00)
        );

        Observable<Empleado> source = Observable.fromIterable(Empleados );

        source.filter(e->e.getSueldo()>14000)
                .sorted((e1,e2)-> Double.compare(e1.getSueldo(), e2.getSueldo()))
                .map(e-> e.getNombre())
                .take(4)
                .subscribe(System.out::println);


        Observable<Integer> source2 = Observable.just(1,5,8,3,5,9,15,20 );
        source2
                .reduce((a,b)->a+b)
        .subscribe(System.out::println);


        //concat , empieza uno y despues el segundo observable, asi le pongas con TimeUnit igual
        //te imprimira primero el obserbable 1 y despues el 2
        //hasta cuatro observalbes soporta
        Observable<String> source4 = Observable.just("Martha", "Raquel", "David","Maribel");
        Observable<String> source5 = Observable.just("Amarillo", "Rojo", "Azul","Verde");
        Observable.merge(source4,source5).subscribe(System.out::println);

        //merge, se juntan dos fuentes, como van llegando se imprimen
        //si un salta un error entonces todo se termina
        Observable<String> source6 = Observable.interval(1, TimeUnit.SECONDS).map(e->"src1: "+e);
        Observable<String> source7 = Observable.interval(1, TimeUnit.SECONDS).map(e->"src2: "+e);
        Observable.merge(source6,source7).subscribe(e->System.out.println("==>"+e));
        Thread.sleep(10000);
    }
}
