package playground;

public class Constructors {
    private int param1 = 0;
    private String param2 = "hi";

    public Constructors() {
        param1 = 2;
        param2 = "hello";
    }

    public Constructors(int param1Value, String param2Value) {
        param1 = param1Value;
        param2 = param2Value;
    }

    public void setParam1(int newParam) {
        param1 = newParam;
    }

    @Override
    public String toString() {
        return "Parameter 1 is: " + param1 + "; Parameter 2 is: " + param2 + ".";
    }

    public static void main(String[] args) {
        Constructors instance1 = new Constructors();
        System.out.println(instance1);

        Constructors instance2 = new Constructors(10, "Hello World!");
        System.out.println(instance2);

        Constructors instance3 = instance2;
        System.out.println(instance3);
        instance3.setParam1(20);
        System.out.println(instance2);
        System.out.println(instance3);


    }
}