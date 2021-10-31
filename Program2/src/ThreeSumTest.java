import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ThreeSumFast;

import java.util.Arrays;
import java.util.Random;

public class ThreeSumTest {
    public static void main (String [] args) throws Throwable    {
        double result;
        int[] size = {1000, 2000, 4000, 8000, 16000, 32000};
        // Sort and print a few small arrays to make certain the sort works
        for(int i = 0; i < size.length; i++)
        CountThreeSum(size[i]);
    }

    public static void CountThreeSum(int size) throws Throwable {

            int [] array = createRandomArray(size);
            System.gc();

            long startTime = System.nanoTime();
            count(array);
            long endTime = System.nanoTime();

            System.out.println (
                    "\tSearch time = " +
                    (endTime-startTime)/1000000000.0 + " seconds");
    }
    public static int[] createRandomArray(int size) throws Throwable    {
        int [] array = new int [size];

        for (int i=0; i<size; i++)  {
            array[i] = StdRandom.uniform(100000);
        }

        return array;
    }
    public static int count(int[] a) {
        int n = a.length;
        Arrays.sort(a);
//        if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) count++;
            }
        }
        return count;
    }
}
