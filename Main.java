import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        // 1. Одномерный массив e типа short
        short[] e = new short[7];
        for (int i = 0; i < e.length; i++) {
            e[i] = (short) (7 + 2 * i);
        }
        // 2. Одномерный массив x типа float
        float[] x = new float[11];
        Random random = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] = -8.0f + random.nextFloat() * 15.0f;
        }
        // Выводим исходные массивы для проверки
        System.out.println("e = " + Arrays.toString(e));
        System.out.println("x = " + Arrays.toString(x));
        System.out.println();
        // 3. Двумерный массив e1
        double[][] e1 = new double[e.length][x.length];
        // Заполняем e1
        for (int i = 0; i < e.length; i++) {
            for (int j = 0; j < x.length; j++) {
                e1[i][j] = calculateElement(e[i], x[j]);
            }
        }
        // 4. Выводим двумерный массив
        printMatrix(e1);
    }
    // Вычисление одного элемента e1[i][j]
    static double calculateElement(short e, float x) {
        // Если e[i] == 17
        if (e == 17) {
            // последовательно считаем первую формулу
            double denominator = x - 0.25;
            double exponent = (2.0 / 3.0) / denominator;
            double power = Math.pow(x, exponent);
            double firstTan = Math.tan(power);
            double result = Math.tan(firstTan);
            return result;
        }
        // Если e[i] принадлежит {9, 13, 19}
        else if (e == 9 || e == 13 || e == 19) {
            double firstSin = Math.sin(x);
            double secondSin = Math.sin(firstSin);
            double thirdSin = Math.sin(secondSin);
            return thirdSin;
        }
        // Остальные значения e:
        else {
            // x * (π + x)
            double firstPart = x * (Math.PI + x);
            // (x * (π + x))^2
            double square = Math.pow(firstPart, 2);
            // sin((x * (π + x))^2)
            double sinPart = Math.sin(square);
            // (x / 3)^x
            double xPower = Math.pow(x / 3.0, x);
            // tan(x)
            double tanX = Math.tan(x);
            // (tan(x))^((x / 3)^x)
            double tanPower = Math.pow(tanX, xPower);
            // 1/3 + (tan(x))^((x / 3)^x)
            double exponent = 1.0 / 3.0 + tanPower;
            // sin(...) в полученной степени
            double numerator = Math.pow(sinPart, exponent);
            // Деление на 0.5
            double fraction = numerator / 0.5;
            // e^(sin(x))
            double firstExp = Math.exp(Math.sin(x));
            // e^(e^(sin(x)))
            double secondExp = Math.exp(firstExp);
            // Итоговое значение элемента e1[i][j]
            double result = Math.pow(fraction, secondExp);
            return result;
        }
    }
    // Отдельный метод для вывода двумерного массива
    static void printMatrix(double[][] e1) {
        for (int i = 0; i < e1.length; i++) {
            for (int j = 0; j < e1[i].length; j++) {
                // 5 знаков после запятой
                System.out.printf("%12.5f ", e1[i][j]);
            }
            System.out.println();
        }
    }
}