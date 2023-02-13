package furniture;

public class Furniture {
    private double price;
    private String color;

    public Furniture(double price, String color) { 
        setPrice(price);
        this.color = color;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double newPrice) {
        if(newPrice<0) {
            this.price = -1*newPrice;
        }
        else {
            this.price = newPrice;
        }
    }
}
