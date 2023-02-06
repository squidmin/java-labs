package instances;

public enum EnumSingleton {

    INSTANCE("Initial class info");

    private String info;

    private EnumSingleton(String info) { this.info = info; }  // Private constructor.

    public EnumSingleton getInstance() { return INSTANCE; }

    // getters and setters

}
