package stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.*;

public class CreateReferenceTypeStreams {
    
    private ExampleReferenceType instance1;
    private ExampleReferenceType instance2;
    private ExampleReferenceType instance3;
    
    @BeforeEach
    public void beforeAll(){
        instance1 = new ExampleReferenceType(1, "Alpha", "Alpha land");
        instance2 = new ExampleReferenceType(2, "Beta", "Beta land");
        instance3 = new ExampleReferenceType(3, "Charlie", "Charlie land");
    }
    
    @Test
    public void fromStreamof(){
        Stream<ExampleReferenceType> stream = Stream.of(instance1, instance2, instance3);
        stream.forEach(s-> System.out.println(s));
        assertThat(stream).isInstanceOf(Stream.class);
    }
    
    @Test
    public void fromCollection() {

        Stream<ExampleReferenceType> stream = Arrays.asList(instance1, instance2, instance3)
                .stream();
        stream.forEach(s -> System.out.println(s));
        assertThat(stream).isInstanceOf(Stream.class);
    }
}
