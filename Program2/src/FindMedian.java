/**
 * CSCI 340 Homework 2 Part 1
 * @author Kevin Lee
 * @Due_Date Mar 7 2021
 */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;


public class FindMedian {
    public static double findMedian (int [] array){
        double median;
        sort(array);    //sort at least amount in array to find median
        if(array.length %2 == 0)
            median = ((double) array[array.length/2+1] + array[array.length/2]) /2 ;
        else
            median = array[array.length/2];
        return median;
    }

    public static void sort(int[] a) {

        sort(a, 0, a.length - 1);
    }

    //Quicksort from a[lo] to a[hi]
    private static void sort(int[] a, int lo, int hi) {

        int j = partition(a,lo,hi);

        if(j < a.length/2)          // if we have pivot's index which is lower or higher than center's index,
            sort(a, j+1, hi);    // then we don't have to quicksort left or right side of array anymore.
        else if(j > a.length/2)
            sort(a, lo, j-1);
        else
            return;
    }
    // partition the subarray arr[lo..hi] so that arr[lo..i] <= arr[i+1] <= arr[i+2..hi]
    // and return the index i+1.
        private static int partition(int[] arr, int lo, int hi) {
            int n = hi - lo + 1;
            int m = median3(arr, lo, lo + n/2, hi);
            int pivot = arr[m];    //Set pivot as median of 3 arrays values.
            int i = lo -1;     //Index of smaller value and indicates right position of pivot.


            for(int t = lo; t < hi; t++)
            {
                if(arr[t] < pivot){
                    i++;
                    swap(arr,i,t);
                }
            }
            swap(arr,i+1,m);
            return (i+1);
        }

    // swap arr[i] and arr[j]
    private static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    // return the index of the median element among arr[i], arr[j], and arr[k]
    private static int median3(int[] arr, int i, int j, int k) {
        if(arr[i] < arr[j]) {
            if (arr[k] < arr[i])
                return i;
            else if(arr[j] < arr[k])
                return j;
            else return k;
        }
        else{
            if (arr[k] < arr[j])
                return j;
            else if(arr[i] < arr[k])
                return i;
            else return k;

        }

    }

    //main
    public static void main (String [] args) throws Throwable    {
        int[] size = {10, 50, 1000000, 5000000};
        // Sort and print a few small arrays to make certain the sort works
        SortandMedian(size[0], size[1], 10);
        // Sort and time larger arrays
        SortandMedian(size[2], size[3], 1000000);
        // Sort and time larger arrays
        SortandMedian(size[2]+1, size[3]+1, 1000000);
    }

    //print array size, median, and nanotime.
    public static void SortandMedian(int start, int end, int inc) throws Throwable {
        double result;
        for (int size = start; size<=end; size+=inc) {

            int [] array = createRandomArray(size);
            System.gc();

            long startTime = System.nanoTime();
            result = findMedian(array);     //call findmedian
            long endTime = System.nanoTime();

            System.out.println ("Array size = " + size +
                    "\tMedian = " + result +
                    "\tSearch time = " +
                    (endTime-startTime)/1000000000.0 + " seconds");
        }
    }
    public static int[] createRandomArray(int size) throws Throwable    {
        Random r = new Random(50);
        int [] array = new int [size];

        for (int i=0; i<size; i++)  {
            array[i] = StdRandom.uniform(100000);
        }

        return array;
    }


}
