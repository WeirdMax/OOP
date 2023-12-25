
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Array3d<Integer> array = new Array3d<>(3, 3, 3);
        System.out.println(array.toString());

        List<Integer> values0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        array.setValues0(1, values0);
        System.out.println(array.toString());

        List<Integer> values1 = Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17, 18);
        array.setValues1(2, values1);
        System.out.println(array.toString());

        List<Integer> values2 = Arrays.asList(19, 20, 21, 22, 23, 24, 25, 26, 27);
        array.setValues2(0, values2);
        System.out.println(array.toString());

        List<Integer> values01 = Arrays.asList(28, 29, 30);
        array.setValues01(0, 1, values01);
        System.out.println(array.toString());

        List<Integer> values02 = Arrays.asList(31, 32, 33);
        array.setValues02(2, 0, values02);
        System.out.println(array.toString());

        List<Integer> values12 = Arrays.asList(34, 35, 36);
        array.setValues12(1, 2, values12);
        System.out.println(array.toString());

        Array3d<Integer> filledArray = array.fill(2, 2, 2, 42);
        System.out.println(filledArray.toString());

    }
}