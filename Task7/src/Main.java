package Task7.src;

public class Main {
    public static void main(String[] args) {
        ArrayValueCalculator calculator = new ArrayValueCalculator();
//        String[][] array = {{"10", "14", "1", "5"},
//                {"7", "101", "75", "3"},
//                {"-100", "101", "34", "3"},
//                {"33", "5", "3", "-8"}
//        };
        String[][] array = {{"10", "14", "1", "5"},
                {"7", "101", "75", "ииии"},
                {"-100", "101", "34", "3"},
                {"33", "5", "3", "-8"}
        };

        try {
            int sum = calculator.doCalc(array);
            System.out.println("Сума всіх елементів масиву = " + sum);
        } catch (ArrayDataException e) {
            System.out.println("Помилка даних в комірці [" + e.getRow() + "][" + e.getCol() + "] : " + e.getMessage());
        } catch (ArraySizeException e) {
            System.out.println("Помилка в розмірі масиву : " + e.getMessage());
        }


    }
}