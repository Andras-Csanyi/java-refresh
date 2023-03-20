package stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static java.util.stream.Collectors.toList;

public class Filter {
    @Test
    public void filterIntegerStream() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> oddStream = integerStream.filter((anInt) -> anInt % 2 == 0);
        assertThat(oddStream.count()).isEqualTo(4);
    }

    @Test
    public void filterIntegerStream2() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> oddStream = integerStream.filter(
                (anInt) -> anInt % 2 == 0 && anInt < 5
        );
        assertThat(oddStream.count()).isEqualTo(2);
    }

    @Test
    public void filterReferenceType() {
        ExampleReferenceType e1 = new ExampleReferenceType(1, "1asd", "asd");
        ExampleReferenceType e2 = new ExampleReferenceType(2, "2asd", "asd");
        ExampleReferenceType e3 = new ExampleReferenceType(3, "3asd", "asd");
        ExampleReferenceType e4 = new ExampleReferenceType(4, "4asd", "asd");
        ExampleReferenceType e5 = new ExampleReferenceType(5, "5asd", "asd");
        Stream<ExampleReferenceType> stream = Stream.of(e1, e2, e3, e4, e5);
        List<ExampleReferenceType> result = stream.filter(
                v -> v.getId() < 4
        ).collect(toList());
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void filterReferenceType2() {
        ExampleReferenceType e1 = new ExampleReferenceType(1, "1asd", "asd");
        ExampleReferenceType e2 = new ExampleReferenceType(2, "2asd", "asd");
        ExampleReferenceType e3 = new ExampleReferenceType(3, "3asd", "asd");
        ExampleReferenceType e4 = new ExampleReferenceType(4, "4asd", "asd");
        ExampleReferenceType e5 = new ExampleReferenceType(5, "5asd", "asd");
        Stream<ExampleReferenceType> stream = Stream.of(e1, e2, e3, e4, e5);
        List<ExampleReferenceType> result = stream
                .filter(v -> v.getId() < 4)
                .filter(v -> v.getId() < 3)
                .filter(v -> v.getId() < 2)
                .collect(toList());
        assertThat(result.size()).isEqualTo(1);
    }
}
