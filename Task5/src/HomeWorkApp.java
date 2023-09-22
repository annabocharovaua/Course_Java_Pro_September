package Task5.src;

public class HomeWorkApp {
    public static void main(String[] args){

        //2
        System.out.println("Task2");
        String[] words = {"Orange", "Banana", "Apple"};
        printTreeWords(words);

        //3
        System.out.println('\n'+"Task3");
        checkSumSign(5,6);
        checkSumSign(5,-10);

        //4
        System.out.println('\n'+"Task4");
        printColor(0);
        printColor(100);
        printColor(2545);

        //5
        System.out.println('\n'+"Task5");
        compareNumbers(10, 10);
        compareNumbers(10, 15);

        //6
        System.out.println('\n'+"Task6");
        System.out.println(sumInRange(10, 5));
        System.out.println(sumInRange(10, -15));

        //7
        System.out.println('\n'+"Task7");
        checkPositiveOrNegative(10);
        checkPositiveOrNegative(0);
        checkPositiveOrNegative(-1000);

        //8
        System.out.println('\n'+"Task8");
        System.out.println(isNegative(0));
        System.out.println(isNegative(-1000));

        //9
        System.out.println('\n'+"Task9");
        printStringRepeatedly("Course Java Pro", 5);

        //10
        System.out.println('\n'+"Task10");
        isLeapYear(2004);
        isLeapYear(2000);
        isLeapYear(2023);
    }
    public static void printTreeWords(String[] words){
        for(String word: words){
            System.out.println(word);
        }
    }

    public static void checkSumSign(int a, int b){
        int sum = a + b;
        if(sum>=0) System.out.println("Сума позитивна");
        else System.out.println("Сума негативна");
    }

    public static void printColor(int value){
        if(value<=0) System.out.println("Червоний");
        else if(value >0 && value<=100) System.out.println("Жовтий");
        else System.out.println("Зелений");
    }

    public static void compareNumbers(int a, int b) {
        if(a>=b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
    public static boolean sumInRange(int a, int b){
        int sum = a + b;
        return sum>=10 && sum<=20;
    }

    public static void checkPositiveOrNegative(int a){
        if(a>=0) System.out.println( a+ " - додатнє число");
        else System.out.println( a + " - від'ємне число");
    }

    public static boolean isNegative(int a){
        return a<0;
    }

    public static void printStringRepeatedly(String str, int n){
        for (int i=0; i<=n; i++){
            System.out.println(str);
        }
    }

    public static void isLeapYear(int year){
        if((year %4 ==0 && year % 100!=0)|| (year % 400 == 0)) System.out.println(year + " - високосний рік");
        else System.out.println(year + " -  не високосний рік");
    }
}
