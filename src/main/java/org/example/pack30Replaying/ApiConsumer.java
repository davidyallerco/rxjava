//package org.example.pack30Replaying;
//
//import io.reactivex.rxjava3.core.Observable;
//import io.reactivex.rxjava3.schedulers.Schedulers;
//
//import java.util.Arrays;
//import java.util.List;
//
//
//public class ApiConsumer {
//    public Observable<String> callApi(String apiUrl) {
//        return Observable.fromCallable(() -> {
//            // Realizar solicitud HTTP a la API y devolver la respuesta
//            return "Respuesta de " + apiUrl; // Simulación de respuesta
//        });
//    }
//
//    public void consumeApis(List<String> apiUrls) {
//        Observable.zip(
//                        apiUrls.stream().map(this::callApi).toArray(Observable[]::new),
//                        Arrays::asList
//                )
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.single())
//                .subscribe(
//                        results -> System.out.println("Resultados: " + results),
//                        error -> System.err.println("Error: " + error)
//                );
//    }
//
//    public static void main(String[] args) {
//        ApiConsumer consumer = new ApiConsumer();
//        List<String> apiUrls = Arrays.asList("api1", "api2", "api3");
//        consumer.consumeApis(apiUrls);
//    }
//}
