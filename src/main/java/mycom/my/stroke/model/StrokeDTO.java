package mycom.my.stroke.model;

public class StrokeDTO {
    private int nn;
    private double price;
    private String nameOfstroke;

    public StrokeDTO() {
        super();
    }

    public StrokeDTO(int nn, double price, String nameOfstroke) {
        this.nn = nn;
        this.price = price;
        this.nameOfstroke = nameOfstroke;
    }

    public int getNn() {
        return nn;
    }

    public void setNn(int nn) {
        this.nn = nn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameOfstroke() {
        return nameOfstroke;
    }

    public void setNameOfstroke(String nameOfstroke) {
        this.nameOfstroke = nameOfstroke;
    }

    @Override
    public String toString() {
        return "StrokeDTO{" + "nn=" + nn + ", price=" + price + ", nameOfstroke=" + nameOfstroke + '}';
    }
    
    
    
}