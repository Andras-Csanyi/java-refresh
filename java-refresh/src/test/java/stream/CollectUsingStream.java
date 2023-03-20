package stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectUsingStream {

    @Test
    public void collectInteger() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> integerStream = integerList.stream();
        ArrayList<Integer> list = integerStream.collect(
                ArrayList::new,
                ArrayList::add,
                (c1, c2) -> c1.addAll(c2));
        assertThat(list.size()).isEqualTo(integerList.size());
    }

    @Test
    public void collectInteger2() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> integerStream = integerList.stream();

        ArrayList<String> stringResult = integerStream.collect(
                () -> new ArrayList<String>(),
                (array, number) -> array.add("some number" + number),
                (array1, array2) -> array1.addAll(array2)
        );

        stringResult.forEach(v -> System.out.println(v));
    }

    @Test
    public void collectLong() {
        List<Long> longList = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        Stream<Long> longStream = longList.stream();

        String result = longStream.collect(
                () -> new StringBuilder(),
                (builder, aLong) -> builder.append("a long value: " + aLong + " "),
                (builder1, builder2) -> builder1.append(builder2)
        ).toString();

        System.out.println(result);
    }

    @Test
    public void collectDouble() {
        List<Double> doubleList = Arrays.asList(1.1, 1.2, 1.3, 1.4, 1.5);
        Stream<Double> doubleStream = doubleList.stream();

        ArrayList<Double> result = doubleStream.collect(
                () -> new ArrayList<Double>(),
                (dList, aDouble) -> {
                    System.out.println("processed value: " + aDouble);
                    dList.add(aDouble);
                },
                (dList1, dList2) -> dList1.addAll(dList2)
        );

        result.forEach(v -> System.out.println("result: " + v));
    }

    @Test
    public void collectExampleReferenceType() {
        ExampleReferenceType exampleReferenceType1 = new ExampleReferenceType(100, "asd", "asd asd");
        ExampleReferenceType exampleReferenceType2 = new ExampleReferenceType(200, "bsd", "bsd bsd");
        ExampleReferenceType exampleReferenceType3 = new ExampleReferenceType(300, "csd", "csd csd");
        Stream<ExampleReferenceType> stream = Stream.of(exampleReferenceType1, exampleReferenceType2,
                exampleReferenceType3);
        
        ArrayList<ExampleReferenceType> collection = stream.collect(
                () -> new ArrayList<ExampleReferenceType>(),
                (arrayList, e) -> {
                    if(e.getId() > 110) {
                        String name = e.getName();
                        e.setName(name + " added");
                        arrayList.add(e);
                    }
                },
                (a1, a2) -> a1.addAll(a2)
        );
        
        collection.forEach(v -> System.out.println(v.getName()));
    }
}
