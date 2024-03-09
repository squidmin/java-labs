package generics;

class ColoredBox<T> extends Box<T> {
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

public class GenericInheritance {

    public static void main(String[] args) {
        ColoredBox<Integer> box = new ColoredBox<>();
        box.setValue(10);
        box.setColor("Red");
        System.out.println("Value: " + box.getValue());
        System.out.println("Color: " + box.getColor());
    }

}
