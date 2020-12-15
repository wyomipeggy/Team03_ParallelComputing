import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;

/**
 * Parallel Computing main
 * AUTHORS: D. Vermaas & W. Beuker
 */

public final class main {

    //private static final int RUNS = 6;
    private static int ARRAY_LENGTH = 100;
    private static int TEST_ARRAY[] = ArrayGenerator();


    public static void main(final String... args) {

//        // START- BucketSort
//        System.out.println("---- BucketSort ----");
//        System.out.println("Before: " + Arrays.toString(ArrayGenerator()));
//        BucketSort.sort(TEST_ARRAY);
//        System.out.println("After: " + Arrays.toString(TEST_ARRAY));
//        System.out.println("Is Sorted: " + sortingCheck(TEST_ARRAY));
//        // END- BucketSort

        // START- QuickSort
        System.out.println("---- QuickSort ----");
        System.out.println("Before: " + Arrays.toString(ArrayGenerator()));
        QuickSort.sort(TEST_ARRAY);
        System.out.println("After: " + Arrays.toString(TEST_ARRAY));
        System.out.println("Is Sorted: " + sortingCheck(TEST_ARRAY));
        // END- QuickSort

    }

    private static boolean sortingCheck(int[] array)
    {
        for ( int i = 0; i < array.length - 1 ; i++ ) {
            if ( array[i] > array[i+1] )
                return false;
        }
        return true;
    }

    public static int[] ArrayGenerator(){
        ArrayList<Integer> list = new ArrayList<>(ARRAY_LENGTH);
        for (int i = 0; i <= ARRAY_LENGTH; i++){
            list.add(i);
        }

        int[] array = new int[ARRAY_LENGTH];
        for (int count = 0; count < ARRAY_LENGTH; count++){
            array[count] = list.remove((int)(Math.random() * list.size()));
        }
        return array;
    }
}