package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class AnyMatch {

    @Test
    public void anyMatchString() {
        Stream<String> stringStream = Stream.of("asd", "sdf", "ertert");
        boolean anyMatch = stringStream.anyMatch(v -> v.contains("a"));
        assertThat(anyMatch).isTrue();
    }

    @Test
    public void anyMatchInteger() {
        Stream<Integer> integerStream = Stream.of(1, 3, 5, 8);
        boolean anyMatch = integerStream.anyMatch(n -> n % 2 == 0);
        assertThat(anyMatch).isTrue();
    }

    @Test
    public void anyMatchLong() {
        Stream<Long> longStream = Stream.of(101L, 301L, 417L, 500L);
        boolean anyMatch = longStream.anyMatch(n -> n % 2 == 0);
        assertThat(anyMatch).isTrue();
    }
    
    @Test
    public void anyMatchDouble() {
        Stream<Double> doubleStream = Stream.of(10.1, 11.1, 12.1, 14.8);
        boolean anyMatch = doubleStream.anyMatch(v -> v > 14);
        assertThat(anyMatch).isTrue();
    }

    @Test
    public void anyMatchReferenceType() {
        ExampleReferenceType exampleReferenceType1 = new ExampleReferenceType(100, "asd", "asd asd");
        ExampleReferenceType exampleReferenceType2 = new ExampleReferenceType(200, "bsd", "bsd bsd");
        ExampleReferenceType exampleReferenceType3 = new ExampleReferenceType(300, "csd", "csd csd");
        Stream<ExampleReferenceType> exampleReferenceTypeStream = Stream.of(
                exampleReferenceType1, 
                exampleReferenceType2, 
                exampleReferenceType3);
        boolean anyMatch = exampleReferenceTypeStream.anyMatch(v -> v.getName().contains("asd"));
        assertThat(anyMatch).isTrue();
    }
}
