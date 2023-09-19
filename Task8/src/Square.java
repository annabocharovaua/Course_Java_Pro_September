package Task8.src;

public class Square implements Shape{
    private double side;
    public Square (double side){
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public double getArea(){
        return side*side;
    }
}
