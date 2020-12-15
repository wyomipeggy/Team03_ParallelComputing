 import java.util.ArrayList;
 import java.util.List;

 /**
 * Parallel-Computing Bucket Sort
 * AUTHORS: D. Vermaas & W. Beuker
 */

 public class BucketSort {

    private static final int DEFAULT_BUCKET_SIZE = 5;
    private static int currentIndex = 0;

    public static void sort(int[] array) {
        sort(array, DEFAULT_BUCKET_SIZE);
    }

    static void sort(int[] arrayToSort, int bucketSize) {


        System.out.println("Do Bucketsort with " + arrayToSort.length + " integers \n");

        //Start timer
        final long startTime = System.nanoTime();

        if (arrayToSort.length == 0) {
            return;
        }

        //Deside min and max value
        int minValue = arrayToSort[0];
        int maxValue = arrayToSort[0];
        for (int i = 1; i < arrayToSort.length; i++) {
            if (arrayToSort[i] < minValue) {
                minValue = arrayToSort[i];
            } else if (arrayToSort[i] > maxValue) {
                maxValue = arrayToSort[i];
            }
        }

        Integer finalMinValue = minValue;
        Integer finalMaxValue = maxValue;

        //executorService.execute(() -> {

            // Initialise buckets
            int bucketCount = (finalMaxValue - finalMinValue) / bucketSize + 1;
            List<List<Integer>> buckets = new ArrayList<>(bucketCount);

            for (int i = 0; i < bucketCount; i++) {
                buckets.add(new ArrayList<>());
            }

            //Destribute input over the buckets
            for (Integer anArrayElement : arrayToSort) {
                buckets.get((anArrayElement - finalMinValue) / bucketSize).add(anArrayElement);

            }

            //Sort the buckets and fill the input array
            //Loop though the content of each bucket
            for (List<Integer> bucket : buckets) {

                Integer[] bucketArray = new Integer[bucket.size()];

                bucketArray = bucket.toArray(bucketArray);

                sort(bucketArray);

                for (Integer aBucketArray : bucketArray) {
                    arrayToSort[currentIndex] = aBucketArray;
                    incrementSync();
                }
            }

        final long duration = System.nanoTime() - startTime;
        final double seconds = ((double) duration / 1000000000);

        // Estimate the measuring time
        System.out.format("Estimated meassuretime: %f seconds. \n\n\n", seconds);

    }

    /**
     * Synchroniseer de incrementatie van de huidige index
     */
    static synchronized void incrementSync() {
        currentIndex = currentIndex + 1;
    }

     /**
      * Insertion sort
      */
    static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T item = array[i];
            int index = i;
            while (index > 0 && array[index - 1].compareTo(item) > 0) {
                array[index] = array[--index];
            }
            array[index] = item;
        }
    }
}


