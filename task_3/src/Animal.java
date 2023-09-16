public class Animal {
    public String name;
    public int maxSwimDistance;
    public int maxRunDistance;
    static int animalCount = 0;


    public Animal(String name, int maxSwimDistance, int maxRunDistance){
        this.name = name;
        this.maxSwimDistance = maxSwimDistance;
        this.maxRunDistance = maxRunDistance;
        animalCount++;
    }
    public void run(int distance){
        if(distance<=maxRunDistance){
            System.out.println(name + " пробіг " + distance + " м");
        } else {
            System.out.println(name + " не може пробігти цю дистанцію, максимальна мажлива дистанція: " + maxRunDistance + " м");
        }
    }
    public void swim(int distance){
        if(distance<=maxSwimDistance){
            System.out.println(name + " проплив " + distance + " м");
        } else {
            System.out.println(name + " не може проплисти цю дистанцію, максимальна мажлива дистанція для тварини: " + maxRunDistance + " м");
        }
    }
    public static int getAnimalCount(){
         return animalCount;
    }
}