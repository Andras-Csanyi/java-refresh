package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DropWhile {
    @Test
    public void dropWhile(){
        ExampleReferenceType e1 = new ExampleReferenceType(1,"asd","asdasd");
        ExampleReferenceType e2 = new ExampleReferenceType(2,"asd","asdasd");
        ExampleReferenceType e3 = new ExampleReferenceType(3,"asd","asdasd");
        ExampleReferenceType e10 = new ExampleReferenceType(10,"asd","asdasd");

        Stream<ExampleReferenceType> stream = Stream.of(e1, e2, e3, e10);
        Stream<ExampleReferenceType> streamResult = stream.dropWhile(
                p -> p.getId() < 9
        );
        
        assertThat(streamResult.count()).isEqualTo(1);
    }

    @Test
    public void dropWhile2(){
        ExampleReferenceType e1 = new ExampleReferenceType(1,"asd","asdasd");
        ExampleReferenceType e2 = new ExampleReferenceType(2,"asd","asdasd");
        ExampleReferenceType e3 = new ExampleReferenceType(3,"asd","asdasd");
        ExampleReferenceType e10 = new ExampleReferenceType(10,"asd","asdasd");

        Stream<ExampleReferenceType> stream = Stream.of(e10, e3, e2, e1);
        Stream<ExampleReferenceType> streamResult = stream.dropWhile(
                p -> p.getId() > 9
        );

        assertThat(streamResult.count()).isEqualTo(3);
    }
}
