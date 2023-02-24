package instances;

public enum EnumSingletonDemo {

    INSTANCE("Ok I pull up. (Initial class info)");

    private String info;

    private EnumSingletonDemo(String info) { this.info = info; }  // Private constructor.

    public EnumSingletonDemo getInstance() { return INSTANCE; }

    // getters and setters

}
