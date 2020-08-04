package br.com.ras.java.collections;

import br.com.ras.java.shared.LogUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main extends LogUtil {

    public static void main(String[] args) {
        interateList();
        sortList();
    }

    private static void interateList() {
        final List<Element> list =
                IntStream.iterate(0, n -> n+1).limit(50000).boxed()
                        .map(numb -> new Element(String.valueOf(numb), numb)).collect(Collectors.toList());

        final AtomicInteger contador = new AtomicInteger(0);

        outln("--------");
        outTime("Foreach");
        contador.set(0);
        executeTime(() -> {
            for (final Element item : list) {
                contador.addAndGet(item.value);
            }
        });
        outln("contador : " + contador.get());
        outln("--------");

        outln("--------");
        outTime("Foreach collection");
        contador.set(0);
        executeTime(() ->
                list.forEach(item -> contador.addAndGet(item.value))
        );
        outln("contador : " + contador.get());
        outln("--------");

        outln("--------");
        outTime("Foreach stream");
        contador.set(0);
        executeTime(() ->
            list.stream().forEach(item -> contador.addAndGet(item.value))
        );
        outln("contador : " + contador.get());
        outln("--------");
    }

    private static void sortList() {
        final List<String> lista = Arrays.asList("T", "A", "R", "D", "Y", "B", "E", "C", "O", "F");

        outln("-----");
        lista.sort(Comparator.comparing(s -> s));
        lista.forEach(Main::outln);
        outln("-----");
        lista.stream().sorted().forEach(Main::outln);
    }

    private static class Element {
        private final String id;
        private final Integer value;

        public Element(String id, Integer value) {
            this.id = id;
            this.value = value;
        }
    }

}
