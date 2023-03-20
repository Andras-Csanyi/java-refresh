package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class ConcatStreams {
    
    @Test
    public void concatIntegerStreams(){

        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        Stream<Integer> stream2 = Stream.of(6,7,8,9,10);
        Stream<Integer> streams = Stream.concat(stream1, stream2);
        
        streams.forEach(v -> System.out.println(v));
    }
    
    @Test
    public void concatIntegerStreams2(){
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        Stream<Integer> stream2 = Stream.of(6,7,8,9,10);
        Stream<Integer> streams = Stream.concat(stream2, stream1);

        streams.forEach(v -> System.out.println(v));
    }
}
