package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.*;

public class AnyMatch {
    
    @Test
    public void anyMatchString(){
        Stream<String> stringStream = Stream.of("asd","sdf", "ertert");
        boolean anyMatch = stringStream.anyMatch(v -> v.contains("a"));
        assertThat(anyMatch).isTrue();
    }
    
    public void anyMatchInteger(){
        Stream<Integer> integerStream = Stream.of();
    }
}
