package reflection;

import lombok.Setter;

import java.lang.reflect.Field;

@Setter
public class IsBlankExample {

    private String fieldA;
    private String fieldB;
    private String fieldC;
    private String fieldD;

    public boolean isBlank() {
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.get(this) != null && field.get(this) != "") {
                    return false;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsBlankExample instance = new IsBlankExample();
        instance.setFieldA(null);
        instance.setFieldB(null);
        instance.setFieldC("");
        instance.setFieldD("");
        System.out.println(instance.isBlank());
    }

}
