package office;

public class Office extends Object {
    protected double size;
    private String name;

    public Office(double size, String name) {
        this.size = Math.abs(size);
        this.name = name;
    }

    protected final void setSize(double newSize) {
        this.size = newSize;
    }

    public double getSize() {
        return this.size;
    }

    public abstract void setName(String newName) {
        this.name = newName;
    }
}
