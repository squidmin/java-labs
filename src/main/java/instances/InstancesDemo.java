package instances;

class Parent {
    Parent() {}
    public void method() {
        System.out.println("Parent class method.");
    }
}

class Child extends Parent {
    Child() {}
    public void method() {
        System.out.println("Child class method.");
    }
}

public class InstancesDemo extends Parent {

    // This instance variable is visible for any child class.
    public String field_1;

    // field_2 variable is visible in Instances class only.
    private double field_2;

    // Can be accessed within its own package, and within any subclass of the Instances class.
    protected int field_3;

    // The name variable is assigned in the constructor.
    public InstancesDemo(String field_1) {
        this.field_1 = field_1;
    }

    // The field_2 variable is assigned a value.
    public void setField_2(double field_2) {
        this.field_2 = field_2;
    }

    // This method prints the instance field values.
    public void printFields() {
        System.out.println("field_1: " + field_1);
        System.out.println("field_2: " + field_2);
    }

    public static void main(String[] args) {
        InstancesDemo instance = new InstancesDemo("lol");
        instance.setField_2(1000);
        instance.printFields();

        // Polymorphism
        Parent parentInstance_1 = new Child();
        Parent parentInstance_2 = new InstancesDemo("field_1");
        parentInstance_1.method();  // Calls method() of Child class.
        parentInstance_2.method();  // Calls method() of Parent class.
    }

}
