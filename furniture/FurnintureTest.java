package furniture;

public class FurnintureTest {
    public static void main(String[] args) {
        Furniture fur1 = new Furniture(-100.5, "Red");
        // fur1.price = -100.5;
        // fur1.color = "Red";
        System.out.println(fur1.getPrice());
        fur1.setPrice(-500);
        System.out.println(fur1.getPrice());
    }
}
