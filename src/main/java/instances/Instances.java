package instances;

public class Instances {

    // This instance variable is visible for any child class.
    public String field_1;

    // field_2 variable is visible in Instances class only.
    private double field_2;

    // The name variable is assigned in the constructor.
    public Instances(String field_1) {
        this.field_1 = field_1;
    }

    // The field_2 variable is assigned a value.
    public void setField_2(double field_2) {
        this.field_2 = field_2;
    }

    // This method prints the instance field values.
    public void printFields() {
        System.out.println("field_1: " + field_1);
        System.out.println("field_2:" + field_2);
    }

    public static void main(String[] args) {
        Instances instance = new Instances("lol");
        instance.setField_2(1000);
        instance.printFields();
    }

}
