package src.superprep;

public class SuperParent {
    String sp;

    public SuperParent(String sp) {
        this.sp = sp;
    }
    
    public SuperParent() {
        this("implicit super parent");
    }
}
