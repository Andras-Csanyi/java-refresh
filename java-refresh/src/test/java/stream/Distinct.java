package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class Distinct {
    
    @Test
    public void distinct() {
        ExampleReferenceType exampleReferenceType1 = new ExampleReferenceType(1, "asd", "asd");
        ExampleReferenceType exampleReferenceType2 = new ExampleReferenceType(1, "asd", "asd");
        ExampleReferenceType exampleReferenceType3 = new ExampleReferenceType(1, "asd", "asd");
        Stream<ExampleReferenceType> stream = Stream.of(exampleReferenceType1, exampleReferenceType2,
                exampleReferenceType3);
        
        Stream<ExampleReferenceType> distinctResult = stream.distinct();
        System.out.println(distinctResult.toString());
    }
}
