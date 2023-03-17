package stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.*;

public class AllMatch {
    
    @Test
    public void allMatchString(){

        Stream<String> stringStream = Stream.of("alpha", "beta", "charlie", "delta");
        boolean isMatch = stringStream.allMatch(s->!s.contains(" "));
        assertThat(isMatch).isTrue();
    }
    
    @Test
    public void allMatchInteger() {
        Stream<Integer> integerStream = Stream.of(2, 4, 6, 8);
        boolean isMatch = integerStream.allMatch(s->s % 2 == 0);
        assertThat(isMatch).isTrue();
    }
    
    @Test
    public void allMatchPrimitiveInteger(){
    }
}
