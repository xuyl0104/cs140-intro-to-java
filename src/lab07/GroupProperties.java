package lab07;

public class GroupProperties {
    private int sum;
    private int product;
    private double average;
    public GroupProperties(int s, int p, double a) {
        sum = s;
        product = p;
        average = a;
    }
    public int getSum() {
        return sum;
    }
    public int getProduct() {
        return product;
    }
    public double getAverage() {
        return average;
    }
    
    public void printPerperties() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "GroupProperties [" + sum + ", " + product + ", " + average + "]";
    }
}
