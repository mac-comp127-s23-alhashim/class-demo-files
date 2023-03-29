package src.furniture;

public class FurniturePlus extends Furniture {
    private double weight;
    private int price;

    public FurniturePlus(double price, String color, double weight) {
        // this.price = price;
        // this.color = color;
        super(price, color);
        this.weight = weight;
    }

    // public FurniturePlus() {
    //     setColor("Red");
    // }
    public double getPrice() {
        return  this.price;
    }
}
