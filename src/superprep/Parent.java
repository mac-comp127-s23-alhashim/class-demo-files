package src.superprep;

public class Parent extends SuperParent {
    String p;

    public Parent(String p) {
        super("super parent");
        this.p = p;
    }

    public Parent() {
        this("implicit parent");

    }
}