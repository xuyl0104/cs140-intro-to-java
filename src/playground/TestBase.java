package playground;

public class TestBase {
    private int a;
    private int b;

    public TestBase() {
        a = 10;
        b = 10;
    }
    
    public TestBase(int aVal, int bVal) {
        a = aVal;
        b = bVal;
    }

    public void setA(int aVal) {
        a = aVal;
    }

    public void setB(int bVal) {
        b = bVal;
    } 

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void funcToBeOverloaded(int aVal, int bVal) {
        System.out.println(aVal + bVal);
    }

    @Override
    public String toString() {
        return "A is: " + a + "; B is: " + b;
    }
}
