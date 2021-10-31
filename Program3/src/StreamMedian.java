import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedian {

    private PriorityQueue<Integer> smaller;
    private PriorityQueue<Integer> bigger;
    private int numOfElements;

    public StreamMedian(){
        //smaller pq uses MaxHeapComparator to be a max heap.
        smaller = new PriorityQueue<Integer>(5, new MaxHeapComparator());
        //bigger pq uses default priority queue to be a min heap.
        bigger =  new PriorityQueue<>();
        //To determine the total size of pqs.
        numOfElements = 0;
    }

    public void insert(Integer i){
        smaller.add(i);
        if(numOfElements%2 == 0)        // if the elements number is even, add into smaller pq
        {                               // and compare the roots between smaller and bigger
            if(bigger.isEmpty()){       // in order to put a half of small elements in smaller
                numOfElements++;        // and the other half in bigger.
                return;
            }
            else if(smaller.peek() > bigger.peek()){
                Integer maxSmaller = smaller.poll();
                Integer minBigger = bigger.poll();
                smaller.add(minBigger);
                bigger.add(maxSmaller);
            }
        }
        else{                          // if the elements number is odd, poll root from smaller
            bigger.add(smaller.poll());// and put the element in bigger.
        }
        numOfElements++;
    }

    public double getMedian(){
        if(numOfElements %2 != 0)       // if a number of elements is odd, root of smaller will be median
            return (double)(smaller.peek());
        else                                                 // if a number of elements is even, average of smaller root
            return ((smaller.peek() + bigger.peek())/2.0);   // and bigger root will be median
    }

    //Comparator implementation to build max heap.
    private class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
