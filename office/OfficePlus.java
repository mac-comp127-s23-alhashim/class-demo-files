package office;

public class OfficePlus extends Office {
    private String color;

    public OfficePlus(double size, String name, String color) {
        super(size, name);
        this.color = color;
    }

    protected void setSize(double newSize, double x) {
        super.setSize(newSize*2);
    }
}
