package Task7.src;

import java.util.Arrays;

public class ArrayValueCalculator {
    public int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        if (array.length != 4 || !Arrays.stream(array).allMatch(row -> row.length == 4)) {
            throw new ArraySizeException("Розмір масива повинен бути 4х4");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Неможливо призвести до типу int значення " + '"' + array[i][j] + '"', i, j);
                }
            }
        }
        return sum;

    }
}
