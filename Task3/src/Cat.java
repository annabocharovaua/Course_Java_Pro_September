package Task3.src;

public class Cat extends Animal{
    public Cat(String name){
        super(name, 0, 200);
    }
    @Override
    public void swim(int distance){
        System.out.println(name + " не вміє плавати");
    }

}
