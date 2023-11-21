package Task14.src;

public class Main {
    public static void main(String[] args) {
        CustomServer customServer = new CustomServer(8081);
        customServer.start();
        customServer.close();
    }
}
