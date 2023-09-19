package Task8.src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //CIRCLE
        System.out.print("Введіть радіус кола: ");
        double circleRadius = scanner.nextDouble();
        Circle circle = new Circle(circleRadius);
        System.out.println("Площа кола = " + circle.getArea());

        //TRIANGLE
        System.out.print("Введіть сторону А трикутника: ");
        double sideA = scanner.nextDouble();
        System.out.print("Введіть сторону B трикутника: ");
        double sideB = scanner.nextDouble();
        System.out.print("Введіть сторону C трикутника: ");
        double sideC = scanner.nextDouble();
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        System.out.println("Площа трикутника = " + triangle.getArea());

        //SQUARE
        System.out.print("Введіть довжину сторони квадрата: ");
        double squareSide = scanner.nextDouble();
        Square square = new Square(squareSide);
        System.out.println("Площа квадрата = " + square.getArea());

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(square);


        ShapeAreaCalculator shapeCollection = new ShapeAreaCalculator(shapes);
        double totalArea = shapeCollection.getTotalArea();

        System.out.println("Площа всіх фігур = " + totalArea);

        scanner.close();
    }
}
