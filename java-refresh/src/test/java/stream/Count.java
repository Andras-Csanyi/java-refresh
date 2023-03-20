package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Count {
    @Test
    public void integerStreamCount(){
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
        Long size = integerStream.count();
        
        assertThat(size).isEqualTo(5);
    }
}
