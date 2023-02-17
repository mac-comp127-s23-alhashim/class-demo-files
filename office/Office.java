package office;

public class Office {
    private double size;
    private String name;

    public Office(double size, String name) {
        this.size = Math.abs(size);
        this.name = name;
    }

    protected void setSize(double newSize) {
        this.size = newSize;
    }

    public double getSize() {
        return this.size;
    }
}
