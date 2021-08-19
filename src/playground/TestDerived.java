package playground;

public class TestDerived extends TestBase {
    private int c;

    public TestDerived() {
        c = 10;
    }

    public TestDerived(int aVal, int bVal, int cVal) {
        super(aVal, bVal);
        c = cVal;
    }

    public void setC(int cVal) {
        c = cVal;
    }

    public int getC() {
        return c;
    }

    public void funcToBeOverloaded(int aVal, int bVal, int cVal) {
        System.out.println(aVal + bVal + cVal);
    }

    public String toString() {
        return "a is: " + getA() + "; b is: " + getB() + "; c is: " + c; 
    }

    public static void main(String[] args) {
        TestBase base = new TestBase();
        System.out.println(base);
        base.funcToBeOverloaded(55, 56);

        TestDerived derived = new TestDerived();
        System.out.println(derived);
        derived.funcToBeOverloaded(25, 26);
        derived.funcToBeOverloaded(33, 35, 37);
        
        TestDerived derived2 = new TestDerived(20, 30, 40);
        System.out.println(derived2);
        derived2.funcToBeOverloaded(250, 260);
        derived2.funcToBeOverloaded(330, 350, 370);
    }
}
