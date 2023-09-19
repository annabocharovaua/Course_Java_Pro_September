package Task8.src;
import java.util.List;

public class ShapeAreaCalculator implements ShapeCollection{
    private List<Shape> shapes;
    private double totalArea;
    public ShapeAreaCalculator(List<Shape> shapes){
        this.shapes = shapes;
        this.totalArea = 0;
    }
    @Override
    public double getTotalArea() {
        for (Shape shape : shapes){
            totalArea+=shape.getArea();
        }
        return totalArea;
    }
}
