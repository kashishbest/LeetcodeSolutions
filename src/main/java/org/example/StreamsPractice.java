package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsPractice {

    static Product getP(String n, double p) {
        return new Product(n, p);
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList(new String[]{"hello", "world", "hello", "world"});
        Map<String, Long> output = input.stream().sorted().collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(output);

        List<Integer> i1 = Arrays.asList(1, 2, 3, 4, 5, 2, -2);

        List<Integer> o1 = i1.stream().filter(n -> n % 2 == 0).map(n -> n * n).distinct().collect(Collectors.toList());
        System.out.println(o1);

        i1 = Arrays.asList(1, 2, 3, 1, 1, 2, -2);
        int o2 = i1.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).get();
        System.out.println(o2);

        List<Product> i2 = Arrays.asList(getP("a", 1), getP("b", 2), getP("c", 3), getP("d", 4));
        int threshold = 2;
        List<String> o3 = i2.stream().filter(product -> product.price > threshold).map(product -> product.name).collect(Collectors.toList());
        System.out.println(o3);

        int size = 2;
        List<String> o4 = i2.stream()
                .filter(product -> product.price > threshold)
                .sorted((p1, p2) -> Double.compare(p2.price, p1.price))
                .limit(size)
                .map(product -> product.name)
                .collect(Collectors.toList());
        System.out.println(o4);


    }

    public static class Product {
        String name;
        double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }
}
