// Java program for implementation of QuickSort 
class QuickSort
{
    public static void sort(int[] array) {
        final long startTime = System.nanoTime();
        sort(array, 0, array.length-1);

        final long duration = System.nanoTime() - startTime;
        final double seconds = ((double) duration / 1000000000);

        // Estimate the measuring time
        System.out.format("Estimated meassuretime: %f seconds. \n\n\n", seconds);
    }

    /* The function that implements QuickSort
     */
    static void sort(int[] arrayToSort, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arrayToSort, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arrayToSort, low, pi-1);
            sort(arrayToSort, pi+1, high);
        }
    }

    /* The function that chooses a pivot and partitions the data
     */
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot 
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j] 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}