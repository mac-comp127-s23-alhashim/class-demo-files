package furniture;

public abstract class Furniture extends Object {
    public double price;
    private String color;

    public Furniture(double price, String color) { 
        setPrice(price);
        this.color = color;
    }

    public abstract double getPrice();

    public final void setPrice(double newPrice) {
        if(newPrice<0) {
            this.price = -1*newPrice;
        }
        else {
            this.price = newPrice;
        }
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }
}
