package reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class GetDeclaredFieldsExample {

    private String field1;
    private String field2;
    private String field3;
    private String field4;

    public List<Field> getDeclaredFields() {
        return Arrays.stream(this.getClass().getDeclaredFields()).toList();
    }

    public static void main(String[] args) {
        new GetDeclaredFieldsExample().getDeclaredFields().forEach(field -> System.out.println(field.getName()));
    }

}
