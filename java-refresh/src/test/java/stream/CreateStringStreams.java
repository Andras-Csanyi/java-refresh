package stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.*;

public class CreateStringStreams {

    @Test
    public void fromStreamof() {
        Stream<String> stringStream = Stream.of("first", "second", "third");
        stringStream.forEach(s-> System.out.println(s));
        assertThat(stringStream).isInstanceOf(Stream.class);
    }

    @Test
    public void fromCollection() {

        List<String> strings = new ArrayList<>();
        strings.add("first");
        strings.add("second");
        strings.add("third");

        Stream<String> stringStream = strings.stream();
        stringStream.forEach((s) -> System.out.println(s));

        assertThat(stringStream).isInstanceOf(Stream.class);
    }

    @Test
    public void fromArrays() {

        Stream<String> stringStream = Arrays.asList("first", "second", "third").stream();
        stringStream.forEach(s -> System.out.println(s));

        assertThat(stringStream).isInstanceOf(Stream.class);
    }

    @Test
    public void fromStreamSupportSpliterator() {

        List<String> strings = Arrays.asList("alpha", "beta", "charlie");
        Stream<String> stringStream = StreamSupport.stream(strings.spliterator(), false);
        stringStream.forEach(s -> System.out.println(s));

        assertThat(stringStream).isInstanceOf(Stream.class);
    }

    @Test
    public void fromStreamSupportSupplier() {
        List<String> strings = Arrays.asList("alpha", "beta", "charlie");
        Stream<String> stringStream = StreamSupport
                .stream(() -> strings.spliterator(), Spliterator.ORDERED, false);
        stringStream.forEach(s -> System.out.println(s));

        assertThat(stringStream).isInstanceOf(Stream.class);
    }

    @Test
    public void fromPattern() {

        String string = "something text comes here";
        Pattern pattern = Pattern.compile("thing");
        Stream<String> stringStream = pattern.splitAsStream(string);
        stringStream.forEach(s -> System.out.println(s));

        assertThat(stringStream).isInstanceOf(Stream.class);
    }
}
