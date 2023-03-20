package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatePrimitiveStreams {

    @Test
    public void doubleStream() {
        DoubleStream doubleStream = DoubleStream.of(1.1, 1.2, 1.3);
        doubleStream.forEach(d -> System.out.println(d));
    }
    
//    @Test
//    public void doubleStreamWithBuilder(){
//        DoubleStream doubleStream = DoubleStream.builder()
//    }
    
    @Test
    public void intStream() {
        IntStream intStream = IntStream.of(1,2,3,4);
        intStream.forEach(System.out::println);
    }
    
    @Test
    public void longStream(){
        LongStream longStream = LongStream.of(1,2,3,4);
        longStream.forEach(System.out::println);
    }
}
