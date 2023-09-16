package Task3.src;

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобік");
        Cat catKuzia = new Cat("Кузя");

        dogBobik.run(150);
        dogBobik.swim(5);
        dogBobik.run(550);
        dogBobik.swim(20);

        catKuzia.run(200);
        catKuzia.run(260);
        catKuzia.swim(8);

        System.out.println("Загальна кількість тварин: " + Animal.getAnimalCount());
    }
}