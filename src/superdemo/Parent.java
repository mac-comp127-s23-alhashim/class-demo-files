package src.superdemo;

public class Parent extends SuperParent {
    String p;

    public Parent() {
        super();
        this.p = "parent";
    }

    public Parent(String p) {
        super("super parent from parent");
        this.p = p;
    }
}
