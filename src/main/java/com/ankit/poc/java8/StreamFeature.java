package com.ankit.poc.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFeature {
  public static void main(String[] args) {
    List<Student> studentList = Stream.of(
        new Student(2, "ankit", 87, 23, "M", "IT", "Begusarai",
            Arrays.asList("788456465465", "894132654654")),
        new Student(2, "sonam", 45, 23, "F", "HR", "Pune", Arrays.asList("78678678", "4878778788")),
        new Student(2, "leena", 98, 23, "M", "IT", "Delhi",
            Arrays.asList("457878784545", "457875")),
        new Student(2, "mongia", 34, 23, "M", "IT", "Goa",
            Arrays.asList("5478877854445", "4587878")),
        new Student(2, "ram", 56, 23, "M", "IT", "Pune", Arrays.asList("4545454545", "854454545")),
        new Student(2, "sita", 99, 23, "M", "HR", "Dehu", Arrays.asList("454545", "4545454545")),
        new Student(2, "getta", 65, 23, "M", "BD", "Guhati",
            Arrays.asList("1224878787", "87787878")),
        new Student(2, "hena", 43, 23, "M", "BD", "Asam",
            Arrays.asList("7787833264", "8778787844")),
        new Student(2, "suresh", 33, 28, "M", "IT", "Bangluru",
            Arrays.asList("4477833233", "47878111")),
        new Student(2, "shri", 43, 23, "M", "HR", "Mumbai",
            Arrays.asList("4457878778", "877821211")),
        new Student(2, "akshay", 82, 22, "M", "IT", "Katak",
            Arrays.asList("78785332", "7878454454")))
        .collect(Collectors.toList());

    List<String> names = Arrays.asList("ankit", null, "ram", "sita", "geeta");
    List<Integer> numbers = List.of(3, 2, 35, 54, 65, 2);
    // 1 Stream::ofNullable
    List<String> collect = names.stream().filter(x -> x != null).collect(Collectors.toList());
    // System.out.println(collect);

    List<String> collect2 = names.stream().flatMap(Stream::ofNullable).collect(Collectors.toList());
    // System.out.println(collect2);
    IntStream n = IntStream.rangeClosed(1, 10);
    n.filter(x -> x % 2 == 0).boxed().collect(Collectors.toList());


    // 2 Stream.iterate
    Stream.iterate(0, i -> i + 2).limit(10).skip(1).forEach(System.out::println);

    // 3 Collectors.collectingAndThen
    Long collect3 = studentList.stream().mapToDouble(Student::getRank).boxed().collect(
        Collectors.collectingAndThen(Collectors.averagingDouble(Double::doubleValue), Math::round));
    // System.out.println(collect3);

    // 4 stream().takeWhile(x -> x < 5) java9

    List<Integer> collect4 = numbers.stream().takeWhile(x -> x < 5).collect(Collectors.toList());
    // System.out.println(collect4);

    List<Integer> collect5 =
        numbers.stream().dropWhile(x -> x < 5).distinct().collect(Collectors.toList());
    // System.out.println(collect5);

    // 5 Collectors.teeing java12
    // downstream 1 maxBy
    // downstream 2 minBy
    // merger create a new map by using max and min value
    Map<String, Integer> minMaxMap = numbers.stream()
        .collect(Collectors.teeing(Collectors.maxBy(Integer::compareTo),
            Collectors.minBy(Integer::compareTo),
            (max, min) -> Map.of("max", max.get(), "min", min.get())));
    // System.out.println(minMaxMap);

    // 6 Stream.concat()

    Stream<Integer> stream1 = Stream.of(1, 2, 3);

    Stream<Integer> stream2 = Stream.of(5, 6, 7);
    int sum = Stream.concat(stream1, stream2).mapToInt(Integer::intValue).sum();
    // System.out.println(sum);

    // 7 Collectors.partitioningBy
    Map<Boolean, List<Integer>> partionMap =
        numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
    // System.out.println("Even number: " + partionMap.get(Boolean.TRUE));
    // System.out.println("Odd number: " + partionMap.get(Boolean.FALSE));

    // 8 IntStream for Ranges

    List<Integer> intRangeValue = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
    // System.out.println(intRangeValue);

    String value = "java";


    Map<String, Integer> mapEachValueCountByFrequency = Arrays.stream(value.split(""))
        .collect(Collectors.toMap(
            v -> v, v -> Collections
                .frequency(Arrays.stream(value.split("")).collect(Collectors.toList()), v),
            (extingCount, newCount) -> extingCount));



    Map<String, Long> mapEachValueCount = Arrays.stream(value.split(""))
        .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()));

    // System.out.println(mapEachValueCount);

    List<String> splitedValue = Arrays.stream(value.split("")).collect(Collectors.toList());



    List<String> duplicateValues = Arrays.stream(value.split(""))
        .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey)
        .collect(Collectors.toList());



    // System.out.println(duplicateValues);

    List<String> uniqueValues = Arrays.stream(value.split(""))
        .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey)
        .collect(Collectors.toList());
    // System.out.println(uniqueValues);



    String firstUniqueValue = Arrays.stream(value.split(""))
        .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).findFirst()
        .get();



    // System.out.println(firstUniqueValue);

    String firstRepeatedValue = Arrays.stream(value.split(""))
        .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey).findFirst().get();



    // System.out.println(firstRepeatedValue);

    int[] arrayNumbers = {5, 9, 11, 2, 8, 21, 1};

    Integer integer = Arrays.stream(arrayNumbers).boxed().sorted(Comparator.reverseOrder())
        .collect(Collectors.toList()).get(1);
    System.out.println(integer);

    String first = Arrays.stream(value.split(""))
        .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(x -> x.getValue() == 1).map(x -> x.getKey()).findFirst().get();
    System.out.println(first);

  }
}
