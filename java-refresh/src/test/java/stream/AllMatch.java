package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class AllMatch {

    @Test
    public void allMatchString() {

        Stream<String> stringStream = Stream.of("alpha", "beta", "charlie", "delta");
        boolean isMatch = stringStream.allMatch(s -> !s.contains(" "));
        assertThat(isMatch).isTrue();
    }

    @Test
    public void allMatchInteger() {
        Stream<Integer> integerStream = Stream.of(2, 4, 6, 8);
        boolean isMatch = integerStream.allMatch(s -> s % 2 == 0);
        assertThat(isMatch).isTrue();
    }

    @Test
    public void allMatchPrimitiveDouble() {
        DoubleStream doubleStream = DoubleStream.of(1.1, 1.2, 1.3);
        boolean isMatch = doubleStream.allMatch(s -> s < 2);
        assertThat(isMatch).isTrue();
    }

    @Test
    public void allMatchPrimitiveInteger() {
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        boolean isMatch = intStream.allMatch(v -> v < 5);
        assertThat(isMatch).isTrue();
    }

    public void allMatchPrimitiveLong() {
        LongStream longStream = LongStream.of(1, 2, 3, 4);
        boolean isMatch = longStream.allMatch(v -> v < 5);
        assertThat(isMatch).isTrue();
    }
    
    @Test
    public void allMatchReferenceType(){
        ExampleReferenceType one = new ExampleReferenceType(1,"asd", "asdasd");
        ExampleReferenceType two = new ExampleReferenceType(2,"asda", "asdasd");
        ExampleReferenceType three = new ExampleReferenceType(3,"asdad", "asdasd");
        Stream<ExampleReferenceType> stream = Stream.of(one, two, three);
        boolean allMatch = stream.allMatch(v -> v.getName().contains("asd"));
        assertThat(allMatch).isTrue();
    }
}
